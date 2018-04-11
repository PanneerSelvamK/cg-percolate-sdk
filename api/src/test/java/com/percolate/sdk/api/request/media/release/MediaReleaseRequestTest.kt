package com.percolate.sdk.api.request.media.release

import com.percolate.sdk.api.BaseApiTest
import okhttp3.RequestBody
import org.junit.Assert
import org.junit.Test
import java.io.File

class MediaReleaseRequestTest : BaseApiTest() {

    @Test
    fun testCreate() {
        val mediaReleaseResponse = percolateApi
                .mediaRelease()
                .create(
                        MediaReleaseParams().file(
                                RequestBody.create(null, File("/some/path/file.jpg")),
                                "/some/path/file.jpg"
                        )
                )
                .execute()
                .body();

        Assert.assertNotNull(mediaReleaseResponse?.data?.id)
    }
}
