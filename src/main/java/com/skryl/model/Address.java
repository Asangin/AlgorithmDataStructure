package com.skryl.model;

/**
 * @author Skryl D.V. on 2023-02-04
 */
public class Address {
    String city;
    String state;
    int zipCode;

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public Address setState(String state) {
        this.state = state;
        return this;
    }

    public int getZipCode() {
        return zipCode;
    }

    public Address setZipCode(int zipCode) {
        this.zipCode = zipCode;
        return this;
    }
}
