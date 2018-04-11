package com.percolate.sdk.api.request.streams

import com.percolate.sdk.api.BaseApiTest
import org.junit.Assert
import org.junit.Test

class StreamsRequestTest : BaseApiTest() {

    @Test
    fun testGet() {
        val streams = percolateApi
                .streams()
                .get(StreamsParams())
                .execute()
                .body();

        val data = streams?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(13, data!!.size.toLong())
    }
}
