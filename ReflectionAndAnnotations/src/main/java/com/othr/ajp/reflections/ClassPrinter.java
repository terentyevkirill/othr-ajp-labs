package com.othr.ajp.reflections;

import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.*;

public class ClassPrinter {
    private Class<?> clazz;

    public ClassPrinter(Class<?> clazz) {
        this.clazz = clazz;
    }

    public ClassPrinter(String canonicalName) throws ClassNotFoundException {
        this(Class.forName(canonicalName));
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // read class name from command line or use given String
        String className = "java.util.LinkedHashMap";
//        String className = "java.util.ArrayList";

        if (args.length > 0 && args[0].length() > 0) {
            className = args[0];
        }
        ClassPrinter classPrinter = new ClassPrinter(className);

        // print class name
        System.out.println("Information on " + getClassNameString(classPrinter.clazz, false));
        System.out.println();

        // print inheritance tree
        System.out.println("Inheritance tree:");
        StringBuilder indent = new StringBuilder();
        for (String s :
                classPrinter.getInheritanceTree()) {
            System.out.println(indent + s);
            indent.append("\t");
        }
        System.out.println();

        // print class definition
        StringBuilder sb = new StringBuilder();
        sb.append(getModifiersString(classPrinter.clazz.getModifiers(), classPrinter.clazz.getClass())).append(" ");
        sb.append(getClassNameString(classPrinter.clazz, false)).append(" ");
        sb.append("{\n\n");

        // print fields
        sb.append("\t// Fields\n");
        classPrinter.getFieldsStrings().forEach(s -> sb.append("\t").append(s).append("\n"));

        // print constructors
        sb.append("\n\t// Constructors\n");



        System.out.println(sb.toString());

    }

    private List<String> getFieldsStrings() {
        List<String> fieldsStrings = new ArrayList<>();
        Arrays.asList(this.clazz.getDeclaredFields()).forEach(field -> {
            StringBuilder sb = new StringBuilder();
            sb.append(getModifiersString(field.getModifiers(), Field.class)).append(" ");   // modifiers
            sb.append(field.getType().getSimpleName()).append(" ");     // type
            sb.append(field.getName());     // name
            // value (if present & accessible)
            if (Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers())) {
                sb.append(" = ");
                try {
                    field.setAccessible(true);
                    sb.append(field.get(null).toString());
                } catch (IllegalArgumentException | IllegalAccessException ex) {
                    sb.append("<ERROR READING>");
                }
            }
            sb.append(";");
            fieldsStrings.add(sb.toString());
        });
        return fieldsStrings;
    }

    private static String getModifiersString(int modifiers, Class<?> clazz) {
        String modString = Modifier.toString(modifiers);
        if (!Modifier.isInterface(modifiers) && clazz.equals(Class.class))
            modString += " class";

        return modString;
    }

    private static String getClassNameString(Class<?> clazz, boolean asCanonical) {
        StringBuilder sb = new StringBuilder();
        if (asCanonical) {
            sb.append(clazz.getCanonicalName());
        } else {
            sb.append(clazz.getSimpleName());
        }

        TypeVariable<?>[] typeVars = clazz.getTypeParameters();
        if (typeVars.length > 0) {
            sb.append("<");
            Arrays.asList(typeVars).forEach(t -> {
                sb.append(t.getTypeName());
                sb.append(",");
            });
            sb.deleteCharAt(sb.length() - 1);
            sb.append(">");
        }
        return sb.toString();
    }

    private Set<String> getInheritanceTree() {
        Set<String> inheritanceTree = new TreeSet<>();
        getInheritanceTreeRec(this.clazz, inheritanceTree);
        return inheritanceTree;
    }

    private void getInheritanceTreeRec(Class<?> clazz, Set<String> inheritanceTree) {
        if (clazz.getSuperclass() != null) {
            getInheritanceTreeRec(clazz.getSuperclass(), inheritanceTree);
        }
        inheritanceTree.add(getClassNameString(clazz, true));
    }
}
