package com.percolate.sdk.api.request.authorization;

import com.percolate.sdk.api.PercolateApi;
import com.percolate.sdk.api.utils.RetrofitApiFactory;
import com.percolate.sdk.dto.UserRoles;
import com.percolate.sdk.dto.UserRolesV5;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

/**
 * User roles request proxy.
 */
@SuppressWarnings("unused")
public class UserRolesRequest {

    private UserRolesService service;

    public UserRolesRequest(@NotNull PercolateApi context) {
        this.service = new RetrofitApiFactory(context).getService(UserRolesService.class);
    }
    
    /**
     * Query user roles endpoint.
     *
     * @param params API params.
     * @return {@link Call} object.
     */
    public Call<UserRolesV5> get(@NotNull final UserRolesV5Params params) {
        return service.get(params.getParams());
    }
}
