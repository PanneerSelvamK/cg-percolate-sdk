package com.percolate.sdk.api.request.followers

import com.percolate.sdk.api.BaseApiTest
import com.percolate.sdk.api.request.interaction.InteractionParams
import com.percolate.sdk.dto.InteractionData
import org.junit.Assert
import org.junit.Test

class InteractionRequestTest : BaseApiTest() {

    @Test
    fun testGet() {
        val interactions = percolateApi
                .interactions()
                .get(InteractionParams())
                .execute()
                .body()

        val data = interactions?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(2, data!!.size)
    }

    @Test
    fun testCreate() {
        val interaction = percolateApi
                .interactions()
                .create(InteractionData())
                .execute()
                .body()

        val data = interaction?.data
        Assert.assertNotNull(data)
        Assert.assertEquals("interaction:1", data!!.id)
    }
}
