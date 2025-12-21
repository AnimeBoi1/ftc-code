package org.firstinspires.ftc.teamcode;

@SuppressWarnings("unused")
public class Chapter15Exercises {
    // Chapter 15: 6 exercise stubs

    public static int ex1() {
        // simple class instantiation
        String s = new String("x"); // s
        return s.length(); // length
    }

    public static int ex2() {
        // arraylist-like via array
        int[] a = new int[2]; a[0]=1; a[1]=2; return a.length; // return length
    }

    public static int ex3() {
        // clone example
        int[] a = {1,2}; int[] b = a.clone(); return b[1]; // clone
    }

    public static int ex4() {
        // simple cast
        double d = 3.9; return (int) d; // cast
    }

    public static int ex5() {
        // synchronization not applicable here; simple return
        return 42; // answer
    }

    public static int ex6() {
        // combine
        return ex1() + ex4(); // combine
    }
}
