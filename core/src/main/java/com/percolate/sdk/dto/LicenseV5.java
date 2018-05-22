package com.percolate.sdk.dto;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.percolate.sdk.interfaces.HasExtraFields;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LicenseV5 implements Serializable, HasExtraFields, Comparable<LicenseV5> {

    private static final long serialVersionUID = 712350134350930323L;

    @JsonProperty("id")
    protected String id;

    @JsonProperty("name")
    protected String name;

    @JsonProperty("timezone")
    protected String timezone;

    @JsonProperty("avatar_id")
    protected String avatarId;

    @JsonProperty("parent_id")
    protected String parentId;

    @JsonProperty("status")
    protected String status;

    @JsonProperty("updated_at")
    protected String updatedAt;

    protected List<UserRolesLicenseData> userRolesLicenseData; //Set in some apps after calling ApiGetUserRoles

    @JsonIgnore
    protected Map<String, Object> extraFields = new HashMap<>();

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    /**
     * Sorts licenses alphabetically by license name
     */
    @Override
    public int compareTo(@NotNull LicenseV5 anotherLicense) {
        if (name != null && anotherLicense.getName() != null) {
            return this.name.compareToIgnoreCase(anotherLicense.getName());
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        LicenseV5 license = (LicenseV5) that;
            return new EqualsBuilder().append(id, license.id).isEquals();
    }

    @Override
    public int hashCode() {
            return new HashCodeBuilder(17, 37).append(id).toHashCode();
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<UserRolesLicenseData> getUserRolesLicenseData() {
        return userRolesLicenseData;
    }

    public void setUserRolesLicenseData(List<UserRolesLicenseData> userRolesLicenseData) {
        this.userRolesLicenseData = userRolesLicenseData;
    }

    public String getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(String avatarId) {
        this.avatarId = avatarId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
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
