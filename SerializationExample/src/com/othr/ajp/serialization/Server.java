package com.othr.ajp.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();
        Car received = (Car) new ObjectInputStream(socket.getInputStream()).readObject();
        System.out.println("After: " + received.toString());
    }
}
