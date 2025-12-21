package org.firstinspires.ftc.teamcode;

@SuppressWarnings("unused")
public class Chapter10Exercises {
    // Chapter 10: 6 exercise stubs

    public static double ex1() {
        // compute average
        int[] a = {2,4,6}; // a
        int s = 0; // s
        for (int v : a) s += v; // sum
        return (double) s / a.length; // average
    }

    public static int ex2() {
        // find max
        int[] a = {3,7,1}; // a
        int m = a[0]; // m
        for (int v : a) if (v > m) m = v; // update
        return m; // return m
    }

    public static int ex3() {
        // count negatives
        int[] a = {-1,2,-3,4}; // a
        int cnt = 0; // cnt
        for (int v : a) if (v < 0) cnt++; // count
        return cnt; // return cnt
    }

    public static String ex4() {
        // join
        String[] parts = {"a","b","c"}; // parts
        StringBuilder sb = new StringBuilder(); // sb
        for (String p : parts) { if (sb.length()>0) sb.append(','); sb.append(p); } // join
        return sb.toString(); // return
    }

    public static boolean ex5() {
        // check palindrome
        String s = "radar"; // s
        return new StringBuilder(s).reverse().toString().equals(s); // palindrome
    }

    public static int ex6() {
        // combine
        return ex2() + ex3(); // combine
    }
}

