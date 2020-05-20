package com.othr.ajp.lambdasstreams;

import java.util.*;
import java.util.function.Function;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class Main {

    public static void main(String[] args) {

        List<String> cities = Arrays.asList("Regensburg", "Basel", "Munich", "Bonn", "Hamburg", "Munich", "Berlin");
        // use the cities list and implement the following use cases using only streams and lambdas

        // print distinct list of cities on console
        System.out.println("print distinct list of cities on console:");
        cities.stream().distinct().forEach(System.out::println);
        System.out.println("----------------------------------------------------");

        // print first 3 cities in list
        System.out.println("print first 3 cities in list:");
        cities.stream().limit(3).forEach(System.out::println);
        System.out.println("----------------------------------------------------");

        // store in boolean variable whether city names have all at least 6 characters
        System.out.println("store in boolean variable whether city names have all at least 6 characters:");
        System.out.println("All names have length of at least 6 chars: "
                + cities.stream().noneMatch(s -> s.length() < 6));
        System.out.println("----------------------------------------------------");

        // store list of distinct city names in descending order of name's length (and print to check):
        System.out.println("store list of distinct city names in descending order of name's length (and print to check):");
        cities.stream().distinct().sorted(comparingInt(String::length).reversed()).forEach(System.out::println);
        System.out.println("----------------------------------------------------");

        // store set of distinct city names in CAPITAL LETTERS in new TreeSet (and print to check):
        System.out.println("store set of distinct city names in CAPITAL LETTERS in new TreeSet (and print to check):");
        cities.stream().map(String::toUpperCase).collect(toCollection(TreeSet::new)).forEach(System.out::println);
        System.out.println("----------------------------------------------------");

        // find first city name in natural order of list of given length len and - if present - store name in String variable or store string "no city of length ..." (use terminal operation that returns Optional<T> object and continue using this object):
        System.out.println("find first city name in natural order of list of given length len and - if present - store name in String variable or store string \"no city of length ...\" (use terminal operation that returns Optional<T> object and continue using this object):");
        final int len = 11;
        cities.stream().filter(s -> s.length() == len)
                .findFirst().ifPresentOrElse(System.out::println, () -> System.out.println("no city name of length " + len));
        System.out.println("----------------------------------------------------");

        // print name of city with longest name (one if there are more)
        System.out.println("print name of city with longest name (one if there are more):");
        cities.stream().max(comparingInt(String::length)).ifPresent(System.out::println);
        System.out.println("----------------------------------------------------");

        // store length of longest (or shortest) city name (and print variable to check)
        System.out.println("store length of longest (or shortest) city name (and print variable to check)");
        cities.stream().max(comparingInt(String::length))
                .ifPresent(s -> System.out.println("length of longest name: " + s.length()));
        // or
        cities.stream().min(comparingInt(String::length))
                .ifPresent(s -> System.out.println("length of shortest name: " + s.length()));
        System.out.println("----------------------------------------------------");

        // reduce list of names to String of their initials
        System.out.println("reduce list of names to String of their initials:");
        System.out.print("Initials: ");
        cities.stream().map(s -> s.charAt(0)).forEach(System.out::print);
        System.out.println();
        System.out.println("----------------------------------------------------");

        // compute total sum of string length over all names (and print to check)
        System.out.println("compute total sum of string length over all names (and print to check):");
        cities.stream().map(String::length).reduce(Integer::sum).ifPresent(s -> System.out.println("total string length over all names: " + s));
        System.out.println("----------------------------------------------------");

        // store a Map<Character,Long> with number of cities grouped by their initials (and print to check)
        System.out.println("store a Map<Character,Long> with number of cities grouped by their initials (and print to check):");
        Map<Character, Long> result = cities.stream()
                .map(s -> s.charAt(0))
                .collect(groupingBy(Function.identity(), counting()));
        result.entrySet().forEach(System.out::println);
        System.out.println("----------------------------------------------------");

        // as above but do not store but print directly to console
        System.out.println("as above but do not store but print directly to console:");
        cities.stream()
                .map(name -> name.charAt(0))
                .collect(groupingBy(Function.identity(), counting()))
                .entrySet()
                .forEach(System.out::println);
        System.out.println("----------------------------------------------------");

        // as above but print map sorted by value
        System.out.println("as above but print map sorted by value:");
        cities.stream()
                .map(name -> name.charAt(0))
                .collect(groupingBy(Function.identity(), counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
        System.out.println("----------------------------------------------------");

        // count number of letters in city names and print table to console sorted by key:
        System.out.println("count number of letters in city names and print table to console sorted by key:");
        cities.stream()
                .map(s -> s.chars().mapToObj(c -> (char) c).toArray(Character[]::new)).flatMap(Arrays::stream)
                .collect(groupingBy(Function.identity(), counting()))
                .entrySet()
                .forEach(System.out::println);
        System.out.println("----------------------------------------------------");
    }
}
