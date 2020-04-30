package com.othr.ajp.reflections;

import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.*;
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

        // class definition
        StringBuilder sb = new StringBuilder();
        sb.append(getModifiersString(classPrinter.clazz.getModifiers(), classPrinter.clazz.getClass())).append(" ");
        sb.append(getClassNameString(classPrinter.clazz, false)).append(" ");
        sb.append("{\n\n");

        // fields
        sb.append("\t// Fields\n");
        classPrinter.getFieldsStrings().forEach(s -> sb.append("\t").append(s).append("\n"));

        // constructors
        sb.append("\n\t// Constructors\n");
        classPrinter.getConstructorsStrings().forEach(s -> sb.append("\t").append(s).append("\n"));


        // methods
        sb.append("\n\t// Methods\n");
        classPrinter.getMethodsStrings().forEach(s -> sb.append("\t").append(s).append("\n"));


        sb.append("}\n");
        System.out.println(sb.toString());

    }

    private List<String> getConstructorsStrings() {
        return getExecutablesStrings(this.clazz.getDeclaredConstructors());
    }

    private List<String> getExecutablesStrings(Executable[] executables) {
        List<String> result = new ArrayList<>();
        for (Executable exe : executables) {
            StringBuilder sb = new StringBuilder();
            if (!exe.getDeclaringClass().equals(this.clazz))
                continue;
            sb.append(getModifiersString(exe.getModifiers(), Method.class)).append(" ");
            if (exe instanceof Method)
                sb.append(((Method) exe).getReturnType().getSimpleName()).append(" ");
            if (exe instanceof Constructor)
                sb.append(this.clazz.getSimpleName()).append("(");
            else sb.append(exe.getName()).append("(");

            if (exe.getParameterCount() > 0) {
                for (Parameter p : exe.getParameters()) {
                    sb.append(getSimpleTypeName(p.getParameterizedType().getTypeName())).append(" ");
                    sb.append(p.getName()).append(", ");
                }
                sb.delete(sb.length() - 2, sb.length());
            }
            sb.append(");");
            result.add(sb.toString());
        }
        return result;
    }

    private static String getSimpleTypeName(String extended) {
        String[] tokens = extended.split("\\.");
        if (tokens.length == 0)
            return extended;
        if (tokens.length == 1)
            return extended;
        return tokens[tokens.length - 1];
    }


    private List<String> getMethodsStrings() {
        return getExecutablesStrings(this.clazz.getDeclaredMethods());
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
