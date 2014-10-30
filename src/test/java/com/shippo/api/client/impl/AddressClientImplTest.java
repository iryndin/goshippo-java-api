package com.shippo.api.client.impl;

import com.shippo.api.client.AddressClient;
import com.shippo.api.client.ClientFactory;
import com.shippo.api.model.*;
import org.junit.Test;

public class AddressClientImplTest {

    static Credentials credentials = new Credentials("iryndin@gmail.com","shippoiryndin83");

    @Test
    public void create() throws Exception {
        AddressClient client = createAddressClient();
        Address a = createAddress();
        System.out.println("Will create address: " + a);
        AddressResponse addressResponse = client.create(a);
        System.out.println(addressResponse);
    }

    @Test
    public void createFailed() throws Exception {
        AddressClient client = createAddressClient();
        Address a = createIncorrectAddress();
        System.out.println("Will create address: " + a);
        AddressResponse addressResponse = client.create(a);
        System.out.println(addressResponse);
    }

    @Test
    public void listAll() throws Exception {
        AddressClient client = createAddressClient();
        client.listAll();
    }

    @Test
    public void get() throws Exception {
        AddressClient client = createAddressClient();
        AddressResponse addressResponse = client.get("8ab57c31f77240d194218d6beb302ba7");
        System.out.println(addressResponse);
    }

    @Test
    public void validate() throws Exception {
        AddressClient client = createAddressClient();
        AddressResponse addressResponse = client.validate("8ab57c31f77240d194218d6beb302ba7");
        System.out.println(addressResponse);
    }

    public static Address createAddress() {
        Address a = new Address();
        a.setName("Laura Behrens Wu");
        a.setObjectPurpose(ObjectPurposeEnum.QUOTE);
        a.setCompany("Shippo");
        a.setStreet1("Clayton St.");
        a.setStreetNo("215");
        a.setCity("San Francisco");
        a.setState("CA");
        a.setCountry(CountryCodeEnum.US);
        a.setPhone("+1 555 341 9393");
        a.setEmail("laura@goshippo.com");
        a.setMetadata("Customer ID 123456");
        return a;
    }

    public static Address createIncorrectAddress() {
        Address a = new Address();
        a.setName("Laura Behrens Wu");
        a.setObjectPurpose(ObjectPurposeEnum.QUOTE);
        return a;
    }

    public AddressClient createAddressClient() {
        return new ClientFactory(credentials).createAddressClient();
    }
}

