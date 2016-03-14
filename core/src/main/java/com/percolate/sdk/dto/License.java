package com.percolate.sdk.dto;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.percolate.sdk.interfaces.HasExtraFields;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
public class License implements Serializable, HasExtraFields, Comparable<License> {

    private static final long serialVersionUID = -1659638539635426756L;

    @JsonProperty("id")
    protected Long id;

    @JsonProperty("uid")
    protected String UID;

    @JsonProperty("default_brew_id")
    protected Long defaultBrewId;

    @JsonProperty("name")
    protected String name;

    @JsonProperty("timezone")
    protected String timezone;

    @JsonProperty("virality_threshold")
    protected String viralityThreshold;

    @JsonProperty("photo_url")
    protected String photoUrl;

    @JsonProperty("targeting")
    protected String targeting;

    @JsonProperty("brand")
    protected Brand brand;

    @JsonProperty("brand_id")
    protected Long brandId;

    @JsonProperty("state")
    protected String state;

    @JsonProperty("type")
    protected String type;

    protected List<UserRolesLicenseData> userRolesLicenseData; //Set in some apps after calling ApiGetUserRoles

    protected Map<String, Object> extraFields = new HashMap<>();

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    /**
     * Sorts licenses alphabetically by license name
     */
    @Override
    public int compareTo(@NotNull License anotherLicense) {
        if (name != null && anotherLicense.getName() != null) {
            return this.name.compareToIgnoreCase(anotherLicense.getName());
        } else {
            return 0;
        }
    }

    /**
     * Returns true if userRolesLicenseData contains the passed in role to check for.
     */
    public boolean hasRole(String role) {
        if (userRolesLicenseData != null) {
            for (UserRolesLicenseData entry : userRolesLicenseData) {
                List<UserRolesLicenseCapabilities> capabilities = entry.getCapabilities();
                for (UserRolesLicenseCapabilities capability : capabilities) {
                    if (StringUtils.equalsIgnoreCase(capability.getCode(), role)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDefaultBrewId() {
        return defaultBrewId;
    }

    public void setDefaultBrewId(Long defaultBrewId) {
        this.defaultBrewId = defaultBrewId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getViralityThreshold() {
        return viralityThreshold;
    }

    public void setViralityThreshold(String viralityThreshold) {
        this.viralityThreshold = viralityThreshold;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getTargeting() {
        return targeting;
    }

    public void setTargeting(String targeting) {
        this.targeting = targeting;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String uID) {
        UID = uID;
    }

    public List<UserRolesLicenseData> getUserRolesLicenseData() {
        return userRolesLicenseData;
    }

    public void setUserRolesLicenseData(List<UserRolesLicenseData> userRolesLicenseData) {
        this.userRolesLicenseData = userRolesLicenseData;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getExtraFields() {
        if(extraFields == null) {
            extraFields = new HashMap<>();
        }
        return extraFields;
    }

    @JsonAnySetter
    public void putExtraField(String key, Object value) {
        getExtraFields().put(key, value);
    }
}
