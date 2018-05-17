package com.percolate.sdk.api.request.tenant;

import com.percolate.sdk.api.config.Endpoints;
import com.percolate.sdk.dto.Tenants;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Percolate v5/task API definition.
 */
interface TenantService {

    @GET(Endpoints.API_V5_PATH + "/tenant/")
    Call<Tenants> get();
}