package com.percolate.sdk.rxjava.request.tenant;

import com.percolate.sdk.api.PercolateApi;
import com.percolate.sdk.api.utils.RetrofitApiFactory;
import com.percolate.sdk.dto.Tenants;

import org.jetbrains.annotations.NotNull;

import rx.Observable;

/**
 * Task request proxy.
 */
@SuppressWarnings("unused")
public class TenantRequestRx {

    private TenantServiceRx service;

    public TenantRequestRx(@NotNull PercolateApi context) {
        this.service = new RetrofitApiFactory(context).getService(TenantServiceRx.class);
    }

    /**
     * Query v5/tenant/ endpoint.
     *
     * @return {@link Observable} object.
     */
    public Observable<Tenants> get() {
        return service.get();
    }
}
