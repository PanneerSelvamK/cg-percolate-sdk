package com.percolate.sdk.api.request.approvals.pools

import com.percolate.sdk.api.BaseApiTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class ApprovalPoolsRequestTest : BaseApiTest() {

    @Test
    fun testGet() {
        val approvalPools = percolateApi
                .approvalPools()
                .get(ApprovalPoolsParams())
                .execute()
                .body();

        val data = approvalPools?.data
        assertNotNull(data)
        assertEquals(2, data!!.size.toLong())
    }
}
