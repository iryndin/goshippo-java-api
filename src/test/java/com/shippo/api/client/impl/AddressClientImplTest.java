package com.shippo.api.client.impl;

import com.shippo.api.TestUtils;
import com.shippo.api.client.AddressClient;
import com.shippo.api.client.ClientFactory;
import com.shippo.api.model.*;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class AddressClientImplTest {

    static Credentials credentials = new Credentials("iryndin@gmail.com","shippoiryndin83");

    @Test
    public void create() throws Exception {
        AddressClient client = createAddressClient();
        Address a = createAddress();
        System.out.println("Will create address: " + a);
        AddressResponse addressResponse = client.create(a);
        //System.out.println(addressResponse);
        compareAddressAndResponse(a, addressResponse);
    }

    static void compareAddressAndResponse(Address a, AddressResponse addressResponse) {
        assertEquals(a.getName(), addressResponse.getObject().getName());
        assertEquals(a.getObjectPurpose(), addressResponse.getObject().getObjectPurpose());
        assertEquals(a.getCompany(), addressResponse.getObject().getCompany());
        assertEquals(a.getStreet1(), addressResponse.getObject().getStreet1());
        assertEquals(a.getStreet2(), addressResponse.getObject().getStreet2());
        assertEquals(a.getStreetNo(), addressResponse.getObject().getStreetNo());
        assertEquals(a.getCity(), addressResponse.getObject().getCity());
        assertEquals(a.getState(), addressResponse.getObject().getState());
        assertEquals(a.getZip(), addressResponse.getObject().getZip());
        assertEquals(a.getCountry(), addressResponse.getObject().getCountry());
        //assertEquals(a.getPhone(), addressResponse.getObject().getPhone());
        assertEquals(a.getEmail(), addressResponse.getObject().getEmail());
        assertEquals(a.getMetadata(), addressResponse.getObject().getMetadata());
    }

    @Test
    public void listAll() throws Exception {
        AddressClient client = createAddressClient();
        List<AddressResponse> list =  client.listAll();
        System.out.println("size: " + list.size());
        System.out.println(list);
    }

    @Test
    public void complexTest() throws Exception {
        AddressClient client = createAddressClient();
        int N = 5;
        for (int i=0; i<N; i++) {
            Address a = createRandomAddress();
            AddressResponse addressResponse = client.create(a);
            compareAddressAndResponse(a, addressResponse);
            AddressResponse addressResponse2 = client.get(addressResponse.getId());
            compareAddressAndResponse(a, addressResponse2);
        }
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
        a.setZip("99978");
        a.setCountry(CountryCodeEnum.US);
        a.setPhone("+1 555 341 9393");
        a.setEmail("laura@goshippo.com");
        a.setMetadata("Customer ID 123456");
        return a;
    }

    public static Address createRandomAddress() {
        Address a = new Address();
        a.setName(TestUtils.randomAlphas(10) + " " + TestUtils.randomAlphas(20));
        a.setObjectPurpose(TestUtils.randomEnum(ObjectPurposeEnum.class));
        a.setCompany(TestUtils.randomAlphas(5));
        a.setStreet1(TestUtils.randomAlphas(8) + " St.");
        a.setStreetNo(TestUtils.randomDigits(3));
        a.setCity("San Francisco");
        a.setState("CA");
        a.setZip(TestUtils.randomDigits(5));
        a.setCountry(TestUtils.randomEnum(CountryCodeEnum.class));
        a.setPhone("+1 " + TestUtils.randomDigits(10));
        a.setEmail(TestUtils.randomAlphas(5)+"@"+TestUtils.randomAlphas(10)+".com");
        a.setMetadata(TestUtils.randomAlphas(20));
        return a;
    }

    public AddressClient createAddressClient() {
        return new ClientFactory(credentials).createAddressClient();
    }
}

