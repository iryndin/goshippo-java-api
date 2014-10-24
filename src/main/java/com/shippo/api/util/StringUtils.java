package com.shippo.api.util;

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
}
