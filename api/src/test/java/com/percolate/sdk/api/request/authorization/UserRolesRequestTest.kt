package com.percolate.sdk.api.request.authorization

import com.percolate.sdk.api.BaseApiTest
import com.percolate.sdk.api.request.license.LicenseParams
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
                    .get(LicenseParams())
                    .execute()
                    .body();

            Assert.assertNotNull(userRoles)
            Assert.assertNotNull(userRoles.data)
            Assert.assertNotNull(userRoles.include)
            Assert.assertNotNull(userRoles.include.role)
            Assert.assertEquals(11, userRoles.data.size)
            Assert.assertEquals(4, userRoles.include.role.size)

            Assert.assertNotNull(userRoles.getRoleForLicense("license:123456", licenses.licenses))
            Assert.assertNull(userRoles.getRoleForLicense("license:9999", licenses.licenses)) //License does not exist in JSON.
            Assert.assertTrue(userRoles.hasCapability("license:123456", "view:asset_library", licenses.licenses))
            Assert.assertFalse(userRoles.hasCapability("license:123456", "does:not:exist", licenses.licenses))
            Assert.assertFalse(userRoles.hasCapability("license:9999", "view:asset_library", licenses.licenses))
        }
    }
}
