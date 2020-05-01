package com.othr.ajp.mocker;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class Mocker {

    static MethodHandler handler = (self, method, proceed, args) -> {
        System.out.println("Handling " + method + " via method handler");
        return proceed.invoke(self, args);
    };

    public static <T> T mock(Class<T> clazz) {
        ProxyFactory factory = new ProxyFactory();
        factory.setSuperclass(clazz);
        factory.setInterfaces(clazz.getInterfaces());
        try {
            return (T)factory.create(new Class<?>[0], new Object[0], handler);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T verify(T mockObject) {
        if (mockObject == null)
            throw new AssertionError();
        return mockObject;
    }


}
