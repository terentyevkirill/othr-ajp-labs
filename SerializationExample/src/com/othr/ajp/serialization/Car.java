package com.othr.ajp.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class Car extends Vehicle implements Serializable {   // inheritance
    private String registration;                            // delegation
    private int horsePowers;
    private Manufacturer make;                              // delegation

    public Car() {
        System.out.println("Car()");
    }

    public Car(int regId, String registration, int horsePowers, Manufacturer make) {
        super(regId);
        this.registration = registration;
        this.horsePowers = horsePowers;
        this.make = make;
    }

    @Override
    public String toString() {
        return "Car{" +
                "registration='" + registration + '\'' +
                ", horsePowers=" + horsePowers +
                ", make='" + make.toString() + '\'' +
                ", object=" + super.toString() + '\'' +
                '}';
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();   // should be called only in writeObject()
        out.writeInt(super.vehicleId);
        out.writeUTF(this.make.getManufacturerName());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();     // should be called only in readObject()
        super.vehicleId = in.readInt();
        this.make = new Manufacturer(in.readUTF());
    }
}
