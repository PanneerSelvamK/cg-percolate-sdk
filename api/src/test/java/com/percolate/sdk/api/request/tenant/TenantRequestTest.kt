package com.percolate.sdk.api.request.tenant

import com.percolate.sdk.api.BaseApiTest
import org.junit.Assert
import org.junit.Test

class TenantRequestTest: BaseApiTest() {

    @Test
    fun testGet() {
        val tenants = percolateApi
                .tenants()
                .get()
                .execute()
                .body();

        val tenantsList = tenants?.data
        Assert.assertNotNull(tenantsList)
        Assert.assertEquals(3, tenantsList!!.size.toLong())
        Assert.assertEquals(3, tenants.meta.total)
    }
}