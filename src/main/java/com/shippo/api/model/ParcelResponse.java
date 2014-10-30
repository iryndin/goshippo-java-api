package com.shippo.api.model;

public class ParcelResponse extends BasicObjectResponse<Parcel> {

    @Override
    public String toString() {
        return "ParcelResponse{" +
                basicResponseToString() +
                ", object=" + getObject() +
                "} ";
    }
}
