package com.percolate.sdk.utils;

import com.percolate.sdk.dto.LicenseV3;
import com.percolate.sdk.dto.UserRole;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRolesUtils {

    /**
     * Returns all license IDs associated with a particular role.
     * @return List<String>.
     */
    public static List<String> scopeIdsForUserRole(UserRole userRole, Map<String, List<String>> map) {
        List<String> scopeIds = new ArrayList<String>();
        if (userRole.getScopeId().contains("account")) {
            if (map.get(userRole.getScopeId()) != null) {
                scopeIds.addAll(map.get(userRole.getScopeId()));
            }
        } else {
            scopeIds.add(userRole.getScopeId());
        }
        return scopeIds;
    }

    /**
     * Returns mapping of all session license IDs to account ID.
     * @return {String: List<String>}.
     */
    public static Map<String, List<String>> licensesByAccountID(List<LicenseV3> licenses) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (LicenseV3 license : licenses) {
            if (license.getBrand() == null) {
                continue;
            }
            final String accountID = license.getBrand().getAccountID();
            if (accountID != null && license.getId() != null) {
                final List<String> UIDs = map.get(accountID) != null ? map.get(accountID) : new ArrayList<String>();
                UIDs.add("license:" + license.getId());
                map.put(accountID, UIDs);
            }
        }
        return map;
    }
}