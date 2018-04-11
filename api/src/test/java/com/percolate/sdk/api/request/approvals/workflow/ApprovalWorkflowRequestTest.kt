package com.percolate.sdk.api.request.approvals.workflow

import com.percolate.sdk.api.BaseApiTest
import org.junit.Assert
import org.junit.Test

class ApprovalWorkflowRequestTest : BaseApiTest() {

    @Test
    fun testGet() {
        val workflow = percolateApi
                .approvalWorkflow()
                .get(ApprovalWorkflowParams())
                .execute()
                .body();

        val data = workflow?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(3, data!!.size.toLong())
    }
}
