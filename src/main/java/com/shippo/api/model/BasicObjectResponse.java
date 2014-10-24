package com.shippo.api.model;

/**
 * Created by iryndin on 24.10.14.
 */
public class BasicObjectResponse<T> extends BasicResponse {
    private T object;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
