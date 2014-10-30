package com.shippo.api.client;

import com.shippo.api.client.impl.AddressClientImpl;
import com.shippo.api.client.impl.ParcelClientImpl;
import com.shippo.api.model.Credentials;

public class ClientFactory {
    private final Credentials credentials;

    public ClientFactory(String username, String password) {
        this.credentials = new Credentials(username,password);
    }

    public ClientFactory(Credentials credentials) {
        this(credentials.getUsername(), credentials.getPassword());
    }

    public AddressClient createAddressClient() {
        return new AddressClientImpl(credentials);
    }

    public ParcelClient createParcelClient() {
        return new ParcelClientImpl(credentials);
    }
}
