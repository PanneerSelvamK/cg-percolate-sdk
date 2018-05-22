package com.percolate.sdk.api.request.license;

import com.percolate.sdk.api.PercolateApi;
import com.percolate.sdk.api.utils.RetrofitApiFactory;
import com.percolate.sdk.dto.LicensesV3;
import com.percolate.sdk.dto.LicensesV5;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;

/**
 * LicenseV3 request proxy.
 */
@SuppressWarnings("unused")
public class LicenseRequest {

    private LicenseService service;

    public LicenseRequest(@NotNull PercolateApi context) {
        this.service = new RetrofitApiFactory(context).getService(LicenseService.class);
    }

    /**
     * Query v3 license endpoint.
     *
     * @param params API params.
     * @return {@link Call} object.
     */
    public Call<LicensesV3> get(@NotNull final LicenseV3Params params) {
        return service.getV3(params.getParams());
    }

    /**
     * Query v5 license endpoint.
     *
     * @param params API params.
     * @return {@link Call} object.
     */
    public Call<LicensesV5> get(@NotNull final LicenseV5Params params) {
        return service.getV5(params.getParams());
    }
}
