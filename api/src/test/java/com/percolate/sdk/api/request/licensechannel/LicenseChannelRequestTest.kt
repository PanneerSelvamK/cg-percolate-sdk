package com.percolate.sdk.api.request.licensechannel

import com.percolate.sdk.api.BaseApiTest
import com.percolate.sdk.dto.LicenseChannel
import org.junit.Assert
import org.junit.Test

class LicenseChannelRequestTest : BaseApiTest() {

    @Test
    fun testGet() {
        val licenseChannels = percolateApi
                .licenseChannels()
                .get(LicenseChannelParams())
                .execute()
                .body();

        val data = licenseChannels?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(2, data!!.size.toLong())
    }

    @Test
    fun testCreate() {
        val singleLicenseChannel = percolateApi
                .licenseChannels()
                .create(LicenseChannel())
                .execute()
                .body();

        Assert.assertNotNull(singleLicenseChannel?.data?.id)
    }
}
