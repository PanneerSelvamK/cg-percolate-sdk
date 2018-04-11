package com.percolate.sdk.api.request.license.users

import com.percolate.sdk.api.BaseApiTest
import com.percolate.sdk.dto.LicensePublishingSettings
import org.junit.Assert
import org.junit.Test

class LicenseSettingsRequestTest : BaseApiTest() {

    @Test
    fun testGet() {
        val licenseSettings = percolateApi
                .licenseSettings()
                .get("123")
                .execute()
                .body()

        Assert.assertNotNull(licenseSettings)
        Assert.assertFalse(licenseSettings!!.paused)
    }

    @Test
    fun testUpdate() {
        val licenseSettings = percolateApi
                .licenseSettings()
                .update("123", LicensePublishingSettings())
                .execute()
                .body()

        Assert.assertNotNull(licenseSettings)
        Assert.assertTrue(licenseSettings!!.paused)
    }
}
