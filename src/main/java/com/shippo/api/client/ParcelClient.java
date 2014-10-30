package com.shippo.api.client;

import com.shippo.api.model.ParcelResponse;
import com.shippo.api.model.Parcel;

import java.util.List;

public interface ParcelClient {

    ParcelResponse create(Parcel parcel) throws Exception;
    ParcelResponse get(String id) throws Exception ;
    List<ParcelResponse> listAll() throws Exception;
}
