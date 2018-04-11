package com.percolate.sdk.api.request.authorization

import com.percolate.sdk.api.BaseApiTest
import com.percolate.sdk.api.request.autocomplete.AutocompleteParams
import org.junit.Assert
import org.junit.Test

class AutocompleteRequestTest : BaseApiTest() {

    @Test
    fun testGet() {
        val autocomplete = percolateApi
                .autocomplete()
                .get(AutocompleteParams())
                .execute()
                .body()

        val data = autocomplete?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(3, data!!.size.toLong())
    }
}
