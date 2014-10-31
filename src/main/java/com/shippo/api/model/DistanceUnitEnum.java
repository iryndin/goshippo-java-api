package com.shippo.api.model;

public enum DistanceUnitEnum {
    cm, in, ft, mm, m, yd;

    public static DistanceUnitEnum fromString(final String s) {
        if (s != null) {
            for (DistanceUnitEnum e : DistanceUnitEnum.values()) {
                if (s.equalsIgnoreCase(e.name())) {
                    return e;
                }
            }
        }
        return null;
    }
}
