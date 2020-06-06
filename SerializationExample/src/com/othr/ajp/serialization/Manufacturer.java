package com.othr.ajp.serialization;

import java.io.Serializable;

public class Manufacturer implements Serializable {
    private String manufacturerName;

    public Manufacturer(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "manufacturerName='" + manufacturerName + '\'' +
                '}';
    }

    public String getManufacturerName() {
        return manufacturerName;
    }
}
