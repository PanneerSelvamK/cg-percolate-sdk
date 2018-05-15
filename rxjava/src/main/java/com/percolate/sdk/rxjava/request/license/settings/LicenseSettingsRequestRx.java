package com.percolate.sdk.rxjava.request.license.settings;

import com.percolate.sdk.api.PercolateApi;
import com.percolate.sdk.api.utils.RetrofitApiFactory;
import com.percolate.sdk.dto.LicensePublishingSettings;
import org.jetbrains.annotations.NotNull;
import rx.Observable;

/**
 * LicenseV3 settings request proxy.
 */
@SuppressWarnings("unused")
public class LicenseSettingsRequestRx {

    private LicenseSettingsServiceRx service;

    public LicenseSettingsRequestRx(@NotNull PercolateApi context) {
        this.service = new RetrofitApiFactory(context).getService(LicenseSettingsServiceRx.class);
    }

    /**
     * Query license settings endpoint.
     *
     * @param id LicenseV3 ID.
     * @return {@link Observable} object.
     */
    public Observable<LicensePublishingSettings> get(@NotNull final String id) {
        return service.get(id);
    }

    /**
     * Update license settings.
     *
     * @param id LicenseV3 ID.
     * @param body {@link LicensePublishingSettings} object.
     * @return {@link Observable} object.
     */
    public Observable<LicensePublishingSettings> update(@NotNull final String id, @NotNull final LicensePublishingSettings body) {
        return service.update(id, body);
    }
}
