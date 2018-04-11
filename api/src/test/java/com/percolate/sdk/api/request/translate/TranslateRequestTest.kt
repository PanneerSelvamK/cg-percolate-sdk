package com.percolate.sdk.api.request.translate

import com.percolate.sdk.api.BaseApiTest
import org.junit.Assert
import org.junit.Test

class TranslateRequestTest : BaseApiTest() {

    @Test
    fun testGet() {
        val translation = percolateApi
                .translate()
                .get(TranslateParams())
                .execute()
                .body();

        val data = translation?.data
        Assert.assertNotNull(data)
        Assert.assertEquals("Testing", data!!.translation)
    }
}
