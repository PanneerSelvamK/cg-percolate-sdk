package com.percolate.sdk.api.request.license;

import com.percolate.sdk.enums.LicenseType;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.BooleanUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Parameters for LicenseV3 request.
 */
@SuppressWarnings("unused")
public class LicenseV3Params {
    private Map<String, Object> params = new HashMap<>();

    public LicenseV3Params() {
        params.put("limit", "1000");
    }

    public LicenseV3Params userId(String userId) {
        params.put("user_id", userId);
        return this;
    }

    public LicenseV3Params expandHierarchical(Boolean expandHierarchical) {
        params.put("expand_hierarchical", BooleanUtils.toStringTrueFalse(expandHierarchical));
        return this;
    }

    public LicenseV3Params types(List<LicenseType> types) {
        params.put("types", StringUtils.join(types, ",").toLowerCase());
        return this;
    }

    public Map<String, Object> getParams() {
        return params;
    }
}
