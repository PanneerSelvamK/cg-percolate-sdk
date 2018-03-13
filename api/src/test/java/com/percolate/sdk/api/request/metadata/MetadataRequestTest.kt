package com.percolate.sdk.api.request.platform

import com.percolate.sdk.api.BaseApiTest
import com.percolate.sdk.api.request.metadata.MetadataParams
import com.percolate.sdk.dto.MetadataItem
import org.junit.Assert
import org.junit.Test

class MetadataRequestTest : BaseApiTest() {

    @Test
    fun testGet() {
        val metadata = percolateApi
                .metadata()
                .get("123")
                .execute()
                .body();

        Assert.assertNotNull(metadata)
        val data = metadata?.data
        Assert.assertNotNull(data)
        Assert.assertEquals("metadata:4", data!!.id)
    }

    @Test
    fun testList() {
        val metadata = percolateApi
                .metadata()
                .list(MetadataParams())
                .execute()
                .body();

        val data = metadata?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(4, data!!.size)
    }

    @Test
    fun testCreate() {
        val metadata = percolateApi
                .metadata()
                .create(MetadataItem())
                .execute()
                .body();

        val data = metadata?.data
        Assert.assertNotNull(data)
        Assert.assertEquals("metadata:9", data!!.id)
    }

    @Test
    fun testUpdate() {
        val metadata = percolateApi
                .metadata()
                .update(MetadataItem().apply { id="123" })
                .execute()
                .body();

        val data = metadata?.data
        Assert.assertNotNull(data)
        Assert.assertEquals("metadata:123", data!!.id)
    }
}
