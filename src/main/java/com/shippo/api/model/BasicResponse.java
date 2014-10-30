package com.shippo.api.model;

import java.util.Date;

/**
 * Created by iryndin on 24.10.14.
 */
public class BasicResponse {
    private ObjectState objectState;
    private Date createDate;
    private Date updateDate;
    private String id;
    private String owner;

    public ObjectState getObjectState() {
        return objectState;
    }

    public void setObjectState(ObjectState objectState) {
        this.objectState = objectState;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String basicResponseToString() {
        return
                "objectState=" + objectState +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", id='" + id + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
