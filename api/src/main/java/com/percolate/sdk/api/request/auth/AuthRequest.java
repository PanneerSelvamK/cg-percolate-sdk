package com.percolate.sdk.api.request.auth;

import com.percolate.sdk.api.PercolateApi;
import com.percolate.sdk.api.utils.RetrofitApiFactory;
import com.percolate.sdk.dto.AuthTokenData;
import com.percolate.sdk.dto.AuthTokenPostData;
import com.percolate.sdk.dto.AuthorizeData;
import com.percolate.sdk.dto.AuthorizePostData;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

/**
 * Auth/Login request proxy.
 */
@SuppressWarnings("unused")
public class AuthRequest {

    private AuthService service;

    public AuthRequest(@NotNull PercolateApi context) {
        this.service = new RetrofitApiFactory(context).getService(AuthService.class);
    }

    /**
     * Authorization request.
     *
     * @param authorizePostData Authorization data.
     * @return {@link Call} object.
     */
    public Call<AuthorizeData> authorize(@NotNull final AuthorizePostData authorizePostData) {
        return service.authorize("Client-ID " + authorizePostData.getExt().getClientId(), authorizePostData);
    }

    /**
     * Authorization token request
     *
     * @param params API params.
     * @param data Auth data.
     * @return {@link Call} object.
     */
    public Call<AuthTokenData> token(@NotNull final AuthTokenParams params, @NotNull final AuthTokenPostData data) {
        return service.token(params.tokenAuthHeader(), data);
    }

}
