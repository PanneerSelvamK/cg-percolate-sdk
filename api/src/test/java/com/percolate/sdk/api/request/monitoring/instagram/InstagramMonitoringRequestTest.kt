package com.percolate.sdk.api.request.monitoring.instagram

import com.percolate.sdk.api.BaseApiTest
import org.junit.Assert
import org.junit.Test

class InstagramMonitoringRequestTest : BaseApiTest() {

    @Test
    fun testInteractions() {
        val instagramMonitoringObjects = percolateApi
                .instagramMonitoring()
                .interactions(InstagramMonitoringInteractionsParams())
                .execute()
                .body();

        val data = instagramMonitoringObjects?.data
        val includes = instagramMonitoringObjects?.includes
        Assert.assertNotNull(data)
        Assert.assertNotNull(includes)
        Assert.assertEquals(4, data!!.size.toLong())
        Assert.assertEquals(4, includes!!.posts.size.toLong())
    }

    @Test
    fun testInteraction() {
        val instagramSingleMonitoringObject = percolateApi
                .instagramMonitoring()
                .interaction(InstagramMonitoringInteractionParams("123"))
                .execute()
                .body();

        Assert.assertNotNull(instagramSingleMonitoringObject?.data?.xobj?.id)
    }
}
