package com.othr.ajp.lambdasstreams;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<String> cities = Arrays.asList("Regensburg", "Basel", "Munich", "Bonn", "Hamburg", "Munich", "Berlin");
        // use the cities list and implement the following use cases using only streams and lambdas

        // print distinct list of cities on console
//        cities.stream().distinct().forEach(System.out::println);

        // print first 3 cities in list
//        cities.stream().limit(3).forEach(System.out::println);

        // store in boolean variable whether city names have all at least 6 characters
//        System.out.println("All names have length of at least 6 chars: " + cities.stream().noneMatch(s -> s.length() < 6));

        // store list of distinct city names in descending order of name's length (and pring to check):
//        cities.stream().distinct().sorted(Comparator.comparingInt(String::length).reversed()).forEach(System.out::println);
        // or
//        cities.stream().distinct().sorted((s1, s2) -> s2.length()-s1.length()).forEach(System.out::println);

        // store set of distinct city names in CAPITAL LETTERS in new TreeSet (and print to check):
//        cities.stream().map(String::toUpperCase).collect(Collectors.toCollection(TreeSet::new)).forEach(System.out::println);

        // find first city name in natural order of list of given length len and - if present - store name in String variable or store string "no city of length ..." (use terminal operation that returns Optional<T> object and continue using this object):
//        final int len = 11;
//        cities.stream().filter(s -> s.length() == len).findFirst().ifPresentOrElse(System.out::println, () -> System.out.println("no city name of length " + len));

        // print name of city with longest name (one if there are more)
//        cities.stream().max(Comparator.comparingInt(String::length)).ifPresent(System.out::println);

        // store length of longest (or shortest) city name (and print variable to check)
//        AtomicInteger len = new AtomicInteger();
//        cities.stream().max(Comparator.comparingInt(String::length)).ifPresent(s -> len.set(s.length()));
        // cities.stream().min(Comparator.comparingInt(String::length)).ifPresent(s -> len.set(s.length()));
//        System.out.println("length of longest name: " + len.get());
        // System.out.println("length of shortest name: " + len.get());

        // reduce list of names to String of their initials
//        System.out.print("Initials: ");
//        cities.stream().map(s -> s.charAt(0)).forEach(System.out::print);
//        System.out.println();

        // compute total sum of string length over all names (and print to check)
//        cities.stream().map(String::length).reduce(Integer::sum).ifPresent(s -> System.out.println("total string length over all names: " + s));

        // store a Map<Character,Long> with number of cities grouped by their initials (and print to check)
//        Map<Character, Long> result = cities.stream().map(s -> s.toUpperCase().charAt(0)).distinct()
//                .collect(Collectors.toMap(Character::charValue, c -> cities.stream().filter(s -> s.toUpperCase().charAt(0) == c).count()));
//        result.forEach((k, v) -> System.out.println(k + ": " + v));

        //as above but do not store but print directly to console
//        cities.stream().map(s -> s.toUpperCase().charAt(0)).distinct()
//                .collect(Collectors.toMap(Character::charValue, c -> cities.stream().filter(s -> s.toUpperCase().charAt(0) == c).count()))
//                .forEach((k, v) -> System.out.println(k + ": " + v));

        // as above but print map sorted by value
//        Map<Character, Long> result = cities.stream().map(s -> s.toUpperCase().charAt(0)).distinct()
//                .collect(Collectors.toMap(Character::charValue,
//                        c -> cities.stream().filter(s -> s.toUpperCase().charAt(0) == c).count()));
//        result = result.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByValue())
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
//        result.forEach((k, v) -> System.out.println(k + ": " + v));

        // count number of letters in city names and print table to console sorted by key:
//        Map<Character, Long> result =
//                cities.stream().map(s -> s.chars().mapToObj(c -> (char) c).toArray(Character[]::new)).flatMap(Arrays::stream)
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        result.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
