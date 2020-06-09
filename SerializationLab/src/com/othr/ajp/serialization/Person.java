package com.othr.ajp.serialization;

import java.awt.Color;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Person implements Serializable {
    private String[] firstnames;
    private String lastname;
    private String socialSecurityNumber;
    private Date dateOfBirth;
    private Color eyeColor;
    private Address currentAddress;
    private List<Address> formerAdresses;

    public Person(String[] firstnames, String lastname, String socialSecurityNumber, Date dateOfBirth, Color eyeColor, Address currentAddress, List<Address> formerAdresses) {
        this.firstnames = firstnames;
        this.lastname = lastname;
        this.socialSecurityNumber = socialSecurityNumber;
        this.dateOfBirth = dateOfBirth;
        this.eyeColor = eyeColor;
        this.currentAddress = currentAddress;
        this.formerAdresses = formerAdresses;
    }

    public String[] getFirstnames() {
        return firstnames;
    }

    public void setFirstnames(String[] firstnames) {
        this.firstnames = firstnames;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Color getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(Color eyeColor) {
        this.eyeColor = eyeColor;
    }

    public Address getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(Address currentAddress) {
        this.currentAddress = currentAddress;
    }

    public List<Address> getFormerAdresses() {
        return formerAdresses;
    }

    public void setFormerAdresses(List<Address> formerAdresses) {
        this.formerAdresses = formerAdresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        return getSocialSecurityNumber() != null ? getSocialSecurityNumber().equals(person.getSocialSecurityNumber()) : person.getSocialSecurityNumber() == null;
    }

    @Override
    public int hashCode() {
        return getSocialSecurityNumber() != null ? getSocialSecurityNumber().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstnames=" + Arrays.toString(firstnames) +
                ", lastname='" + lastname + '\'' +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", dateOfBirth=" + new SimpleDateFormat("dd-MM-yyyy").format(dateOfBirth) +
                ", currentAddress=" + currentAddress +
                ", formerAdresses=" + formerAdresses +
                ", " + super.toString() +
                '}';
    }
}
