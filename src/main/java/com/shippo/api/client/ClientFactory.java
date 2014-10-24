package com.shippo.api.client;

import com.shippo.api.client.impl.AddressClientImpl;
import com.shippo.api.model.Credentials;

public class ClientFactory {
    private final Credentials credentials;

    public ClientFactory(String username, String password) {
        this.credentials = new Credentials(username,password);
    }

    public AddressClient createAddressClient() {
        return new AddressClientImpl(credentials);
    }
}
