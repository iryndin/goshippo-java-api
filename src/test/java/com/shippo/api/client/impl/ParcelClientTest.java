package com.shippo.api.client.impl;

import com.shippo.api.client.ClientFactory;
import com.shippo.api.client.ParcelClient;
import com.shippo.api.model.*;
import org.junit.Test;

import java.math.BigDecimal;

public class ParcelClientTest {


    static Credentials credentials = new Credentials("mussakulov@rambler.ru","goshippo.com");

    @Test
    public void create() throws Exception {
        ParcelClient client = createParcelClient();
        Parcel p = createParcel();
        System.out.println("Will create parcel: " + p);
        ParcelResponse parcelResponse = client.create(p);
        System.out.println(parcelResponse);
    }


    @Test
    public void listAll() throws Exception {
        ParcelClient client = createParcelClient();
        client.listAll();
    }

    @Test
    public void get() throws Exception {
        ParcelClient client = createParcelClient();
        ParcelResponse parcelResponse = client.get("8ab57c31f77240d194218d6beb302ba7");
        System.out.println(parcelResponse);
    }

    @Test
    public void getFailed() throws Exception {
        ParcelClient client = createParcelClient();
        ParcelResponse parcelResponse = client.get("11");
        System.out.println(parcelResponse);
    }


    public static Parcel createParcel() {
        Parcel a = new Parcel();
        a.setLength(BigDecimal.valueOf(20.5));
        a.setWidth(BigDecimal.valueOf(10.33));
        a.setHeight(BigDecimal.valueOf(5));
        a.setWeight(BigDecimal.valueOf(50.77));
        a.setDistanceUnit(DistanceUnitEnum.CM);
        a.setMassUnit(MassUnitEnum.OZ);
        a.setMetadata("Customer ID 123456");
        a.setTemplate("template 1");
        return a;
    }


    public ParcelClient createParcelClient() {
        return new ClientFactory(credentials).createParcelClient();
    }
}

