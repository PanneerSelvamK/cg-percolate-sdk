package com.percolate.sdk.dto;

import com.fasterxml.jackson.annotation.*;
import com.percolate.sdk.interfaces.HasExtraFields;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LicenseChannel implements Serializable, HasExtraFields {

    private static final long serialVersionUID = 5650271549581035867L;

    public boolean displayed; //set to true by client once it is displayed

    @JsonProperty("id")
    protected Long id;

    @JsonProperty("uid")
    protected String uid;

    @JsonProperty("license_id")
    protected Long licenseId;

    @JsonProperty("channel_id")
    protected Long channelId;

    @JsonProperty("token_id")
    protected Long tokenId;

    @JsonProperty("publishing")
    protected Publishing publishing;

    @JsonProperty("ingesting")
    protected EnabledProperty ingesting;

    @JsonProperty("following")
    protected EnabledProperty following;

    @JsonProperty("monitoring")
    protected EnabledProperty monitoring;

    @JsonProperty("inbox")
    protected EnabledProperty inbox;

    @JsonProperty("token")
    protected TokenStatus token;

    @JsonProperty("license")
    protected LicenseV3 license;

    @JsonProperty("channel")
    protected Channel channel;

    @JsonProperty("scoped_channel_uid")
    protected String scopedChannelUid;

    @JsonIgnore
    protected Map<String, Object> extraFields = new HashMap<>();

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Long getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(Long licenseId) {
        this.licenseId = licenseId;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Long getTokenId() {
        return tokenId;
    }

    public void setTokenId(Long tokenId) {
        this.tokenId = tokenId;
    }

    public Publishing getPublishing() {
        return publishing;
    }

    public void setPublishing(Publishing publishing) {
        this.publishing = publishing;
    }

    public EnabledProperty getIngesting() {
        return ingesting;
    }

    public void setIngesting(EnabledProperty ingesting) {
        this.ingesting = ingesting;
    }

    public EnabledProperty getFollowing() {
        return following;
    }

    public void setFollowing(EnabledProperty following) {
        this.following = following;
    }

    public EnabledProperty getMonitoring() {
        return monitoring;
    }

    public void setMonitoring(EnabledProperty monitoring) {
        this.monitoring = monitoring;
    }

    public EnabledProperty getInbox() {
        return inbox;
    }

    public void setInbox(EnabledProperty inbox) {
        this.inbox = inbox;
    }

    public TokenStatus getToken() {
        return token;
    }

    public void setToken(TokenStatus token) {
        this.token = token;
    }

    public LicenseV3 getLicense() {
        return license;
    }

    public void setLicense(LicenseV3 license) {
        this.license = license;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getScopedChannelUid() {
        return scopedChannelUid;
    }

    public void setScopedChannelUid(String scopedChannelUid) {
        this.scopedChannelUid = scopedChannelUid;
    }

    @Override
    public Map<String, Object> getExtraFields() {
        if(extraFields == null) {
            extraFields = new HashMap<>();
        }
        return extraFields;
    }

    @Override
    @JsonAnySetter
    public void putExtraField(String key, Object value) {
        getExtraFields().put(key, value);
    }
}
