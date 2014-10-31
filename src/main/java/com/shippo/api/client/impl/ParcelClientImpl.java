package com.shippo.api.client.impl;

import com.shippo.api.client.ParcelClient;
import com.shippo.api.model.*;
import com.shippo.api.util.ParamsHolder;
import com.shippo.api.util.StringUtils;
import com.shippo.api.util.URLBuilder;
import org.codehaus.jackson.JsonNode;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ParcelClientImpl extends BasicClient implements ParcelClient {

    private final static String BASIC_URL = "https://api.goshippo.com/v1/parcels/";

    public ParcelClientImpl(Credentials credentials) {
        super(credentials);
    }

    @Override
    public ParcelResponse create(Parcel parcel) throws Exception {
        ParamsHolder paramsHolder = new ParamsHolder()
                .p("length", parcel.getLength())
                .p("width", parcel.getWidth())
                .p("height", parcel.getHeight())
                .p("weight", parcel.getWeight())
                .p("distance_unit", parcel.getDistanceUnit())
                .p("mass_unit", parcel.getMassUnit())
                .p("metadata", parcel.getMetadata());

        System.out.println("Try create parcel: " + parcel);
        String json = getResponseWithCredentialsPost(BASIC_URL, paramsHolder);
        System.out.println("Create parcel: " + json);

        JsonNode root = parseJson(json);
        ParcelResponse response = new ParcelResponse();
        setParcelResponseFields(root, response);

        return response;
    }

    @Override
    public ParcelResponse get(String id) throws Exception {
        String url = new URLBuilder(BASIC_URL).a(id).buildString();

        String json = getResponseWithCredentialsGet(url);
        System.out.println("Get parcel: " + json);
        JsonNode root = parseJson(json);
        ParcelResponse parcelResponse = new ParcelResponse();
        setParcelResponseFields(root, parcelResponse);

        return parcelResponse;
    }

    @Override
    public List<ParcelResponse> listAll() throws Exception {
        String url = new URLBuilder(BASIC_URL).buildString();

        String json = getResponseWithCredentialsGet(url);
        JsonNode root = parseJson(json);
        ArrayList<JsonNode> childNodes = getArrayElements(root.get("results"));
        List<ParcelResponse> list = new ArrayList<>(childNodes.size());
        for (JsonNode e : childNodes) {
            ParcelResponse parcelResponse = new ParcelResponse();
            setParcelResponseFields(e,parcelResponse);
            list.add(parcelResponse);
        }
        return list;
    }

    private void setParcelResponseFields(JsonNode node, ParcelResponse response) throws ParseException {
        parseBasicResponseFields(node, response);
        Parcel parcel = new Parcel();
        setParcelFields(node, parcel);
        response.setObject(parcel);
    }

    private void setParcelFields(JsonNode node, Parcel o) {
        o.setLength(StringUtils.parseBigDecimal(node.get("length").asText()));
        o.setWidth(StringUtils.parseBigDecimal(node.get("width").asText()));
        o.setHeight(StringUtils.parseBigDecimal(node.get("height").asText()));
        o.setWeight(StringUtils.parseBigDecimal(node.get("weight").asText()));
        o.setMetadata(StringUtils.itrim(node.get("metadata").asText()));
        o.setTemplate(StringUtils.itrim(node.get("template").asText()));
        o.setDistanceUnit(DistanceUnitEnum.fromString(node.get("distance_unit").asText()));
        o.setMassUnit(MassUnitEnum.fromString(node.get("mass_unit").asText()));
    }
}
