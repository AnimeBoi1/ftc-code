package org.firstinspires.ftc.teamcode;

@SuppressWarnings("unused")
public class Chapter4Exercises {
    // Chapter 4: 6 exercise stubs

    public static int ex1() {
        // initialize
        int a = 0; // a = 0
        a += 10; // a = a + 10
        return a; // return a
    }

    public static int ex2() {
        // max of two
        int x = 4; // x
        int y = 9; // y
        return Math.max(x, y); // return max
    }

    public static int ex3() {
        // min of two
        int x = 4; // x
        int y = 9; // y
        return Math.min(x, y); // return min
    }

    public static int ex4() {
        // sum of odds
        int sum = 0; // sum
        for (int i = 1; i <= 5; i += 2) { // i odd
            sum += i; // add
        }
        return sum; // return sum
    }

    public static boolean ex5() {
        // check positive
        int n = -3; // n
        return n > 0; // true if positive
    }

    public static int ex6() {
        // use Math.pow
        return (int) Math.pow(2, 5); // 2^5
    }
}

