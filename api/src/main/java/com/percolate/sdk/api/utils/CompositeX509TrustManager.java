package com.percolate.sdk.api.utils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;

import javax.net.ssl.X509TrustManager;

/**
 * Class used to merge more TrustManagers into one.
 */
public class CompositeX509TrustManager implements X509TrustManager {

    private final List<X509TrustManager> trustManagers;

    /**
     * Constructs new X509TrustManager based on the input list of the TrustManagers.
     * @param trustManagers list of TrustManagers of type {@link X509TrustManager}
     */
    public CompositeX509TrustManager(List<X509TrustManager> trustManagers) {
        this.trustManagers = ImmutableList.copyOf(trustManagers);
    }

    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        for (X509TrustManager trustManager : trustManagers) {
            try {
                trustManager.checkClientTrusted(chain, authType);
                return; // someone trusts them. success!
            } catch (CertificateException e) {
                // maybe someone else will trust them
            }
        }
        throw new CertificateException("None of the TrustManagers trust this certificate chain");
    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        for (X509TrustManager trustManager : trustManagers) {
            try {
                trustManager.checkServerTrusted(chain, authType);
                return; // someone trusts them. success!
            } catch (CertificateException e) {
                // maybe someone else will trust them
            }
        }
        throw new CertificateException("None of the TrustManagers trust this certificate chain");
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        ImmutableList.Builder<X509Certificate> certificates = ImmutableList.builder();
        for (X509TrustManager trustManager : trustManagers) {
            for (X509Certificate cert : trustManager.getAcceptedIssuers()) {
                certificates.add(cert);
            }
        }
        return Iterables.toArray(certificates.build(), X509Certificate.class);
    }
}
