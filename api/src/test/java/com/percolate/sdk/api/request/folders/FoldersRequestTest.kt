package com.percolate.sdk.api.request.activity

import com.percolate.sdk.api.BaseApiTest
import com.percolate.sdk.api.request.folders.FoldersListParams
import org.junit.Assert
import org.junit.Test

class FoldersRequestTest : BaseApiTest() {

    @Test
    fun testList() {
        val folders = percolateApi
                .folders()
                .list(FoldersListParams())
                .execute()
                .body()

        val data = folders?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(3, data!!.size.toLong())
    }
}
