package com.percolate.sdk.api.request.campaign

import com.percolate.sdk.api.BaseApiTest
import org.junit.Assert
import org.junit.Test

class CampaignsRequestTest : BaseApiTest() {

    @Test
    fun testList() {
        val campaigns = percolateApi
                .campaigns()
                .list(CampaignsListParams())
                .execute()
                .body()

        val data = campaigns?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(2, data!!.size.toLong())
    }

    @Test
    fun testGet() {
        val singleCampaign = percolateApi
                .campaigns()
                .get("123")
                .execute()
                .body()

        val data = singleCampaign?.data
        Assert.assertNotNull(data)
        Assert.assertEquals("123", data!!.id)
    }
}
