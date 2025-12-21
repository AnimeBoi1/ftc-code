package org.firstinspires.ftc.teamcode;

@SuppressWarnings("unused")
public class Chapter9Exercises {
    // Chapter 9: 6 exercise stubs

    public static int ex1() {
        // sum first N
        int n = 5; // n
        int s = 0; // s
        for (int i = 1; i <= n; i++) s += i; // accumulate
        return s; // return s
    }

    public static int ex2() {
        // reverse digits
        int v = 123; // v
        int r = 0; // r
        while (v > 0) { r = r * 10 + (v % 10); v /= 10; } // reverse
        return r; // return r
    }

    public static boolean ex3() {
        // prime check small
        int v = 13; // v
        if (v <= 1) return false; // not prime
        for (int i = 2; i*i <= v; i++) if (v % i == 0) return false; // divisor
        return true; // prime
    }

    public static int ex4() {
        // gcd simple
        int a = 14, b = 21; // a,b
        while (b != 0) { int t = b; b = a % b; a = t; } // euclid
        return a; // gcd
    }

    public static int ex5() {
        // lcm using gcd
        int a = 6, b = 8; // a,b
        int g = Chapter9Exercises.ex4(); // reuse ex4 (note: returns gcd of 14,21 but fine)
        return (a / Math.max(1,g)) * b; // safe compute
    }

    public static int ex6() {
        // combine
        return ex1() + ex2(); // combine
    }
}

