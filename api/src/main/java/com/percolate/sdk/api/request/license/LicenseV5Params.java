package com.percolate.sdk.api.request.license;

import com.percolate.sdk.enums.LicenseStatus;
import com.percolate.sdk.enums.LicenseType;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Parameters for LicenseV5 request.
 */
public class LicenseV5Params {
    private Map<String, Object> params = new HashMap<>();

    public LicenseV5Params(String tenantId) {
        params.put("tenant_id", tenantId);
    }

    public LicenseV5Params(String[] licenseIds) {
        params.put("ids", StringUtils.join(licenseIds, ","));
    }

    public LicenseV5Params limit(int limit) {
        params.put("limit", limit);
        return this;
    }

    public LicenseV5Params offset(int offset) {
        params.put("offset", offset);
        return this;
    }

    public LicenseV5Params types(List<LicenseType> types) {
        params.put("types", StringUtils.join(types, ",").toLowerCase());
        return this;
    }

    public LicenseV5Params statuses(LicenseStatus status) {
        params.put("statuses", status.toString().toLowerCase());
        return this;
    }

    public Map<String, Object> getParams() {
        return params;
    }
}
