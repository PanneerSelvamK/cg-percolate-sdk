package com.percolate.sdk.api.request.license.users

import com.percolate.sdk.api.BaseApiTest
import org.junit.Assert
import org.junit.Test

class LicenseUsersRequestTest : BaseApiTest() {

    @Test
    fun testGet() {
        val licenseUsers = percolateApi
                .licenseUsers()
                .get(LicenseUsersParams("123"))
                .execute()
                .body();

        val data = licenseUsers?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(2, data!!.size.toLong())
    }
}
