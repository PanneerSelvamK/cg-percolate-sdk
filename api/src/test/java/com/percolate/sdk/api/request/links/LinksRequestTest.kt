package com.percolate.sdk.api.request.links

import com.percolate.sdk.api.BaseApiTest
import org.junit.Assert
import org.junit.Test

class LinksRequestTest : BaseApiTest() {

    @Test
    fun testGet() {
        val link = percolateApi
                .links()
                .get("123")
                .execute()
                .body();

        Assert.assertNotNull(link?.id)
    }

    @Test
    fun testCreate() {
        val link = percolateApi
                .links()
                .create("http://percolate.com")
                .execute()
                .body();

        Assert.assertNotNull(link?.id)
    }
}
