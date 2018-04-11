package com.percolate.sdk.api.request.post_attachment

import com.percolate.sdk.api.BaseApiTest
import com.percolate.sdk.dto.PostAttachmentData
import org.junit.Assert
import org.junit.Test

class PostAttachmentRequestTest : BaseApiTest() {

    @Test
    fun testGet() {
        val attachmentData = percolateApi
                .postAttachment()
                .get("123")
                .execute()
                .body()

        Assert.assertNotNull(attachmentData?.data?.id)
    }

    @Test
    fun testList() {
        val attachments = percolateApi
                .postAttachment()
                .list(PostAttachmentParams())
                .execute()
                .body()

        val data = attachments?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(2, data!!.size.toLong())
    }

    @Test
    fun testCreate() {
        val attachmentData = percolateApi
                .postAttachment()
                .create(PostAttachmentData())
                .execute()
                .body()

        Assert.assertNotNull(attachmentData?.data?.id)
    }

    @Test
    fun testUpdate() {
        val attachmentData = percolateApi
                .postAttachment()
                .update(PostAttachmentData().apply { id = "123" })
                .execute()
                .body()

        Assert.assertNotNull(attachmentData?.data?.id)
    }

}
