package com.othr.ajp.mocker;

import javassist.util.proxy.MethodFilter;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// not a mocker, but a spy, in current implementation
public class Mocker {

    // invocation - invocationCount
    private static Map<Invocation, Integer> invocations = new HashMap<>();
    private static boolean toVerify = false;
    private static VerificationDetail verificationDetail;

    private static MethodFilter filter = (method -> !Arrays.asList(Object.class.getMethods()).contains(method) && !method.getName().equals("toString"));

    private static MethodHandler mockHandler = (Object self, Method method, Method proceed, Object[] args) -> {
        Invocation invocation = new Invocation(self.getClass().toString(), method, args);
        if (toVerify) {
            if (verificationDetail != null) {
                switch (verificationDetail.detailType) {
                    case NEVER:
                        if (invocations.containsKey(invocation))
                            throw new AssertionError();
                        break;
                    case TIMES:
                        int times = (int) verificationDetail.getDetail();
                        if (!invocations.containsKey(invocation) || invocations.get(invocation) != times)
                            throw new AssertionError();
                        break;
                    case ATLEAST:
                        int atLeast = (int) verificationDetail.getDetail();
                        if (!invocations.containsKey(invocation) || invocations.get(invocation) < atLeast)
                            throw new AssertionError();
                        break;
                    case ATMOST:
                        int atMost = (int) verificationDetail.getDetail();
                        if (!invocations.containsKey(invocation) || invocations.get(invocation) > atMost)
                            throw new AssertionError();
                        break;
                }
            } else if (!invocations.containsKey(invocation)) {
                throw new AssertionError();
            }
            toVerify = false;
            verificationDetail = null;
        } else {
            if (invocations.containsKey(invocation)) {
                invocations.replace(invocation, invocations.get(invocation) + 1);
            } else {
                invocations.put(invocation, 1);
            }
            System.out.println(invocation);
        }
        Class returnType = method.getReturnType();
        if (returnType.equals(int.class) || returnType.equals(float.class) || returnType.equals(double.class) || returnType.equals(long.class)
                || returnType.equals(short.class) || returnType.equals(char.class) || returnType.equals(byte.class)) {
            return 0;
        } else if (returnType.equals(boolean.class)) {
            return false;
        } else if (!returnType.equals(void.class)) {
            return returnType.newInstance();
        }
        return null;
    };
    private static MethodHandler spyHandler = (Object self, Method method, Method proceed, Object[] args) -> {
        Invocation invocation = new Invocation(self.getClass().toString(), method, args);
        if (toVerify) {
            if (verificationDetail != null) {
                switch (verificationDetail.detailType) {
                    case NEVER:
                        if (invocations.containsKey(invocation))
                            throw new AssertionError();
                        break;
                    case TIMES:
                        int times = (int) verificationDetail.getDetail();
                        if (!invocations.containsKey(invocation) || invocations.get(invocation) != times)
                            throw new AssertionError();
                        break;
                    case ATLEAST:
                        int atLeast = (int) verificationDetail.getDetail();
                        if (!invocations.containsKey(invocation) || invocations.get(invocation) < atLeast)
                            throw new AssertionError();
                        break;
                    case ATMOST:
                        int atMost = (int) verificationDetail.getDetail();
                        if (!invocations.containsKey(invocation) || invocations.get(invocation) > atMost)
                            throw new AssertionError();
                        break;
                }
            } else if (!invocations.containsKey(invocation)) {
                throw new AssertionError();
            }
            toVerify = false;
            verificationDetail = null;
        } else {
            if (invocations.containsKey(invocation)) {
                invocations.replace(invocation, invocations.get(invocation) + 1);
            } else {
                invocations.put(invocation, 1);
            }
            System.out.println(invocation);
        }
        return proceed.invoke(self, args);
    };


    public static <T> T spy(T target) {
        try {
            ProxyFactory factory = new ProxyFactory();
            factory.setSuperclass(target.getClass());
            factory.setInterfaces(target.getClass().getInterfaces());
            factory.setHandler(spyHandler);
            factory.setFilter(filter);
            return (T) factory.createClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T mock(Class<T> clazz) {
        try {
            ProxyFactory factory = new ProxyFactory();
            factory.setSuperclass(clazz);
            factory.setInterfaces(clazz.getInterfaces());
            factory.setHandler(mockHandler);
            factory.setFilter(filter);
            return (T) factory.createClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T verify(T mockObject) {
        if (mockObject == null)
            throw new AssertionError();

        toVerify = true;
        return mockObject;
    }

    public static <T> T verify(T mockObject, VerificationDetail detail) {
        verificationDetail = detail;
        return verify(mockObject);
    }

    public static VerificationDetail times(int number) {

        return VerificationDetail.newInstance(number, VerificationDetail.VerificationDetailType.TIMES);
    }

    public static VerificationDetail never() {
        return VerificationDetail.newInstance(null, VerificationDetail.VerificationDetailType.NEVER);
    }

    public static VerificationDetail atLeast(int number) {
        return VerificationDetail.newInstance(number, VerificationDetail.VerificationDetailType.ATLEAST);
    }

    public static VerificationDetail atMost(int number) {
        return VerificationDetail.newInstance(number, VerificationDetail.VerificationDetailType.ATMOST);
    }

}
