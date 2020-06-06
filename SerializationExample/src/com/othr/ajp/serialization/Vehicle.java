package com.othr.ajp.serialization;

import java.io.Serializable;

public class Vehicle {
    protected int vehicleId;

    public Vehicle(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Vehicle() {
        System.out.println("Vehicle()");
    }
}


