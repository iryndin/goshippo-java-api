package com.shippo.api.model;

/**
 * User: iryndin
 * Date: 21.10.14 23:51
 */
public class Address {
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

    public Address() {
    }

    public Address(ObjectPurposeEnum objectPurpose, String name, String company, String street1, String streetNo, String street2, String city, String zip, String state, CountryCodeEnum country, String phone, String email, String metadata) {
        this.objectPurpose = objectPurpose;
        this.name = name;
        this.company = company;
        this.street1 = street1;
        this.streetNo = streetNo;
        this.street2 = street2;
        this.city = city;
        this.zip = zip;
        this.state = state;
        this.country = country;
        this.phone = phone;
        this.email = email;
        this.metadata = metadata;
    }

    public ObjectPurposeEnum getObjectPurpose() {
        return objectPurpose;
    }

    public void setObjectPurpose(ObjectPurposeEnum objectPurpose) {
        this.objectPurpose = objectPurpose;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public CountryCodeEnum getCountry() {
        return country;
    }

    public void setCountry(CountryCodeEnum country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "Address{" +
                "objectPurpose=" + objectPurpose +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", street1='" + street1 + '\'' +
                ", streetNo='" + streetNo + '\'' +
                ", street2='" + street2 + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", state='" + state + '\'' +
                ", country=" + country +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", metadata='" + metadata + '\'' +
                '}';
    }
}
