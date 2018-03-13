package com.percolate.sdk.api.request.config

import com.percolate.sdk.api.BaseApiTest
import org.junit.Assert
import org.junit.Test

class ConfigRequestTest : BaseApiTest() {

    @Test
    fun testGet() {
        val config = percolateApi
                .config()
                .get()
                .execute()
                .body();

        val data = config?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(3, data!!.size.toLong())
    }
}
