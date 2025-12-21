package org.firstinspires.ftc.teamcode;

@SuppressWarnings("unused")
public class Chapter6Exercises {
    // Chapter 6: 6 exercise stubs

    public static int ex1() {
        // bitwise example
        int a = 5; // a
        return a << 1; // shift left
    }

    public static int ex2() {
        // bitwise and
        return (6 & 3); // 6 & 3
    }

    public static int ex3() {
        // negate
        int x = 10; // x
        return -x; // return negation
    }

    public static int ex4() {
        // successive doubling
        int v = 1; // v
        for (int i = 0; i < 3; i++) { // 3 times
            v *= 2; // double
        }
        return v; // return v
    }

    public static boolean ex5() {
        // compare
        return 100 > 50; // true
    }

    public static int ex6() {
        // combine calls
        return ex1() + ex2(); // combine
    }
}

