package com.percolate.sdk.api.request.monitoring.twitter

import com.percolate.sdk.api.BaseApiTest
import org.junit.Assert
import org.junit.Test

class TwitterMonitoringRequestTest : BaseApiTest() {

    @Test
    fun testConversations() {
        val twitterConversationList = percolateApi
                .twitterMonitoring()
                .conversations(TwitterMonitoringConversationParams())
                .execute()
                .body();

        val data = twitterConversationList?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(3, data!!.size.toLong())
    }

    @Test
    fun testMessages() {
        val twitterConversationThread = percolateApi
                .twitterMonitoring()
                .messages(TwitterMonitoringMessagesParams("123"))
                .execute()
                .body();

        val data = twitterConversationThread?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(4, data!!.size.toLong())
    }

    @Test
    fun testInteractions() {
        val twitterMonitoringObjects = percolateApi
                .twitterMonitoring()
                .interactions(TwitterMonitoringInteractionsParams())
                .execute()
                .body();

        val data = twitterMonitoringObjects?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(8, data!!.size.toLong())
    }

    @Test
    fun testQuery() {
        val twitterQueries = percolateApi
                .twitterMonitoring()
                .query(TwitterMonitoringQueryParams())
                .execute()
                .body();

        val data = twitterQueries?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(3, data!!.size.toLong())
    }
}
