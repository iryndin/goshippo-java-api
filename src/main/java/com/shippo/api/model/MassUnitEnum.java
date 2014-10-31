package com.shippo.api.model;

public enum MassUnitEnum {
    g, oz, lb, kg;

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
