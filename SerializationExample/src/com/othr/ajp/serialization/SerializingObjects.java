package com.othr.ajp.serialization;

import java.io.*;
import java.net.Socket;

public class SerializingObjects {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final Car car1 = new Car("R-AB123", 125, "MERCEDES");
        System.out.println("Before: " + car1.toString());
        // print to console (write only)
        ObjectOutputStream out = new ObjectOutputStream(System.out);
        out.writeObject(car1);

        // internal array of bytes
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(car1);
        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        final Car car2 = (Car) in.readObject();
        System.out.println("After: " + car2.toString());

        // send over TCP/IP using Socket
        Socket socket = new Socket("localhost", 8080);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(car1);
    }


}


