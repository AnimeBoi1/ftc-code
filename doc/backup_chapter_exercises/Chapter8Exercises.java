package org.firstinspires.ftc.teamcode;

@SuppressWarnings("unused")
public class Chapter8Exercises {
    // Chapter 8: 6 exercise stubs

    public static int ex1() {
        // array create
        int[] a = new int[3]; // a
        a[0] = 1; // set
        a[1] = 2; // set
        a[2] = 3; // set
        return a[2]; // return last
    }

    public static int ex2() {
        // for-each sum
        int[] arr = {2, 4, 6}; // arr
        int s = 0; // s
        for (int v : arr) { // iterate
            s += v; // add
        }
        return s; // return s
    }

    public static int ex3() {
        // copy array
        int[] src = {1, 2}; // src
        int[] dst = new int[src.length]; // dst
        System.arraycopy(src, 0, dst, 0, src.length); // copy
        return dst[0]; // return first
    }

    public static boolean ex4() {
        // contains
        int[] arr = {1, 3, 5}; // arr
        int t = 3; // t
        for (int x : arr) { if (x == t) return true; } // find
        return false; // not found
    }

    public static int ex5() {
        // length
        int[] arr = {9,9,9}; // arr
        return arr.length; // return length
    }

    public static int ex6() {
        // combine
        return ex1() + ex2(); // combine
    }
}
