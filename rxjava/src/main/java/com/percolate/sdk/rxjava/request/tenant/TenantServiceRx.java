package com.percolate.sdk.rxjava.request.tenant;

import com.percolate.sdk.api.config.Endpoints;
import com.percolate.sdk.dto.Tenants;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Percolate v5/task API definition.
 */
interface TenantServiceRx {

    @GET(Endpoints.API_V5_PATH + "/tenant/")
    Observable<Tenants> get();
}
