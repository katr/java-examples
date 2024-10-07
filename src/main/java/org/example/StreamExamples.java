package org.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExamples {
    /**
     * Example of using map to multiply each element by 10
     */
    public static void mapExample1() {
        var list = List.of(2, 10, 15, 1, 9);
        System.out.println("-------- mapExample1 --------");
        list.stream()
                .map(i -> i * 10)
                .forEach(System.out::println);
    }

    public static void mapExample2() {
        var list = List.of(2, 10, 15, 1, 9);
        System.out.println("-------- mapExample2 --------");
        list.stream()
                .map(i -> String.format("The number is %d", i))
                .forEach(System.out::println);
    }

    public static void flatMapExample1() {
        var list = List.of(2, 10, 15, 1, 9);
        System.out.println("-------- flatMap 1 --------");
        list.stream()
                .flatMap(i -> Stream.of(i + 10, i + 20))
                .forEach(System.out::println);
    }

    public static void flatMapExample2() {
        var arr1 = new int[]{2, 12, 90};
        var arr2 = new int[]{13, 7, 1};
        System.out.println("-------- flatMap 2 plus min --------");
        Stream.of(arr1, arr2)
                .flatMapToInt(IntStream::of)
                .min()
                .ifPresent(i -> {
                    System.out.println("Min value: " + i);
                });
    }

    public static void flatMapExample3() {
        System.out.println("-------- flatMap 3 - squashing multiple lists of objects --------");

        class Person {
            String first;
            String last;

            public Person(String first, String last) {
                this.first = first;
                this.last = last;
            }

            public String getFirst() {
                return first;
            }
        }

        var boringCharacters = new Person[] {new Person("Jane", "Doe"), new Person("John", "Doe")};
        var cartoonCharacters = new Person[] {new Person("Scooby", "Doo"), new Person("Johnny", "Quest")};
        var superHeroes = new Person[] {new Person("Bruce", "Wayne"), new Person("Peter", "Parker"), new Person("Clark", "Kent")};

        Stream.of(boringCharacters, cartoonCharacters, superHeroes)
                .flatMap(Stream::of)
                .map(p -> p.getFirst())
                .sorted()
                .forEach(System.out::println);
    }

    public static void runExamples() {
        System.out.println("------------------ Streams example beginning ------------------");

        mapExample1();
        mapExample2();
        flatMapExample1();
        flatMapExample2();
        flatMapExample3();

        System.out.println("------------------ Streams example ending ------------------");
    }
}
