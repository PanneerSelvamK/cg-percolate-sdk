package com.percolate.sdk.api.request.terms

import com.percolate.sdk.api.BaseApiTest
import com.percolate.sdk.dto.Term
import org.junit.Assert
import org.junit.Test

class TermsRequestTest : BaseApiTest() {

    @Test
    fun testGet() {
        val terms = percolateApi
                .terms()
                .get(TermsParams())
                .execute()
                .body();

        val data = terms?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(5, data!!.size.toLong())
    }

    @Test
    fun testCreate() {
        val singleTerm = percolateApi
                .terms()
                .create(Term())
                .execute()
                .body();

        Assert.assertNotNull(singleTerm?.data)
    }
}
