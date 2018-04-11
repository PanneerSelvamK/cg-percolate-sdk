package com.percolate.sdk.api.request.campaignsection

import com.percolate.sdk.api.BaseApiTest
import com.percolate.sdk.api.request.campaign.CampaignSectionsListParams
import com.percolate.sdk.dto.CampaignSectionData
import org.junit.Assert
import org.junit.Test

class CampaignSectionsRequestTest : BaseApiTest() {

    @Test
    fun testList() {
        val campaignSections = percolateApi
                .campaignSections()
                .list(CampaignSectionsListParams())
                .execute()
                .body();

        val data = campaignSections?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(1, data!!.size.toLong())
    }

    @Test
    fun testGet() {
        val singleCampaignSection = percolateApi
                .campaignSections()
                .get("123")
                .execute()
                .body();

        val data = singleCampaignSection?.data
        Assert.assertNotNull(data)
        Assert.assertEquals(data!!.id, "123")
    }

    @Test
    fun testCreate() {
        val campaignSectionData = CampaignSectionData().apply {
            id = "campaign_section:111"
            campaignId = "campaign:222"
            schemaId = "schema:333"
            scopeId = "license:444"
            type = "brief"
            title = "Brief section 1"
        }

        val singleCampaignSection = percolateApi
                .campaignSections()
                .create(campaignSectionData)
                .execute()
                .body();

        Assert.assertNotNull(singleCampaignSection)
        val sectionData = singleCampaignSection?.data
        Assert.assertNotNull(sectionData)
        Assert.assertEquals(sectionData!!.id, "campaign_section:111")
        Assert.assertEquals(sectionData.campaignId, "campaign:222")
        Assert.assertEquals(sectionData.schemaId, "schema:333")
        Assert.assertEquals(sectionData.scopeId, "license:444")
        Assert.assertEquals(sectionData.type, "brief")
        Assert.assertEquals(sectionData.title, "Brief section 1")
    }
}

