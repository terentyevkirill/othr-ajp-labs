package com.othr.ajp.annotations;


import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static com.othr.ajp.annotations.Criticality.*;

@Review(reviewers = {"John Doe", "Max Mustermann"}, criticality = SEVERE)
public class SampleAnnotatedClass {

    @PublishOnline("http://othr.de/ajp/services/testresult")
    public double getTestResultByStudentId(String studentId) {
        return 0.0;
    }

    @PublishOnline
    public String getHelpText() {
        return "helping text";
    }

    // read annotations by reflection
    public static void main(String[] args) {
        Class<?> clazz = SampleAnnotatedClass.class;
        System.out.println(clazz.getCanonicalName());
        System.out.println("Annotations on class:");
        printAnnotations(clazz.getAnnotations());
        System.out.println("Annotations on methods:");
        for (Method m : clazz.getDeclaredMethods()) {
            if (m.getAnnotations().length > 0) {
                System.out.println(m.getName());
                printAnnotations(m.getAnnotations());
            }
        }


    }


    private static void printAnnotations(Annotation[] annotations) {
        for (Annotation a : annotations) {
            Class<?> annotationClass = a.annotationType();
            System.out.print("@" + annotationClass.getSimpleName());
            if (annotationClass.getDeclaredMethods().length > 0) {
                System.out.println("(");
                for (Method m : annotationClass.getDeclaredMethods()) {
                    try {
                        System.out.print("\t" + m.getName());
                        Object elementValue = m.invoke(a);
                        if (elementValue.getClass().getName().startsWith("[L")) {
                            elementValue = Arrays.toString((Object[]) elementValue);
                        }
                        System.out.println(" = " + elementValue);
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                        System.err.println("Error getting " + m.getName());
                    }
                }
                System.out.println(")");
            }

        }
    }
}
