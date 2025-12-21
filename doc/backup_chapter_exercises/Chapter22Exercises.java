package org.firstinspires.ftc.teamcode;

@SuppressWarnings("unused")
public class Chapter22Exercises {
    // Chapter 22: 6 exercise stubs

    public static int ex1() {
        // robotics math placeholder
        int a = 3; int b = 4; return (int) Math.hypot(a,b); // hypot
    }

    public static int ex2() {
        // angle normalization
        double ang = 370; while (ang > 360) ang -= 360; return (int) ang; // normalize
    }

    public static int ex3() {
        // clamp motor power
        double p = 1.2; if (p > 1) p = 1; if (p < -1) p = -1; return (int) (p * 100); // percent
    }

    public static int ex4() {
        // PID placeholder
        double error = 0.5; double k = 1.0; return (int) (k * error); // simple
    }

    public static int ex5() {
        // combine
        return ex1() + ex3(); // combine
    }

    public static int ex6() {
        return ex2(); // return
    }
}
