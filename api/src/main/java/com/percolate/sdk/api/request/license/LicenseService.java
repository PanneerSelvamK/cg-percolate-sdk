package com.percolate.sdk.api.request.license;

import com.percolate.sdk.api.config.Endpoints;
import com.percolate.sdk.dto.LicensesV3;
import com.percolate.sdk.dto.LicensesV5;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Percolate v3/licenses API definition.
 */
interface LicenseService {

    @GET(Endpoints.API_V3_PATH + "/licenses")
    Call<LicensesV3> getV3(@QueryMap Map<String, Object> params);

    @GET(Endpoints.API_V5_PATH + "/license/")
    Call<LicensesV5> getV5(@QueryMap Map<String, Object> params);
}
