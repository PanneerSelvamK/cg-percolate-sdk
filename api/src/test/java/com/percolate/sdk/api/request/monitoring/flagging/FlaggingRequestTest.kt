package com.percolate.sdk.api.request.monitoring.flagging

import com.percolate.sdk.api.BaseApiTest
import com.percolate.sdk.dto.Flag
import org.junit.Assert
import org.junit.Test

class FlaggingRequestTest : BaseApiTest() {

    @Test
    fun testList() {
        val flags = percolateApi
                .flags()
                .list(FlaggingListParams())
                .execute()
                .body();

        val data = flags?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(5, data!!.size.toLong())
    }

    @Test
    fun testGet() {
        val singleFlag = percolateApi
                .flags()
                .get(FlaggingGetParams("123"))
                .execute()
                .body();

        Assert.assertNotNull(singleFlag?.data?.id)
    }

    @Test
    fun testCreate() {
        val singleFlag = percolateApi
                .flags()
                .create(Flag())
                .execute()
                .body();

        Assert.assertNotNull(singleFlag?.data?.id)
    }

    @Test
    fun testUpdate() {
        val singleFlag = percolateApi
                .flags()
                .update(Flag().apply { id= 123L })
                .execute()
                .body();

        Assert.assertNotNull(singleFlag?.data?.id)
    }

    @Test
    fun testDelete() {
        val responseBody = percolateApi
                .flags()
                .delete(FlaggingDeleteParams("123"))
                .execute()
                .body();

        Assert.assertNotNull(responseBody)
    }
}