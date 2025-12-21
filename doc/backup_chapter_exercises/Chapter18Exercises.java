package org.firstinspires.ftc.teamcode;

@SuppressWarnings("unused")
public class Chapter18Exercises {
    // Chapter 18: 6 exercise stubs

    public static int ex1() {
        // networking placeholder (no network)
        String url = "http://example"; // url
        return url.length(); // length
    }

    public static int ex2() {
        // json-like placeholder
        String json = "{\"a\":1}"; // json
        return json.length(); // length
    }

    public static int ex3() {
        // encoding placeholder
        String s = "abc"; return s.getBytes().length; // bytes
    }

    public static int ex4() {
        // uri parse placeholder
        String s = "ftp://x"; return s.indexOf(":"); // index
    }

    public static int ex5() {
        // combine small ops
        return ex1() + ex2(); // combine
    }

    public static int ex6() {
        // combine
        return ex3() + ex4(); // combine
    }
}
