package com.shippo.api.model;

public class AddressResponse extends BasicObjectResponse<Address> {
    private String objectSource;

    public String getObjectSource() {
        return objectSource;
    }

    public void setObjectSource(String objectSource) {
        this.objectSource = objectSource;
    }

    @Override
    public String toString() {
        return "AddressResponse{" +
                "objectSource='" + objectSource + '\'' +
                ", objectState=" + getObjectState() +
                ", createDate=" + getCreateDate() +
                ", updateDate=" + getUpdateDate() +
                ", id='" + getId() + '\'' +
                ", owner='" + getOwner() + '\'' +
                ", object=" + getObject() +
                "} ";
    }
}
