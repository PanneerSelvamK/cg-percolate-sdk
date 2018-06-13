package com.percolate.sdk.api

import org.junit.Assert
import org.junit.Test

open class PercolateApiTest {

    @Test
    fun testPercolateApiWithoutParams() {
        val percolateApi = PercolateApi()

        Assert.assertNotNull(percolateApi)
        Assert.assertNull(percolateApi.apiKey)
        Assert.assertNull(percolateApi.oAuthTokenKey)
        Assert.assertEquals(PercolateApi.PROD, percolateApi.selectedServer)
        Assert.assertNull(percolateApi.userAgentPrefix)
    }

    @Test
    fun testPercolateApiWithSelectedServer() {
        val percolateApi = PercolateApi(PercolateApi.PROD)

        Assert.assertNotNull(percolateApi)
        Assert.assertNull(percolateApi.apiKey)
        Assert.assertNull(percolateApi.oAuthTokenKey)
        Assert.assertEquals(PercolateApi.PROD, percolateApi.selectedServer)
        Assert.assertNull(percolateApi.userAgentPrefix)
    }

    @Test
    fun testPercolateApiWithApiKey() {
        val percolateApi = PercolateApi("testingApiKey")

        Assert.assertNotNull(percolateApi)
        Assert.assertNull(percolateApi.userAgentPrefix)
        Assert.assertNull(percolateApi.oAuthTokenKey)
        Assert.assertEquals("testingApiKey", percolateApi.apiKey)
        Assert.assertEquals(PercolateApi.PROD, percolateApi.selectedServer)
    }

    @Test
    fun testPercolateApiWithApiKeyAndSelectedServer() {
        val percolateApi = PercolateApi("testingApiKey", PercolateApi.PROD)

        Assert.assertNotNull(percolateApi)
        Assert.assertNull(percolateApi.userAgentPrefix)
        Assert.assertNull(percolateApi.oAuthTokenKey)
        Assert.assertEquals("testingApiKey", percolateApi.apiKey)
        Assert.assertEquals(PercolateApi.PROD, percolateApi.selectedServer)
    }

    @Test
    fun testPercolateApiWithApiKeyAndSelectedServerAndUserAgentPrefix() {
        val percolateApi = PercolateApi("testingApiKey", PercolateApi.PROD, "testingPrefix/")

        Assert.assertNotNull(percolateApi)
        Assert.assertNull(percolateApi.oAuthTokenKey)
        Assert.assertEquals("testingPrefix/", percolateApi.userAgentPrefix)
        Assert.assertEquals("testingApiKey", percolateApi.apiKey)
        Assert.assertEquals(PercolateApi.PROD, percolateApi.selectedServer)
    }

    @Test
    fun testPercolateApiWithApiKeyAndNullSelectedServerAndUserAgentPrefix() {
        val percolateApi = PercolateApi("testingApiKey", null, "testingPrefix/")

        Assert.assertNotNull(percolateApi)
        Assert.assertNull(percolateApi.oAuthTokenKey)
        Assert.assertEquals("testingPrefix/", percolateApi.userAgentPrefix)
        Assert.assertEquals("testingApiKey", percolateApi.apiKey)
        Assert.assertEquals(PercolateApi.PROD, percolateApi.selectedServer)
    }
}