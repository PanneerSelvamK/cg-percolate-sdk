package com.percolate.sdk.api.request.release

import com.percolate.sdk.api.BaseApiTest
import org.junit.Assert
import org.junit.Test

class ReleaseFormRequestTest : BaseApiTest() {

    @Test
    fun testGet() {
        val releaseFormHtml = percolateApi
                .releaseForm()
                .get(ReleaseFormParams())
                .execute()
                .body();

        Assert.assertNotNull(releaseFormHtml?.html)
    }
}
