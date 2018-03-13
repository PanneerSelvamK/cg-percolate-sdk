package com.percolate.sdk.api.request.preference

import com.percolate.sdk.api.BaseApiTest
import org.junit.Assert
import org.junit.Test

class PreferenceRequestTest: BaseApiTest() {

    @Test
    fun testGet() {
        val preference = percolateApi
                .preference()
                .get(PreferenceParams())
                .execute()
                .body()

        val data = preference?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(data!!.size, 1)
    }


}