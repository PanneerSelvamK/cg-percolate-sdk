package com.percolate.sdk.api.request.vendor.instagram

import com.percolate.sdk.api.BaseApiTest
import com.percolate.sdk.api.request.vendor.instagram.params.InstagramMediaVendorParams
import org.junit.Assert
import org.junit.Test

class InstagramVendorRequestTest : BaseApiTest() {

    @Test
    fun testMedia() {
        val instagramMedia = percolateApi
                .vendorInstagram()
                .media(InstagramMediaVendorParams("123"))
                .execute()
                .body();

        val data = instagramMedia?.data?.comments?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(3, data!!.size.toLong())
    }

    @Test
    fun testComments() {
        val instagramMediaComments = percolateApi
                .vendorInstagram()
                .comments(InstagramMediaVendorParams("123"))
                .execute()
                .body();

        val data = instagramMediaComments?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(3, data!!.size.toLong())
    }
}
