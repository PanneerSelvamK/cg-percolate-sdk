package com.percolate.sdk.api.request.shares

import com.percolate.sdk.api.BaseApiTest
import org.junit.Assert
import org.junit.Test

class SharesRequestTest : BaseApiTest() {

    @Test
    fun testList() {
        val shares = percolateApi
                .shares()
                .list(SharesListParams())
                .execute()
                .body();

        val data = shares?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(4, data!!.size.toLong())
    }

    @Test
    fun testGet() {
        val singleShare = percolateApi
                .shares()
                .get(SharesGetParams("123"))
                .execute()
                .body();

        Assert.assertNotNull(singleShare?.data?.id)
    }
}
