package com.percolate.sdk.dto;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.percolate.sdk.interfaces.HasExtraFields;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LicensesV5 implements Serializable, HasExtraFields {

    @JsonProperty("meta")
    protected V5Meta meta = new V5Meta();

    @JsonProperty("data")
    protected List<LicenseV5> licenses = new ArrayList<>();

    @JsonIgnore
    protected Map<String, Object> extraFields = new HashMap<>();

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public V5Meta getMeta() {
        return meta;
    }

    public void setMeta(V5Meta meta) {
        this.meta = meta;
    }

    public List<LicenseV5> getLicenses() {
        return licenses;
    }

    public void setLicenses(List<LicenseV5> licenses) {
        this.licenses = licenses;
    }

    @Override
    public Map<String, Object> getExtraFields() {
        if (extraFields == null) {
            extraFields = new HashMap<>();
        }
        return extraFields;
    }

    /**
     * Returns just licenses which id has prefix "license:".
     *
     * @return just licenses which id has prefix "license:"
     */
    public List<LicenseV5> getJustLicenses() {
        if (licenses == null) {
            return new ArrayList<>();
        }
        List<LicenseV5> filteredLicenses = new ArrayList<>();
        for (LicenseV5 license : licenses) {
            if (license.getId().startsWith("license:")) {
                filteredLicenses.add(license);
            }
        }
        return filteredLicenses;
    }

    @Override
    @JsonAnySetter
    public void putExtraField(String key, Object value) {
        getExtraFields().put(key, value);
    }
}

