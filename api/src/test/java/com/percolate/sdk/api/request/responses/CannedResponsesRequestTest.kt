package com.percolate.sdk.api.request.responses

import com.percolate.sdk.api.BaseApiTest
import org.junit.Assert
import org.junit.Test

class CannedResponsesRequestTest : BaseApiTest() {

    @Test
    fun testGet() {
        val cannedResponses = percolateApi
                .cannedResponses()
                .get(CannedResponsesParams())
                .execute()
                .body();

        val data = cannedResponses?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(2, data!!.size.toLong())
    }
}