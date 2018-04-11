package com.percolate.sdk.api.request.post

import com.percolate.sdk.api.BaseApiTest
import com.percolate.sdk.dto.PostV5Data
import org.junit.Assert
import org.junit.Test

class PostRequestTest : BaseApiTest() {

    @Test
    fun testGet() {
        val post = percolateApi
                .post()
                .get(PostGetParams("123"))
                .execute()
                .body();

        Assert.assertNotNull(post?.data?.id)
    }

    @Test
    fun testList() {
        val posts = percolateApi
                .post()
                .list(PostListParams())
                .execute()
                .body();

        val data = posts?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(5, data!!.size.toLong())
    }

    @Test
    fun testCreate() {
        val post = percolateApi
                .post()
                .create(PostV5Data())
                .execute()
                .body();

        Assert.assertNotNull(post?.data?.id)
    }

    @Test
    fun testUpdate() {
        val post = percolateApi
                .post()
                .update(PostV5Data().apply { id = "123" })
                .execute()
                .body();

        Assert.assertNotNull(post?.data?.id)
    }

    @Test
    fun testDeleteV5() {
        val responseBody = percolateApi
                .post()
                .delete(PostV5DeleteParams("123"))
                .execute()
                .body();

        Assert.assertNotNull(responseBody)
    }

    @Test
    fun testDeleteV4() {
        val responseBody = percolateApi
                .post()
                .delete(PostV4DeleteParams("123"))
                .execute()
                .body();

        Assert.assertNotNull(responseBody)
    }
}
