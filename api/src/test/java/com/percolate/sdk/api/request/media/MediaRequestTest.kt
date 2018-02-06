package com.percolate.sdk.api.request.media

import com.percolate.sdk.api.BaseApiTest
import com.percolate.sdk.dto.MediaMetaData
import okhttp3.RequestBody
import org.junit.Assert
import org.junit.Test
import java.io.File

class MediaRequestTest : BaseApiTest() {

    @Test
    fun testItems() {
        val mediaItems = percolateApi
                .media()
                .items(MediaItemParams())
                .execute()
                .body();

        Assert.assertNotNull(mediaItems)
        Assert.assertFalse(mediaItems.isEmpty())
        Assert.assertEquals(2, mediaItems.size.toLong())
    }

    @Test
    fun testCreate() {
        val media = percolateApi
                .media()
                .create(MediaUploadParams().file(
                        RequestBody.create(null, File("/some/path/file.jpg")),
                        "/some/path/file.jpg"
                ))
                .execute()
                .body();

        Assert.assertNotNull(media)
        Assert.assertNotNull(media.uid)
    }
}
