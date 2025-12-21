package org.firstinspires.ftc.teamcode;

@SuppressWarnings("unused")
public class Chapter12Exercises {
    // Chapter 12: 6 exercise stubs

    public static int ex1() {
        // use double
        double x = 3.5; // x
        return (int) Math.floor(x); // floor
    }

    public static int ex2() {
        // rounding
        double x = 2.6; // x
        return (int) Math.round(x); // round
    }

    public static double ex3() {
        // trig
        return Math.sin(Math.PI/2); // sin 90
    }

    public static long ex4() {
        // pow and cast
        return (long) Math.pow(2, 10); // 2^10
    }

    public static boolean ex5() {
        // random determinism
        return Math.abs((int) (Math.random() * 10)) < 10; // always true
    }

    public static int ex6() {
        // combine
        return ex1() + ex2(); // combine
    }
}

