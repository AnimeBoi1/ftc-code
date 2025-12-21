package org.firstinspires.ftc.teamcode;

@SuppressWarnings("unused")
public class Chapter11Exercises {
    // Chapter 11: 6 exercise stubs

    public static int ex1() {
        // map-like behavior using arrays
        String[] keys = {"a","b"}; // keys
        int[] vals = {1,2}; // vals
        for (int i = 0; i < keys.length; i++) if (keys[i].equals("b")) return vals[i]; // find
        return -1; // not found
    }

    public static int ex2() {
        // replace chars
        String s = "hello"; // s
        return s.replace('l','x').length(); // operation
    }

    public static int ex3() {
        // parse and sum numbers in string
        String s = "1,2,3"; // s
        String[] parts = s.split(","); // parts
        int sum = 0; for (String p : parts) sum += Integer.parseInt(p); // sum
        return sum; // return
    }

    public static int ex4() {
        // simple recursion
        return factorial(4); // factorial 4
    }

    private static int factorial(int n) { return (n <= 1) ? 1 : n * factorial(n - 1); }

    public static int ex5() {
        // exception handling example
        try { Integer.parseInt("oops"); } catch (NumberFormatException e) { return -1; } // catch
        return 0; // unreachable
    }

    public static int ex6() {
        // combine
        return ex3() + ex4(); // combine
    }
}

