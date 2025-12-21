package org.firstinspires.ftc.teamcode;

@SuppressWarnings("unused")
public class Chapter14Exercises {
    // Chapter 14: 6 exercise stubs

    public static int ex1() {
        // enum-like via constants
        final int RED = 1; // RED
        final int BLUE = 2; // BLUE
        return RED; // return
    }

    public static int ex2() {
        // switch example
        int v = 2; // v
        switch (v) { case 1: return 10; default: return 20; } // switch
    }

    public static int ex3() {
        // labeled continue not necessary
        int s = 0; for (int i = 0; i < 3; i++) { if (i==1) continue; s += i; } return s; // loop
    }

    public static boolean ex4() {
        // boolean ops
        return (true && !false); // result
    }

    public static int ex5() {
        // ternary
        int x = 5; return x > 3 ? x : 0; // return
    }

    public static int ex6() {
        // combine
        return ex1() + ex2(); // combine
    }
}
