package com.othr.ajp.reflections;

public class ClassPrinter {
    private Class<?> clazz;

    public ClassPrinter(Class<?> clazz) {
        this.clazz = clazz;
    }

    public static void main(String[] args) {
        String className = "java.util.LinkedHashMap";
        if (args.length > 0) {
            className = args[0];
        }

        System.out.println(className);
    }
}
