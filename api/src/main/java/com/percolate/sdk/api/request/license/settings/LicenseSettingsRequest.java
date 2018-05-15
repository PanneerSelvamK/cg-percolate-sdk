package com.percolate.sdk.api.request.license.settings;

import com.percolate.sdk.api.PercolateApi;
import com.percolate.sdk.api.utils.RetrofitApiFactory;
import com.percolate.sdk.dto.LicensePublishingSettings;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

/**
 * LicenseV3 settings request proxy.
 */
@SuppressWarnings("unused")
public class LicenseSettingsRequest {

    private LicenseSettingsService service;

    public LicenseSettingsRequest(@NotNull PercolateApi context) {
        this.service = new RetrofitApiFactory(context).getService(LicenseSettingsService.class);
    }

    /**
     * Query license settings endpoint.
     *
     * @param id LicenseV3 ID.
     * @return {@link Call} object.
     */
    public Call<LicensePublishingSettings> get(@NotNull final String id) {
        return service.get(id);
    }

    /**
     * Update license settings.
     *
     * @param id LicenseV3 ID.
     * @param body {@link LicensePublishingSettings} object.
     * @return {@link Call} object.
     */
    public Call<LicensePublishingSettings> update(@NotNull final String id, @NotNull final LicensePublishingSettings body) {
        return service.update(id, body);
    }
}
