package com.othr.ajp.serialization;

import java.io.Serializable;

public class Car implements Serializable {
    private String registration;
    private int horsePowers;
    private String make;

    public Car(String registration, int horsePowers, String make) {
        this.registration = registration;
        this.horsePowers = horsePowers;
        this.make = make;
    }

    @Override
    public String toString() {
        return "Car{" +
                "registration='" + registration + '\'' +
                ", horsePowers=" + horsePowers +
                ", make='" + make + '\'' +
                ", object=" + super.toString() + '\'' +
                '}';
    }
}
