package com.percolate.sdk.api.utils;

import com.percolate.sdk.api.PercolateApi;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.security.GeneralSecurityException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.CertificatePinner;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Code to hide away Retrofit logic and implementation details. It configures
 * Retrofit by setting an application interceptor and sets the Jackson Converter factory.
 */
@SuppressWarnings("WeakerAccess")
public class RetrofitLogic {

    public static final int CACHE_MAX_AGE = 21600; //6hr

    /**
     * {@link Retrofit}
     */
    private static Retrofit retrofit = null;

    /**
     * Context.
     */
    private final PercolateApi context;

    /**
     * User Agent String.
     */
    private String userAgentString = "percolate-java-sdk/v" + PercolateApi.VERSION_NUMBER;

    /**
     * Construct instance.
     */
    public RetrofitLogic(@NotNull PercolateApi context) {
        this.context = context;
        if(context.getUserAgentPrefix() != null) {
            userAgentString = context.getUserAgentPrefix().concat(userAgentString);
        }
    }

    /**
     * Lazy load Retrofit.
     */
    protected Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(context.getSelectedServer().getTransport() + "://" + context.getSelectedServer().getDomain() + "/")
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(JacksonConverterFactory.create())
                    .client(createOkHttpClient())
                    .build();
        }
        return retrofit;
    }

    /**
     * Creates an OkHttpClient object and sets an application level interceptor that
     * adds the User-Agent and Authorization headers to each request.
     *
     * @return OkHttpClient {@link OkHttpClient}
     */
    public OkHttpClient createOkHttpClient() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();

        try {
            // Enhance default TrustManager for Percolate certificates.
            final SSLContext sslContext = SSLContext.getInstance("TLS");
            final X509TrustManager enhancedTrustManager = PercolateTrustManagerBuilder.build();
            sslContext.init(null, new TrustManager[]{enhancedTrustManager}, null);
            okHttpClientBuilder.sslSocketFactory(sslContext.getSocketFactory(), enhancedTrustManager);
        } catch (GeneralSecurityException e) {
            System.err.println("Error: RetrofitLogic#createOkHttpClient: Could not enhance trustManager" + e);
        }

        // Enable local proxy (127.0.0.1:8888).
        if (context.getSelectedServer().getEnableLocalProxy()) {
            final Proxy proxy = new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved("127.0.0.1", 8888));
            okHttpClientBuilder.proxy(proxy);
        }

        // Add custom Interceptors.
        if (context.getSelectedServer().getCustomInterceptor() != null) {
            okHttpClientBuilder.interceptors().add(context.getSelectedServer().getCustomInterceptor());
        }

        // Enable caching.
        if (context.getSelectedServer().getCache() != null) {
            okHttpClientBuilder.cache(context.getSelectedServer().getCache());
            forceCacheControlHeaders(okHttpClientBuilder);
        }

        // Set timeout and retry settings.
        okHttpClientBuilder
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .retryOnConnectionFailure(false);

        okHttpClientBuilder.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request.Builder builder = request.newBuilder();
                builder.addHeader("User-Agent", userAgentString);
                if (StringUtils.isBlank(request.header("Authorization"))) {
                    if (isApiEndpoint(request.url())) {
                        if (StringUtils.isNotBlank(context.getOAuthTokenKey())) {
                            builder.addHeader("Authorization", "Bearer " + context.getOAuthTokenKey());
                        } else if (StringUtils.isNotBlank(context.getApiKey())) {
                            builder.addHeader("Authorization", context.getApiKey());
                        }
                    }
                }
                return chain.proceed(builder.build());
            }

            /**
             * @return {@code true} if the requested url starts with "/api".
             */
            private boolean isApiEndpoint(HttpUrl url) {
                return url.pathSegments() != null &&
                        !url.pathSegments().isEmpty() &&
                        url.pathSegments().get(0).equalsIgnoreCase("api");
            }
        });

        //SSL Pinning
        final CertificatePinner certificatePinner = new CertificatePinner.Builder()
                // certificate valid till 1st May 2019
                .add("percolate.com", "sha256/evbucDPd+voFR9afo6V93Ffxr2PF1M8oeGSBDC0uVR0=")
                .add("*.percolate.com", "sha256/gd0jw5Y5beTzcXkn1mrr9b+Dri2kx2IIkML8vU5Xz04=")
                .build();
        okHttpClientBuilder.certificatePinner(certificatePinner);

        return okHttpClientBuilder.build();
    }

    /**
     * Percolate's API adds no-cache headers to requests.  Here we override them so that the okhttp framework
     * will cache response data.
     * <ul>
     *   <li>Requests with {@code &skip-cache=true} won't be modified to enable caching.</li>
     *   <li>Only GET requests will be modified to enable caching.</li>
     *   <li>Only 200 OK responses will be modified to enable caching.</li>
     * </ul>
     */
    private void forceCacheControlHeaders(final OkHttpClient.Builder okHttpClientBuilder) {
        okHttpClientBuilder.addNetworkInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                final Response originalResponse = chain.proceed(chain.request());
                final String cacheControlHeader = originalResponse.header("Cache-Control");
                final Request request = chain.request();
                final HttpUrl url = request.url();
                final boolean skipCache = StringUtils.isNotBlank(url.queryParameter("skip-cache"));
                final boolean isGetRequest = StringUtils.equalsIgnoreCase("GET", request.method());
                final boolean is200 = originalResponse.code() == 200;

                if (!skipCache && isGetRequest && is200 && (cacheControlHeader == null || cacheControlHeader.contains("max-age=0") || cacheControlHeader.contains("no-cache"))) {
                    return originalResponse.newBuilder()
                            .header("Cache-Control", "max-age=" + CACHE_MAX_AGE)
                            .build();
                } else {
                    return originalResponse;
                }
            }
        });
    }

    /**
     * Reset cached {@link #retrofit} instance.
     */
    public static void reset() {
        retrofit = null;
    }
}
