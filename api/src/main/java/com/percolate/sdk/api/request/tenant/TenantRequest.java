package com.percolate.sdk.api.request.tenant;

import com.percolate.sdk.api.PercolateApi;
import com.percolate.sdk.api.utils.RetrofitApiFactory;
import com.percolate.sdk.dto.Tenants;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;

/**
 * Task request proxy.
 */
@SuppressWarnings("unused")
public class TenantRequest {

    private TenantService service;

    public TenantRequest(@NotNull PercolateApi context) {
        this.service = new RetrofitApiFactory(context).getService(TenantService.class);
    }

    /**
     * Query v5/tenant endpoint.
     *
     * @return {@link Call} object.
     */
    public Call<Tenants> get() {
        return service.get();
    }
}
