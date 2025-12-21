package org.firstinspires.ftc.teamcode;

@SuppressWarnings("unused")
public class Chapter2Exercises {
    // Chapter 2: 6 exercise stubs

    public static int ex1() {
        // initialize
        int a = 2; // a = 2
        // add
        int b = 3; // b = 3
        int res = a + b; // res = a + b
        return res; // return res
    }

    public static int ex2() {
        // difference
        int x = 10; // x = 10
        int y = 4; // y = 4
        int diff = x - y; // diff = x - y
        return diff; // return diff
    }

    public static int ex3() {
        // power example
        int n = 3; // n = 3
        int cube = n * n * n; // cube = n^3
        return cube; // return cube
    }

    public static int ex4() {
        // loop product
        int p = 1; // p = 1
        for (int i = 1; i <= 4; i++) { // i 1..4
            p *= i; // multiply
        }
        return p; // return p
    }

    public static boolean ex5() {
        // parity check
        int v = 8; // v = 8
        return v % 2 == 0; // return true if even
    }

    public static int ex6() {
        // combine results
        return ex1() + ex3(); // return sum of ex1 and ex3
    }
}

