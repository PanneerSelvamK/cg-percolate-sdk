package com.percolate.sdk.rxjava.request.license;

import com.percolate.sdk.api.config.Endpoints;
import com.percolate.sdk.dto.LicensesV3;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Percolate v3/licenses API definition.
 */
interface LicenseServiceRx {

    @GET(Endpoints.API_V3_PATH + "/licenses")
    Observable<LicensesV3> get(@QueryMap Map<String, Object> params);
}
