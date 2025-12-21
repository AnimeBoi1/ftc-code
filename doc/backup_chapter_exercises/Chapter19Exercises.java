package org.firstinspires.ftc.teamcode;

@SuppressWarnings("unused")
public class Chapter19Exercises {
    // Chapter 19: 6 exercise stubs

    public static int ex1() {
        // concurrency placeholder
        Thread t = new Thread(() -> {}); // thread
        t.run(); // run inline
        return 0; // return
    }

    public static int ex2() {
        // atomic placeholder
        return Integer.valueOf(1); // boxed
    }

    public static int ex3() {
        // lock placeholder
        Object lock = new Object(); synchronized(lock) { return 1; } // sync
    }

    public static int ex4() {
        // future placeholder
        return 2; // placeholder
    }

    public static int ex5() {
        // combine
        return ex1() + ex2(); // combine
    }

    public static int ex6() {
        // combine
        return ex3(); // return
    }
}
