package com.percolate.sdk.api.request.vendor.facebook

import com.percolate.sdk.api.BaseApiTest
import com.percolate.sdk.api.request.vendor.facebook.params.*
import org.junit.Assert
import org.junit.Test

class FacebookVendorRequestTest : BaseApiTest() {

    @Test
    fun testUnlike() {
        val successStatus = percolateApi
                .vendorFacebook()
                .unlike(FacebookUnlikeVendorParams())
                .execute()
                .body();

        Assert.assertNotNull(successStatus)
        Assert.assertTrue(successStatus!!.success.success.toBoolean())
    }

    @Test
    fun testConversation() {
        val facebookConversationListData = percolateApi
                .vendorFacebook()
                .conversation(FacebookConversationVendorParams("123"))
                .execute()
                .body();

        Assert.assertNotNull(facebookConversationListData?.canReply)
        Assert.assertNotNull(facebookConversationListData?.participants)
    }

    @Test
    fun testMentions() {
        val facebookMentions = percolateApi
                .vendorFacebook()
                .mentions(FacebookMentionsVendorParams())
                .execute()
                .body();

        val mentions = facebookMentions?.mentions
        Assert.assertNotNull(mentions)
        Assert.assertEquals(6, mentions!!.size.toLong())
    }

    @Test
    fun testMessage() {
        val facebookMessageExtendedData = percolateApi
                .vendorFacebook()
                .message(FacebookMessageVendorParams("456"))
                .execute()
                .body();

        Assert.assertNotNull(facebookMessageExtendedData?.message)
    }

    @Test
    fun testUser() {
        val facebookUser = percolateApi
                .vendorFacebook()
                .user(FacebookUserVendorParams())
                .execute()
                .body();

        Assert.assertNotNull(facebookUser?.id)
    }

    @Test
    fun testConversationMessage() {
        val FacebookConversationMessageIdData = percolateApi
                .vendorFacebook()
                .conversationMessage(FacebookConversationMessageVendorParams("789"))
                .execute()
                .body();

        Assert.assertNotNull(FacebookConversationMessageIdData?.data?.messageId)
    }

    @Test
    fun testLike() {
        val successStatus = percolateApi
                .vendorFacebook()
                .like(FacebookLikeVendorParams())
                .execute()
                .body();

        Assert.assertNotNull(successStatus)
        Assert.assertTrue(successStatus!!.success.success.toBoolean())
    }
}
