package com.percolate.sdk.api.request.authorization

import com.percolate.sdk.api.BaseApiTest
import com.percolate.sdk.api.request.license.LicenseV3Params
import org.junit.Assert
import org.junit.Test
import java.util.*

class UserRolesRequestTest : BaseApiTest() {

    @Test
    fun testGet() {
        val userRoles = percolateApi
                .userRoles()
                .get(UserRolesV5Params().userIds(Arrays.asList("123")))
                .execute()
                .body();

        Assert.assertNotNull(userRoles)
    }

    @Test
    fun testGetV5() {
        val userRoles = percolateApi
                .userRoles()
                .get(UserRolesV5Params())
                .execute()
                .body();

        fun testGet() {
            val licenses = percolateApi
                    .licenses()
                    .get(LicenseV3Params())
                    .execute()
                    .body();

            val data = userRoles?.data
            val userRolesInclude = userRoles?.include
            Assert.assertNotNull(data)
            Assert.assertNotNull(userRolesInclude?.role)
            Assert.assertEquals(11, data!!.size)
            Assert.assertEquals(4, userRolesInclude!!.role.size)

            Assert.assertNotNull(userRoles.getRoleForLicense("license:123456", licenses?.licenses))
            Assert.assertNull(userRoles.getRoleForLicense("license:9999", licenses?.licenses)) //LicenseV3 does not exist in JSON.
            Assert.assertTrue(userRoles.hasCapability("license:123456", "view:asset_library", licenses?.licenses))
            Assert.assertFalse(userRoles.hasCapability("license:123456", "does:not:exist", licenses?.licenses))
            Assert.assertFalse(userRoles.hasCapability("license:9999", "view:asset_library", licenses?.licenses))
        }
    }
}
