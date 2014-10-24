package com.shippo.api.model;

public enum ObjectState {
    VALID, INVALID;

    public static ObjectState fromString(final String s) {
        if (s != null) {
            for (ObjectState e : ObjectState.values()) {
                if (s.equalsIgnoreCase(e.name())) {
                    return e;
                }
            }
        }
        return null;
    }
}
