package com.percolate.sdk.api.request.authorization;

import com.percolate.sdk.api.config.Endpoints;
import com.percolate.sdk.dto.UserRoles;
import com.percolate.sdk.dto.UserRolesV5;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

import java.util.Map;

/**
 * Percolate user roles (v3 and v5) API definitions.
 */
interface UserRolesService {

    @GET(Endpoints.API_V5_PATH + "/user_role/")
    Call<UserRolesV5> get(@QueryMap Map<String, Object> params);
}
