        return A - B; // return A - B
    }

    public static int ex2() {
        // simple division
        int total = 20; // total
        int parts = 4; // parts
        return total / parts; // integer division
    }

    public static int ex3() {
        // modulo
        return 17 % 3; // return remainder
    }

    public static int ex4() {
        // conditional assignment
        int val = 9; // val
        int out = (val > 5) ? 1 : 0; // ternary
        return out; // return out
    }

    public static int ex5() {
        // accumulate
        int s = 0; // s = 0
        for (int i = 0; i < 5; i++) { // i 0..4
            s += i; // add i
        }
        return s; // return s
    }

    public static int ex6() {
        // nested calls
        return ex1() + ex2(); // combine
    }
}
package org.firstinspires.ftc.teamcode;

@SuppressWarnings("unused")
public class Chapter3Exercises {
    // Chapter 3: 6 exercise stubs

    public static int ex1() {
        // constants
        final int A = 7; // A = 7
        final int B = 5; // B = 5

