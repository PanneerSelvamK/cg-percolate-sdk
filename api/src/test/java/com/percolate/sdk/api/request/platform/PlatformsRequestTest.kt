package com.percolate.sdk.api.request.platform

import com.percolate.sdk.api.BaseApiTest
import org.junit.Assert
import org.junit.Test

class PlatformsRequestTest : BaseApiTest() {

    @Test
    fun testGet() {
        val platforms = percolateApi
                .platforms()
                .get(PlatformsParams())
                .execute()
                .body();

        val data = platforms?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(6, data!!.size.toLong())
    }
}