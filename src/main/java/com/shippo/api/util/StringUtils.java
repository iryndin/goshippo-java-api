package com.shippo.api.util;

import java.math.BigDecimal;

public class StringUtils {

    public static String itrim(String s) {
        if (s != null) {
            s = s.trim();
            if (s.isEmpty()) {
                s = null;
            }
        }
        return s;
    }

    public static BigDecimal parseBigDecimal(String s) {
        s = itrim(s);
        if (s != null) {
            return new BigDecimal(s);
        } else {
            return null;
        }
    }
}
