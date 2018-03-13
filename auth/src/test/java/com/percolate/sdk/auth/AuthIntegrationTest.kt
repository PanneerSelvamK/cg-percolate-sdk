package com.percolate.sdk.auth

import com.percolate.sdk.api.PercolateApi
import okhttp3.*
import okio.Buffer
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.FileInputStream
import java.io.IOException

class AuthIntegrationTest {

    @Test
    fun testAuth() {
        val percolateApi = PercolateApi()
        percolateApi.selectedServer.customInterceptor = AuthMockHttpInterceptor()

        val authorize = Authorize(percolateApi, "client:123", "12345abcde")
        val response = authorize.authorize("user@percolate.com", "password")

        assertEquals(AuthStatus.READY, response.status)
        assertEquals("mock_oauth_token_key", percolateApi.oAuthTokenKey)
    }

    /**
     * This [Interceptor] gets plugged into Retrofit's okhttp client
     * and is used to return local JSON data for unit testing instead of
     * going over the network.
     */
    internal inner class AuthMockHttpInterceptor : Interceptor {

        private val FIXTURES_DIR = "src/test/fixtures/"

        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()
            val requestedUrl = request.url()
            val requestedPath = requestedUrl.encodedPath()

            val fixtureJsonPath: String
            if (requestedPath.endsWith("v5/authorize/")) {
                fixtureJsonPath = FIXTURES_DIR + "auth.json"
            } else if (requestedPath.endsWith("v5/token/")) {
                fixtureJsonPath = FIXTURES_DIR + "token.json"
            } else {
                throw RuntimeException("Unexpected url in Auth Integration test: " + requestedPath)
            }

            val inputStream = FileInputStream(fixtureJsonPath)
            val input = Buffer().readFrom(inputStream)

            val mediaType = MediaType.parse("application/json")
            val responseBody = ResponseBody.create(mediaType, input.size(), input)

            return Response.Builder().request(request).protocol(Protocol.HTTP_1_1).code(200).body(responseBody).message("").build()
        }
    }
}
