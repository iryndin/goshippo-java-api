package com.shippo.api;

import java.math.BigDecimal;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class TestUtils {
    static final String DIGITS = "0123456789";

    static final String ALPHAS = "abcdefghijklmnopqrstuvwxyz";

    public static String randomDigits(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i=0; i<len; i++) {
            sb.append(DIGITS.charAt(new Random().nextInt(DIGITS.length())));
        }
        return sb.toString();
    }

    public static String randomAlphas(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i=0; i<len; i++) {
            sb.append(ALPHAS.charAt(new Random().nextInt(ALPHAS.length())));
        }
        return sb.toString();
    }

    public static BigDecimal randomBigDecimal() {
        StringBuilder sb = new StringBuilder(16);
        sb.append(1+new Random().nextInt(100)).append(".").append(new Random().nextInt(90));
        return new BigDecimal(sb.toString());
    }

    public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
        int x = new Random().nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    public static void assertBigDecimalEquals(BigDecimal a, BigDecimal b) {
        System.out.println("Compare " + a + " and " + b);
        assertEquals(0, a.compareTo(b));
    }
}
