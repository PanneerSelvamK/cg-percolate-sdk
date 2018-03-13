package com.percolate.sdk.api.request.comment

import com.percolate.sdk.api.BaseApiTest
import com.percolate.sdk.dto.Comment
import org.junit.Assert
import org.junit.Test

class CommentRequestTest : BaseApiTest() {

    @Test
    fun testGet() {
        val comments = percolateApi
                .comments()
                .get(CommentParams())
                .execute()
                .body();

        val commentsList = comments?.comments
        Assert.assertNotNull(commentsList)
        Assert.assertEquals(3, commentsList!!.size.toLong())
    }

    @Test
    fun testCreate() {
        val commentData = percolateApi
                .comments()
                .create(Comment())
                .execute()
                .body();

        Assert.assertNotNull(commentData?.comment)
    }
}
