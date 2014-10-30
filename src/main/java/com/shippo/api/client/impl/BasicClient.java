package com.shippo.api.client.impl;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Realm;
import com.ning.http.client.Response;
import com.shippo.api.model.BasicResponse;
import com.shippo.api.model.Credentials;
import com.shippo.api.model.ObjectState;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;

public class BasicClient {
    private final Credentials credentials;
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public BasicClient(Credentials credentials) {
        this.credentials = credentials;
    }

    public String getResponseWithCredentialsPost(String surl, String urlParameters) throws IOException, ExecutionException, InterruptedException {
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        Realm realm = new Realm.RealmBuilder()
                .setPrincipal(credentials.getUsername())
                .setPassword(credentials.getPassword())
                .setUsePreemptiveAuth(true)
                .setScheme(Realm.AuthScheme.BASIC)
                .build();
        Response resp = asyncHttpClient.preparePost(surl).setRealm(realm).execute().get();
        return resp.getResponseBody();
    }

    public String getResponseWithCredentialsGet(String surl) throws IOException, ExecutionException, InterruptedException {
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        Realm realm = new Realm.RealmBuilder()
                .setPrincipal(credentials.getUsername())
                .setPassword(credentials.getPassword())
                .setUsePreemptiveAuth(true)
                .setScheme(Realm.AuthScheme.BASIC)
                .build();

        Response resp = asyncHttpClient.prepareGet(surl).setRealm(realm).execute().get();
        return resp.getResponseBody();
    }

    public static final String DATE_FORMAT_STRING  = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    public static final ThreadLocal<SimpleDateFormat> dateFormat = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(DATE_FORMAT_STRING);
        }
    };

    public static void parseBasicResponseFields(JsonNode node, BasicResponse o) throws ParseException {
        String sObjectState = node.get("object_state").asText();
        ObjectState objectState = ObjectState.fromString(sObjectState);
        String sCreateDate = node.get("object_created").asText();
        Date createDate = dateFormat.get().parse(sCreateDate);
        String sUpdateDate = node.get("object_updated").asText();
        Date updateDate = dateFormat.get().parse(sUpdateDate);
        String objectId = node.get("object_id").asText();
        String objectOwner = node.get("object_owner").asText();

        o.setObjectState(objectState);
        o.setCreateDate(createDate);
        o.setUpdateDate(updateDate);
        o.setId(objectId);
        o.setOwner(objectOwner);
    }

    protected JsonNode parseJson(String json) throws IOException {
        JsonNode root = objectMapper.readTree(json);
        return root;
    }

    protected ArrayList<JsonNode> getArrayElements(JsonNode arrayNode) {
        Iterator<JsonNode> iter = arrayNode.getElements();
        ArrayList<JsonNode> arrayNodeList = new ArrayList<>();
        while (iter.hasNext()) {
            JsonNode n = iter.next();
            arrayNodeList.add(n);
        }
        return arrayNodeList;
    }
}
