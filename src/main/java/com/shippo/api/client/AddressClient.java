package com.shippo.api.client;

import com.shippo.api.model.Address;
import com.shippo.api.model.AddressResponse;

import java.util.List;

public interface AddressClient {

    AddressResponse create(Address address) throws Exception;
    AddressResponse get(String id) throws Exception;
    AddressResponse validate(String id) throws Exception;
    List<AddressResponse> listAll() throws Exception;
}
