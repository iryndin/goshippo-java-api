package com.shippo.api.util;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * User: iryndin
 * Date: 22.10.14 0:35
 */
public class URLBuilder {

    private final String basicUrl;
    private final Map<String,Object> params = new LinkedHashMap<>();

    public URLBuilder(String basicUrl) {
        this.basicUrl = basicUrl;
    }

    public URLBuilder p(String name, String value) {
        if (value != null && !value.isEmpty()) {
            params.put(name, value);
        }
        return this;
    }

    public URLBuilder p(String name, int value) {
        params.put(name, value);
        return this;
    }

    public URLBuilder pp(String name, String value) {
        params.put(name, value);
        return this;
    }

    public String buildString() {
        if (params.isEmpty()) {
            return basicUrl;
        } else {
            StringBuilder sb = new StringBuilder(basicUrl);
            sb.append("?").append(getParameterString());
            return sb.toString();
        }
    }

    public String getParameterString() {
        StringBuilder sb = new StringBuilder(1024);
        for (Map.Entry<String,Object> e : params.entrySet()) {
            sb.append(e.getKey()).append("=").append(urlEncode(e.getValue().toString())).append("&");
        }
        // remove last '&' symbol
        return sb.substring(0, sb.length()-1);
    }

    public URL buildUrl() throws MalformedURLException {
        return new URL(buildString());
    }

    private String urlEncode(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }
}
