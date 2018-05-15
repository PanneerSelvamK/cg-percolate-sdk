package com.percolate.sdk.rxjava.request.license;

import com.percolate.sdk.api.PercolateApi;
import com.percolate.sdk.api.request.license.LicenseV3Params;
import com.percolate.sdk.api.request.license.LicenseV5Params;
import com.percolate.sdk.api.utils.RetrofitApiFactory;
import com.percolate.sdk.dto.LicensesV3;
import com.percolate.sdk.dto.LicensesV5;

import org.jetbrains.annotations.NotNull;

import rx.Observable;

/**
 * LicenseV3 request proxy.
 */
@SuppressWarnings("unused")
public class LicenseRequestRx {

    private LicenseServiceRx service;

    public LicenseRequestRx(@NotNull PercolateApi context) {
        this.service = new RetrofitApiFactory(context).getService(LicenseServiceRx.class);
    }

    /**
     * Query v3/licenses endpoint.
     *
     * @param params API params.
     * @return {@link Observable} object.
     */
    public Observable<LicensesV3> get(@NotNull final LicenseV3Params params) {
        return service.getV3(params.getParams());
    }

    /**
     * Query v5/license/ endpoint.
     *
     * @param params API params.
     * @return {@link Observable} object.
     */
    public Observable<LicensesV5> get(@NotNull final LicenseV5Params params) {
        return service.getV5(params.getParams());
    }
}
