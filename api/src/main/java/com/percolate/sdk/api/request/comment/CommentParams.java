package com.percolate.sdk.api.request.comment;

import org.apache.commons.lang3.BooleanUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Parameters for Comment request.
 */
@SuppressWarnings("unused")
public class CommentParams {
    private Map<String, Object> params = new HashMap<>();

    public CommentParams() {
    }

    public CommentParams objectUid(String objectUid) {
        params.put("object_id", objectUid);
        return this;
    }

    public CommentParams includeUsers(Boolean includeUsers) {
        if(BooleanUtils.toBoolean(includeUsers)){
            params.put("include", "user_id");
        } else {
            params.remove("include");
        }
        return this;
    }

    public CommentParams ids(String ids){
        params.put("ids", ids);
        return this;
    }

    public CommentParams orderBy(String orderBy) {
        params.put("order_by", orderBy);
        return this;
    }

    public CommentParams orderDirection(String orderDirection) {
        params.put("order_direction", orderDirection);
        return this;
    }

    public Map<String, Object> getParams() {
        return params;
    }
}
