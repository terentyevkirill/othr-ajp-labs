package com.othr.ajp.serialization;

import java.io.*;

public class SerializingObjects {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final Car car1 = new Car("R-AB123", 125, "MERCEDES");
        File file;
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(
                        new File("car.ser")));

        System.out.println("Before serialization: " + car1.toString());
        out.writeObject(car1);

        ObjectInputStream in = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(
                                new File("car.ser"))));

        final Car car2 = (Car) in. readObject();
        System.out.println("After serialization: " + car2.toString());


    }
}
