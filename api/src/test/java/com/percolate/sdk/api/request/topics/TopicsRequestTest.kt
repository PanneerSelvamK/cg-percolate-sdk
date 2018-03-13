package com.percolate.sdk.api.request.topics

import com.percolate.sdk.api.BaseApiTest
import org.junit.Assert
import org.junit.Test

class TopicsRequestTest : BaseApiTest() {

    @Test
    fun testGet() {
        val topics = percolateApi
                .topics()
                .get(TopicsParams())
                .execute()
                .body();

        val data = topics?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(4, data!!.size.toLong())
    }
}
