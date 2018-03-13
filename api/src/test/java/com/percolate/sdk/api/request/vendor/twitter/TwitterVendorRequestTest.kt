package com.percolate.sdk.api.request.vendor.twitter

import com.percolate.sdk.api.BaseApiTest
import com.percolate.sdk.api.request.vendor.twitter.params.*
import org.junit.Assert
import org.junit.Test

class TwitterVendorRequestTest : BaseApiTest() {

    @Test
    fun testUnblock() {
        val twitterUser = percolateApi
                .vendorTwitter()
                .unblock(TwitterVendorParams())
                .execute()
                .body();

        Assert.assertNotNull(twitterUser?.id)
    }

    @Test
    fun testUnfavorite() {
        val tweet = percolateApi
                .vendorTwitter()
                .unfavorite(TwitterUnfavoriteVendorParams())
                .execute()
                .body();

        Assert.assertNotNull(tweet?.id)
    }

    @Test
    fun testUnfollow() {
        val twitterUser = percolateApi
                .vendorTwitter()
                .unfollow(TwitterVendorParams())
                .execute()
                .body();

        Assert.assertNotNull(twitterUser?.id)
    }

    @Test
    fun testGetTweet() {
        val tweet = percolateApi
                .vendorTwitter()
                .getTweet(TwitterGetTweetVendorParams("123"))
                .execute()
                .body();

        Assert.assertNotNull(tweet?.id)
    }

    @Test
    fun testFollowing() {
        val twitterRelationships = percolateApi
                .vendorTwitter()
                .following(TwitterFollowingVendorParams())
                .execute()
                .body();

        Assert.assertNotNull(twitterRelationships?.relationship?.source?.id)
        Assert.assertNotNull(twitterRelationships?.relationship?.target?.id)
    }

    @Test
    fun testTimeline() {
        val tweetList = percolateApi
                .vendorTwitter()
                .timeline(TwitterTimelineVendorParams())
                .execute()
                .body();

        Assert.assertEquals(4L, tweetList?.size?.toLong())
    }

    @Test
    fun testUser() {
        val twitterUser = percolateApi
                .vendorTwitter()
                .user(TwitterUserVendorParams())
                .execute()
                .body();

        Assert.assertNotNull(twitterUser?.id)
    }

    @Test
    fun testBlock() {
        val twitterUser = percolateApi
                .vendorTwitter()
                .block(TwitterVendorParams())
                .execute()
                .body();

        Assert.assertNotNull(twitterUser?.id)
    }

    @Test
    fun testDm() {
        val twitterConversationMessage = percolateApi
                .vendorTwitter()
                .dm(TwitterDmVendorParams())
                .execute()
                .body();

        Assert.assertNotNull(twitterConversationMessage?.id)
    }

    @Test
    fun testFavorite() {
        val tweet = percolateApi
                .vendorTwitter()
                .favorite(TwitterFavoriteVendorParams())
                .execute()
                .body();

        Assert.assertNotNull(tweet?.id)
    }

    @Test
    fun testFollow() {
        val twitterUser = percolateApi
                .vendorTwitter()
                .follow(TwitterVendorParams())
                .execute()
                .body();

        Assert.assertNotNull(twitterUser?.id)
    }
}