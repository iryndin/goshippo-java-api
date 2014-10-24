package com.shippo.api.model;

public class AddressBuilder implements AbstractBuilder<Address> {

    private ObjectPurposeEnum objectPurpose;
    private String name;
    private String company;
    private String street1;
    private String streetNo;
    private String street2;
    private String city;
    private String zip;
    private String state;
    private CountryCodeEnum country;
    private String phone;
    private String email;
    private String metadata;

    public AddressBuilder() {

    }

    public AddressBuilder withObjectPurpose(ObjectPurposeEnum objectPurpose) {
        this.objectPurpose = objectPurpose;
        return this;
    }

    public AddressBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public AddressBuilder withCompany(String company) {
        this.company = company;
        return this;
    }

    @Override
    public Address build() {
        return new Address(objectPurpose, name, company, street1, streetNo, street2, city, zip, state, country, phone, email, metadata);
    }
}
