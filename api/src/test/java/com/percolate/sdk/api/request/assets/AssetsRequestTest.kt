package com.percolate.sdk.api.request.activity

import com.percolate.sdk.api.BaseApiTest
import com.percolate.sdk.api.request.assets.AssetsListParams
import org.junit.Assert
import org.junit.Test

class AssetsRequestTest : BaseApiTest() {

    @Test
    fun testList() {
        val assets = percolateApi
                .assets()
                .list(AssetsListParams())
                .execute()
                .body()

        val data = assets?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(3, data!!.size.toLong())
    }
}
