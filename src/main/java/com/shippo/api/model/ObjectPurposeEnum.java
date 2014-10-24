package com.shippo.api.model;

/**
 * User: iryndin
 * Date: 21.10.14 23:54
 */
public enum ObjectPurposeEnum {
    QUOTE, PURCHASE;

    public static ObjectPurposeEnum fromString(final String s) {
        if (s != null) {
            for (ObjectPurposeEnum e : ObjectPurposeEnum.values()) {
                if (s.equalsIgnoreCase(e.name())) {
                    return e;
                }
            }
        }
        return null;
    }
}
