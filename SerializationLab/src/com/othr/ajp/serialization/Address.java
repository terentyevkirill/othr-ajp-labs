package com.othr.ajp.serialization;

import java.io.Serializable;

public class Address implements Serializable {
    private final String street;
    private final String zipCode;
    private final String town;
    private final String country;

    public Address(String street, String zipCode, String town, String country) {
        this.street = street;
        this.zipCode = zipCode;
        this.town = town;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", town='" + town + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
