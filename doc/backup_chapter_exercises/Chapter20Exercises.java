package org.firstinspires.ftc.teamcode;

@SuppressWarnings("unused")
public class Chapter20Exercises {
    // Chapter 20: 6 exercise stubs

    public static int ex1() {
        // UI placeholder
        String title = "App"; return title.length(); // return
    }

    public static int ex2() {
        // event placeholder
        boolean clicked = false; return clicked ? 1 : 0; // ternary
    }

    public static int ex3() {
        // lifecycle placeholder
        return 0; // placeholder
    }
package org.firstinspires.ftc.teamcode;
    public static int ex4() {
        // resource placeholder
        String r = "res"; return r.length(); // length
    }

    public static int ex5() {
        // combine
        return ex1() + ex2(); // combine
    }

    public static int ex6() {
        return ex4(); // return
    }
}

@SuppressWarnings("unused")
public class Chapter13Exercises {
    // Chapter 13: 6 exercise stubs

    public static int ex1() {
        // simple object usage
        Object o = "text"; // o
        return o.toString().length(); // length
    }

    public static int ex2() {
        // instanceof
        Object o = 5; // o
        return (o instanceof Integer) ? 1 : 0; // return
    }

    public static String ex3() {
        // toString
        Integer n = 10; // n
        return n.toString(); // return
    }

    public static int ex4() {
        // hashcode
        String s = "abc"; // s
        return s.hashCode(); // hash
    }

    public static int ex5() {
        // equals
        return ("a".equals("a")) ? 1 : 0; // equals
    }

    public static int ex6() {
        // combine
        return ex1() + ex2(); // combine
    }
}

