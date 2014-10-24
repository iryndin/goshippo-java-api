package com.shippo.api.model;

public enum MassUnitEnum {
    G, OZ, LB, KG;

    public static MassUnitEnum fromString(final String s) {
        if (s != null) {
            for (MassUnitEnum e : MassUnitEnum.values()) {
                if (s.equalsIgnoreCase(e.name())) {
                    return e;
                }
            }
        }
        return null;
    }
}
