package com.percolate.sdk.api.request.license

import com.percolate.sdk.api.BaseApiTest
import com.percolate.sdk.enums.LicenseStatus
import org.junit.Assert
import org.junit.Test

class LicenseV5RequestTest :BaseApiTest(){

    @Test
    fun testGet(){
        val licenses=percolateApi
                .licenses()
                .get(LicenseV5Params("testing_tenant_id"))
                .execute()
                .body();

        val licensesList=licenses?.licenses
        Assert.assertNotNull(licensesList)
        Assert.assertEquals(4,licensesList!!.size.toLong())
        Assert.assertEquals(3, licenses.justLicenses.size)
    }

    @Test
    fun testGetWithAllParams(){
        val licenseV5Params = LicenseV5Params(arrayOf("license:1231", "license:1232", "license:1234", "brand:1234"))
        licenseV5Params.limit(100)
        licenseV5Params.offset(0)
        licenseV5Params.statuses(LicenseStatus.ACTIVE)
        val licenses=percolateApi
                .licenses()
                .get(licenseV5Params)
                .execute()
                .body();

        val licensesList=licenses?.licenses
        Assert.assertNotNull(licensesList)
        Assert.assertEquals(4,licensesList!!.size.toLong())
        Assert.assertEquals(3, licenses.justLicenses.size)
    }
}
