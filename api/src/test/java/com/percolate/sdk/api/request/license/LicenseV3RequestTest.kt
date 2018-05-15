package com.percolate.sdk.api.request.license

import com.percolate.sdk.api.BaseApiTest
import org.junit.Assert
import org.junit.Test

class LicenseV3RequestTest : BaseApiTest() {

    @Test
    fun testGet() {
        val licenses = percolateApi
                .licenses()
                .get(LicenseV3Params())
                .execute()
                .body();

        val licensesList = licenses?.licenses
        Assert.assertNotNull(licensesList)
        Assert.assertEquals(4, licensesList!!.size.toLong())
    }
}
