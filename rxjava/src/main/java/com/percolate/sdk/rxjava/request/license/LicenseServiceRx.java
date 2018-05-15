package com.percolate.sdk.rxjava.request.license;

import com.percolate.sdk.api.config.Endpoints;
import com.percolate.sdk.dto.LicensesV3;
import com.percolate.sdk.dto.LicensesV5;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Percolate v3/licenses and v5/license/ API definition.
 */
interface LicenseServiceRx {

    @GET(Endpoints.API_V3_PATH + "/licenses")
    Observable<LicensesV3> getV3(@QueryMap Map<String, Object> params);

    @GET(Endpoints.API_V5_PATH + "/license/")
    Observable<LicensesV5> getV5(@QueryMap Map<String, Object> params);
}
