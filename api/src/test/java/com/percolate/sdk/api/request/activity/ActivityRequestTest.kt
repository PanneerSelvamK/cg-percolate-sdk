package com.percolate.sdk.api.request.activity

import com.percolate.sdk.api.BaseApiTest
import org.junit.Assert
import org.junit.Test

class ActivityRequestTest : BaseApiTest() {

    @Test
    fun testGet() {
        val activityStream = percolateApi
                .activity()
                .get(ActivityParams())
                .execute()
                .body();

        val data = activityStream?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(18, data!!.size.toLong())
    }
}