package com.shippo.api.model;


public class Credentials {
    private final String username;
    private final String password;

    public Credentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Credentials(Credentials credentials) {
        this.username = credentials.getUsername();
        this.password = credentials.getPassword();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
