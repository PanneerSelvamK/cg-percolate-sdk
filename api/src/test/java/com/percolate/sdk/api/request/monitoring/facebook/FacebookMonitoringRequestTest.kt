package com.percolate.sdk.api.request.monitoring.facebook

import com.percolate.sdk.api.BaseApiTest
import org.junit.Assert
import org.junit.Test

class FacebookMonitoringRequestTest : BaseApiTest() {

    @Test
    fun testInteractions() {
        val facebookMonitoringObjects = percolateApi
                .facebookMonitoring()
                .interactions(FacebookMonitoringInteractionsParams())
                .execute()
                .body();

        val data = facebookMonitoringObjects?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(6, data!!.size.toLong())
    }

    @Test
    fun testAncestors() {
        val facebookMonitoringObjectsList = percolateApi
                .facebookMonitoring()
                .ancestors(FacebookMonitoringAncestorsParams("123"))
                .execute()
                .body();

        Assert.assertNotNull(facebookMonitoringObjectsList)
        Assert.assertEquals(1, facebookMonitoringObjectsList!!.size.toLong())
    }

    @Test
    fun testResponses() {
        val facebookMonitoringObjects = percolateApi
                .facebookMonitoring()
                .responses(FacebookMonitoringResponsesParams("123"))
                .execute()
                .body();

        val data = facebookMonitoringObjects?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(1, data!!.size.toLong())
    }

    @Test
    fun testConversation() {
        val facebookConversationList = percolateApi
                .facebookMonitoring()
                .conversation(FacebookMonitoringConversationParams())
                .execute()
                .body();

        val data = facebookConversationList?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(6, data!!.size.toLong())
    }

    @Test
    fun testMessages() {
        val facebookConversationThread = percolateApi
                .facebookMonitoring()
                .messages(FacebookMonitoringMessagesParams("123"))
                .execute()
                .body();

        val data = facebookConversationThread?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(24, data!!.size.toLong())
    }
}
