package com.percolate.sdk.api.request.users

import com.percolate.sdk.api.BaseApiTest
import org.junit.Assert
import org.junit.Test

class UsersRequestTest : BaseApiTest() {

    @Test
    fun testGet() {
        val users = percolateApi
                .users()
                .get(UsersParams())
                .execute()
                .body();

        val data = users?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(2, data!!.size.toLong())
    }
}
