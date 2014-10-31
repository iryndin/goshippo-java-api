package com.shippo.api.client.impl;

import com.shippo.api.TestUtils;
import com.shippo.api.client.ClientFactory;
import com.shippo.api.client.ParcelClient;
import com.shippo.api.model.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static com.shippo.api.TestUtils.assertBigDecimalEquals;
import static org.junit.Assert.assertEquals;

public class ParcelClientTest {


    static Credentials credentials = new Credentials("mussakulov@rambler.ru","goshippo.com");

    @Test
    public void create() throws Exception {
        ParcelClient client = createParcelClient();
        Parcel p = createParcel();
        System.out.println("Will create parcel: " + p);
        ParcelResponse parcelResponse = client.create(p);
        System.out.println(parcelResponse);
        compareParcelAndResponse(p, parcelResponse);
    }

    static void compareParcelAndResponse(Parcel a, ParcelResponse parcelResponse) {
        System.out.println("Compare " + a + " and " + parcelResponse.getObject());
        //assertEquals(a.getLength(), parcelResponse.getObject().getLength());
        //assertEquals(a.getWidth(), parcelResponse.getObject().getWidth());
        //assertEquals(a.getHeight(), parcelResponse.getObject().getHeight());
        //assertEquals(a.getWeight(), parcelResponse.getObject().getWeight());
        assertBigDecimalEquals(a.getLength(), parcelResponse.getObject().getLength());
        assertBigDecimalEquals(a.getWidth(), parcelResponse.getObject().getWidth());
        assertBigDecimalEquals(a.getHeight(), parcelResponse.getObject().getHeight());
        assertBigDecimalEquals(a.getWeight(), parcelResponse.getObject().getWeight());
        //assertEquals(a.getTemplate(), addressResponse.getObject().getTemplate());
        assertEquals(a.getMetadata(), parcelResponse.getObject().getMetadata());
        assertEquals(a.getMassUnit(), parcelResponse.getObject().getMassUnit());
        assertEquals(a.getDistanceUnit(), parcelResponse.getObject().getDistanceUnit());
    }


    @Test
    public void listAll() throws Exception {
        ParcelClient client = createParcelClient();
        List<ParcelResponse> list = client.listAll();
        System.out.println("size: " + list.size());
        System.out.println(list);
    }

    @Test
    public void complexTest() throws Exception {
        ParcelClient client = createParcelClient();
        int N = 5;
        for (int i=0; i<N; i++) {
            System.out.println("Try: " + i);
            Parcel a = createRandomParcel();
            ParcelResponse parcelResponse = client.create(a);
            compareParcelAndResponse(a, parcelResponse);
            System.out.println("Compare created object ok");
            ParcelResponse parcelResponse2 = client.get(parcelResponse.getId());
            compareParcelAndResponse(a, parcelResponse2);
            System.out.println("Compare retrieved object ok");
        }
    }

    public static Parcel createParcel() {
        Parcel a = new Parcel();
        a.setLength(BigDecimal.valueOf(20.5));
        a.setWidth(BigDecimal.valueOf(10.33));
        a.setHeight(BigDecimal.valueOf(5));
        a.setWeight(BigDecimal.valueOf(50.77));
        a.setDistanceUnit(DistanceUnitEnum.cm);
        a.setMassUnit(MassUnitEnum.oz);
        a.setMetadata("Customer ID 123456");
        a.setTemplate("template 1");
        return a;
    }

    public static Parcel createRandomParcel() {
        Parcel a = new Parcel();
        a.setLength(TestUtils.randomBigDecimal());
        a.setWidth(TestUtils.randomBigDecimal());
        a.setHeight(TestUtils.randomBigDecimal());
        a.setWeight(TestUtils.randomBigDecimal());
        a.setDistanceUnit(TestUtils.randomEnum(DistanceUnitEnum.class));
        a.setMassUnit(TestUtils.randomEnum(MassUnitEnum.class));
        a.setMetadata(TestUtils.randomAlphas(20));
        a.setTemplate(TestUtils.randomAlphas(20));

        return a;
    }


    public ParcelClient createParcelClient() {
        return new ClientFactory(credentials).createParcelClient();
    }
}

