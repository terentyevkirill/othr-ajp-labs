package com.othr.ajp.serialization;

import java.awt.*;
import java.io.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static com.othr.ajp.serialization.EmployeeStatus.*;

public class Serialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Employee employee1 = new Employee(
                new String[]{"Kyrylo"},
                "Terentiev",
                "abcd1234",
                new Date(1999 - 1900, Calendar.DECEMBER, 7),
                Color.GREEN,
                new Address("Weiherweg 6", "93051", "Regensburg", "Germany"),
                List.of(new Address("Dovzhenka 9", "65058", "Odessa", "Ukraine")),
                1234,
                "Software Development",
                BigDecimal.valueOf(70000), WORKER);

        Employee employee2 = new Employee(
                new String[]{"Max", "Maximus"},
                "Mustermann",
                "dcba4321",
                new Date(2000 - 1900, Calendar.JULY, 12),
                Color.GRAY,
                new Address("Musterstrasse 1", "66666", "Musterstadt", "Musterland"),
                List.of(new Address("Dahauplatz 6", "93050", "Regensburg", "Germany")),
                4321,
                "Quality Assurance",
                BigDecimal.valueOf(25000), INTERN);
        System.out.println("ObjectStream:");
        System.out.println("Before: " + employee1);
        System.out.println("Before: " + employee2);

        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(new File("empl.ser")));
        out.writeObject(employee1);
//        out.writeObject(employee2);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("empl.ser"));
        employee1 = (Employee) in.readObject();
//        employee2 = (Employee) in.readObject();

        System.out.println("After: " + employee1);
        System.out.println("After: " + employee2);


        System.out.println("ByteArrayStream:");
        System.out.println("Before: " + employee1);
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        new ObjectOutputStream(byteOut).writeObject(employee1);
        employee1 = (Employee) new ObjectInputStream(new ByteArrayInputStream(byteOut.toByteArray())).readObject();
        System.out.println("After: " + employee1);
        System.out.println("Size in bytes: " + byteOut.toByteArray().length);
    }
}
