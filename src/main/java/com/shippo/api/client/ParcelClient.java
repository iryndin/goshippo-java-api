package com.shippo.api.client;

import com.shippo.api.model.ParcelResponse;
import com.shippo.api.model.Parcel;

import java.util.List;

/**
 * Created by iryndin on 24.10.14.
 */
public interface ParcelClient {

    ParcelResponse create(Parcel parcel) throws Exception;
    ParcelResponse get(String id);
    List<ParcelResponse> listAll() throws Exception;
}
