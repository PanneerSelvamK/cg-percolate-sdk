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
public class Topic implements Serializable, HasExtraFields {

    private static final long serialVersionUID = -7042873740209373803L;

    @JsonProperty("id")
    protected Long id;

    @JsonProperty("parent_id")
    protected Long parentId;

    @JsonProperty("name")
    protected String name;

    @JsonProperty("color")
    protected String color;

    @JsonProperty("owner_uid")
    protected String ownerUid;

    @JsonProperty("owner")
    protected LicenseV3 owner;

    @JsonIgnore
    protected Map<String, Object> extraFields = new HashMap<>();

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    /**
     * Equals used by PostFormLib to make sure duplicate topics are not added to the post.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || ((Object) this).getClass() != o.getClass()) return false;

        Topic topic = (Topic) o;

        return id.equals(topic.id) && !(parentId != null ? !parentId.equals(topic.parentId) : topic.parentId != null);

    }

    @Override
    public int hashCode() {
        if (id != null) {
            int result = id.hashCode();
            result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
            return result;
        } else {
            return 0;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOwnerUid() {
        return ownerUid;
    }

    public void setOwnerUid(String ownerUid) {
        this.ownerUid = ownerUid;
    }

    public LicenseV3 getOwner() {
        return owner;
    }

    public void setOwner(LicenseV3 owner) {
        this.owner = owner;
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
