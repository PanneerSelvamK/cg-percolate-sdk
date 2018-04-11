package com.percolate.sdk.api.request.schema

import com.percolate.sdk.api.BaseApiTest
import org.junit.Assert
import org.junit.Test

class SchemasRequestTest : BaseApiTest() {

    @Test
    fun testList() {
        val schemas = percolateApi
                .schemas()
                .list(SchemasListParams())
                .execute()
                .body();

        val data = schemas?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(9, data!!.size.toLong())
    }

    @Test
    fun testGet() {
        val singleSchema = percolateApi
                .schemas()
                .get(SchemasGetParams("123"))
                .execute()
                .body();

        val data = singleSchema?.data
        Assert.assertNotNull(data)
        Assert.assertNotNull(data!!.id)
    }
}
