package org.firstinspires.ftc.teamcode;

@SuppressWarnings("unused")
public class Chapter5Exercises {
    // Chapter 5: 6 exercise stubs

    public static int ex1() {
        // fibonacci 0..2
        int a = 0; // a
        int b = 1; // b
        int c = a + b; // c = a + b
        return c; // return c
    }

    public static int ex2() {
        // absolute value
        int v = -12; // v
        return Math.abs(v); // return abs
    }

    public static int ex3() {
        // clamp
        int v = 15; // v
        int min = 0; // min
        int max = 10; // max
        if (v < min) v = min; // clamp low
        if (v > max) v = max; // clamp high
        return v; // return v
    }

    public static int ex4() {
        // simple array sum
        int[] arr = {1, 2, 3}; // arr
        int s = 0; // s
        for (int x : arr) { // iterate
            s += x; // add
        }
        return s; // return s
    }

    public static boolean ex5() {
        // search
        int[] arr = {4, 5, 6}; // arr
        int target = 5; // target
        for (int x : arr) { // iterate
            if (x == target) return true; // found
        }
        return false; // not found
    }

    public static int ex6() {
        // combine
        return ex4() + ex1(); // combine
    }
}

