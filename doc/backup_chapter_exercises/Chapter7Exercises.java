package org.firstinspires.ftc.teamcode;

@SuppressWarnings("unused")
public class Chapter7Exercises {
    // Chapter 7: 6 exercise stubs

    public static int ex1() {
        // string length example
        String s = "abc"; // s
        return s.length(); // length
    }

    public static String ex2() {
        // string concatenate
        String a = "Hello"; // a
        String b = "World"; // b
        return a + " " + b; // concat
    }

    public static boolean ex3() {
        // startsWith
        String s = "robot"; // s
        return s.startsWith("ro"); // true if starts
    }

    public static int ex4() {
        // parse int
        String num = "42"; // num
        return Integer.parseInt(num); // parse
    }

    public static String ex5() {
        // substring
        String s = "exercise"; // s
        return s.substring(0, 4); // return sub
    }

    public static int ex6() {
        // combine string length and parse
        return ex1() + ex4(); // combine
    }
}

