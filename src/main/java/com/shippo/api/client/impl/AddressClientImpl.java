package com.shippo.api.client.impl;

import com.shippo.api.client.AddressClient;
import com.shippo.api.model.*;
import com.shippo.api.util.StringUtils;
import com.shippo.api.util.URLBuilder;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddressClientImpl extends BasicClient implements AddressClient  {

    private final static String BASIC_URL = "https://api.goshippo.com/v1/addresses/";

    public AddressClientImpl(Credentials credentials) {
        super(credentials);
    }

    @Override
    public AddressResponse create(Address address) throws Exception {
        String url = new URLBuilder(BASIC_URL)
                .p("name", address.getName())
                .p("object_purpose", address.getObjectPurpose().name())
                .p("company", address.getCompany())
                .p("street1", address.getStreet1())
                .p("street_no", address.getStreetNo())
                .p("street2", address.getStreet2())
                .p("city", address.getCity())
                .p("state", address.getState())
                .p("country", address.getCountry().name())
                .p("phone", address.getPhone())
                .p("email", address.getEmail())
                .p("metadata", address.getMetadata())
                .buildString();

        String json = getResponseWithCredentialsGet(url);
        System.out.println(json);

        JsonNode root = new ObjectMapper().readTree(json);
        JsonNode resultsNode  = root.get("results");
        Iterator<JsonNode> iter = resultsNode.getElements();
        ArrayList<JsonNode> childNodes = new ArrayList<>();
        while (iter.hasNext()) {
            JsonNode n = iter.next();
            childNodes.add(n);
        }

        AddressResponse response = new AddressResponse();
        JsonNode first = childNodes.get(0);
        setAddressResponseFields(first, response);

        return response;
    }

    @Override
    public AddressResponse get(String id) {
        return null;
    }

    @Override
    public List<AddressResponse> listAll() throws Exception {
        String url = new URLBuilder(BASIC_URL).buildString();

        String json = getResponseWithCredentialsGet(url);
        System.out.println(json);

        return null;
    }

    private static void setAddressResponseFields(JsonNode node, AddressResponse response) throws ParseException {
        parseBasicResponseFields(node, response);
        response.setObjectSource(node.get("object_source").asText());
        Address address = new Address();
        setAddressFields(node, address);
        response.setObject(address);
    }

    private static void setAddressFields(JsonNode node, Address o) {
        o.setObjectPurpose(ObjectPurposeEnum.fromString(node.get("object_purpose").asText()));
        o.setName(StringUtils.itrim(node.get("name").asText()));
        o.setCompany(StringUtils.itrim(node.get("company").asText()));
        o.setStreetNo(StringUtils.itrim(node.get("street_no").asText()));
        o.setStreet1(StringUtils.itrim(node.get("street1").asText()));
        o.setStreet2(StringUtils.itrim(node.get("street2").asText()));
        o.setCity(StringUtils.itrim(node.get("city").asText()));
        o.setState(StringUtils.itrim(node.get("state").asText()));
        o.setCountry(CountryCodeEnum.fromString(node.get("object_purpose").asText()));
        o.setPhone(StringUtils.itrim(node.get("phone").asText()));
        o.setEmail(StringUtils.itrim(node.get("email").asText()));
        o.setMetadata(StringUtils.itrim(node.get("metadata").asText()));
        o.setZip(StringUtils.itrim(node.get("zip").asText()));
    }
}
