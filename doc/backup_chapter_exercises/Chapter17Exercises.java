package org.firstinspires.ftc.teamcode;

@SuppressWarnings("unused")
public class Chapter17Exercises {
    // Chapter 17: 6 exercise stubs

    public static int ex1() {
        // lambda-like simulated via Runnable
        Runnable r = () -> {};
        r.run(); // run
        return 0; // return
    }

    public static int ex2() {
        // stream-like via loop
        int[] a = {1,2,3}; int s=0; for (int v: a) s+=v; return s; // sum
    }

    public static int ex3() {
        // comparator placeholder
        String a = "a"; String b = "b"; return a.compareTo(b); // compare
    }

    public static int ex4() {
        // optional-like null check
        String s = null; return (s == null) ? -1 : s.length(); // check
    }

    public static int ex5() {
        // generic placeholder
        return genericIdentity(5); // generic call
    }

    private static <T> int genericIdentity(T t) { return t.toString().length(); }

    public static int ex6() {
        // combine
        return ex2() + ex3(); // combine
    }
}
