package com.shippo.api.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ParamsHolder {
    private final Map<String,Object> params = new LinkedHashMap<>();

    public ParamsHolder p(String name, String value) {
        if (value != null && !value.isEmpty()) {
            params.put(name, value);
        }
        return this;
    }

    public ParamsHolder p(String name, Enum<? extends Enum> value) {
        if (value != null) {
            params.put(name, value.name());
        }
        return this;
    }

    public ParamsHolder p(String name, Number n) {
        if (n != null) {
            params.put(name, n.toString());
        }
        return this;
    }

    public ParamsHolder p(String name, int value) {
        params.put(name, value);
        return this;
    }

    public Set<Map.Entry<String, Object>> set() {
        return params.entrySet();
    }
}
