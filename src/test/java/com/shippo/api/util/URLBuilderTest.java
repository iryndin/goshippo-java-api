package com.shippo.api.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class URLBuilderTest {

    @Test
    public void testAddress() {
        String result = "https://api.goshippo.com/v1/addresses/?name=Laura+Behrens+Wu&object_purpose=PURCHASE&company=Shippo&street1=Clayton+St.&street_no=215&city=San+Francisco&state=CA&country=US&phone=%2B1+555+341+9393&email=laura%40goshippo.com&metadata=Customer+ID+123456";

        String url = new URLBuilder("https://api.goshippo.com/v1/addresses/")
                .p("name", "Laura Behrens Wu")
                .p("object_purpose", "PURCHASE")
                .p("company", "Shippo")
                .p("street1", "Clayton St.")
                .p("street_no", 215)
                .p("street2", "")
                .p("city", "San Francisco")
                .p("state", "CA")
                .p("country", "US")
                .p("phone", "+1 555 341 9393")
                .p("email", "laura@goshippo.com")
                .p("metadata", "Customer ID 123456")
                .buildString();

        assertEquals(result, url);

    }
}
