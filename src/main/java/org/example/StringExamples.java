package org.example;

public class StringExamples {
    public static void runExamples() {
        System.out.println("------------------ String example beginning ------------------");

        System.out.println(String.format("The number formatted with commas is %,d", 1000000));
        System.out.println(String.format("The number formatted with leading zeros is %05d", 123));
        System.out.println(String.format("The string formatted with leading spaces is '%10s'", "hello"));
        System.out.println(String.format("The string formatted with leading spaces left justified is '%-10s'", "hello"));
        System.out.println(String.format("The float formatted with 3 digits to the right of the decimal is %.3f", 3.14159));

        System.out.println("------------------ String example ending ------------------");
    }
}
