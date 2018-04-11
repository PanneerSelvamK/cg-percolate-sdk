package com.percolate.sdk.api.request.push

import com.percolate.sdk.api.BaseApiTest
import com.percolate.sdk.dto.MobileAppPushTokenData
import org.junit.Assert
import org.junit.Test

class PushTokenRequestTest : BaseApiTest() {

    @Test
    fun testCreate() {
        val mobileAppPushToken = percolateApi
                .pushToken()
                .create(MobileAppPushTokenData())
                .execute()
                .body();

        Assert.assertNotNull(mobileAppPushToken?.mobileAppPushTokenData?.id)
    }

    @Test
    fun testDelete() {
        val responseBody = percolateApi
                .pushToken()
                .delete(PushTokenDeleteParams("123"))
                .execute()
                .body();

        Assert.assertNotNull(responseBody)
    }
}
