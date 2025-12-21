package org.firstinspires.ftc.teamcode;

@SuppressWarnings("unused")
public class Chapter16Exercises {
    // Chapter 16: 6 exercise stubs

    public static int ex1() {
        // file placeholder (no IO)
        String name = "file.txt"; // name
        return name.length(); // length
    }

    public static int ex2() {
        // enum usage placeholder
        Day d = Day.MONDAY; // d
        return d.ordinal(); // ordinal
    }

    enum Day { MONDAY, TUESDAY };

    public static int ex3() {
        // time math
        long t = 1000L; // t
        return (int) (t / 1000); // seconds
    }

    public static int ex4() {
        // modulus
        return Math.floorMod(7, 3); // floorMod
    }

    public static boolean ex5() {
        // assert-like check (no assert)
        return (2 + 2 == 4); // true
    }

    public static int ex6() {
        // combine
        return ex1() + ex3(); // combine
    }
}
