package com.othr.ajp.serialization;

import java.io.*;

public class SerializingObjects {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final Car car1 = new Car(1, "R-AB123", 125, new Manufacturer("MERCEDES"));
        System.out.println("Before: " + car1.toString());
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(new File("car.ser")));
        out.writeObject(car1);

        ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(
                new FileInputStream("car.ser")));
        Car car2 = (Car) in.readObject();
        System.out.println("After: " + car2.toString());
    }


}


