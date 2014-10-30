package com.shippo.api.client.impl;

import com.shippo.api.model.*;
import org.junit.Test;

public class AddressClientImplTest {

    static Credentials credentials = new Credentials("iryndin@gmail.com","shippoiryndin83");

    @Test
    public void create() throws Exception {
        AddressClientImpl client = new AddressClientImpl(credentials);
        Address a = createAddress();
        System.out.println("Will create address: " + a);
        AddressResponse addressResponse = client.create(a);
        System.out.println(addressResponse);
    }

    @Test
    public void listAll() throws Exception {
        AddressClientImpl client = new AddressClientImpl(credentials);
        client.listAll();
    }

    @Test
    public void get() throws Exception {
        AddressClientImpl client = new AddressClientImpl(credentials);
        AddressResponse addressResponse = client.get("8ab57c31f77240d194218d6beb302ba7");
        System.out.println(addressResponse);
    }

    @Test
    public void validate() throws Exception {
        AddressClientImpl client = new AddressClientImpl(credentials);
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

    /*
    @Test
    public void testJson() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree("{\"count\": 1, \"next\": null, \"previous\": null, \"results\": [{\"object_state\": \"VALID\", \"object_purpose\": \"PURCHASE\", \"object_source\": \"FULLY_ENTERED\", \"object_created\": \"2014-10-23T21:49:35.738Z\", \"object_updated\": \"2014-10-23T21:49:35.738Z\", \"object_id\": \"8ab57c31f77240d194218d6beb302ba7\", \"object_owner\": \"iryndin@gmail.com\", \"name\": \"1\", \"company\": \"1\", \"street_no\": \"1\", \"street1\": \"1\", \"street2\": \"1\", \"city\": \"1\", \"state\": \"CA\", \"zip\": \"111111\", \"country\": \"AF\", \"phone\": \"1\", \"email\": \"ee@ee.com\", \"ip\": null, \"messages\": [], \"metadata\": \"\"}]}");
        JsonNode resultsNode  = root.get("results");
        Iterator<JsonNode> iter = resultsNode.getElements();
        while (iter.hasNext()) {
            JsonNode n = iter.next();
            System.out.println("+++++++++++");
            System.out.println(n);
        }
    }

    @Test
    public void testSDF() throws Exception {
        String s = "2014-10-23T21:49:35.738Z";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date d = sdf.parse(s);
        System.out.println(d);
    }
    */
}

