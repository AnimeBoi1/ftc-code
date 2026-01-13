package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode

@TeleOp() // marks this class as a TeleOp program visible on the Driver Station
public class Chapter19_3 extends OpMode { // defines our class extending OpMode for iterative execution

    static class Polar { // nested static class to represent polar coordinates
        double r; // radius (distance from origin)
        double theta; // angle in radians

        public Polar(double x, double y) { // constructor takes Cartesian coordinates
            this.r = Math.hypot(x, y); // calculates radius using Pythagorean theorem
            this.theta = Math.atan2(y, x); // calculates angle using arctangent
        }

        public double getR() { return r; } // getter for radius
        public double getThetaDegrees() { return Math.toDegrees(theta); } // getter for angle converted to degrees
    }

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station (empty here)
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        Polar left = new Polar(gamepad1.left_stick_x, -gamepad1.left_stick_y); // converts left joystick to polar coordinates
        Polar right = new Polar(gamepad1.right_stick_x, -gamepad1.right_stick_y); // converts right joystick to polar coordinates

        telemetry.addLine("=== Left Joystick ==="); // displays section header for left joystick
        telemetry.addData("Cartesian", "(%+.0f, %+.0f)", // displays Cartesian coordinates
                gamepad1.left_stick_x * 100, -gamepad1.left_stick_y * 100); // scaled by 100 for readability
        telemetry.addData("r", "%+.0f", left.getR() * 100); // displays radius scaled by 100
        telemetry.addData("theta", "%+.0f deg", left.getThetaDegrees()); // displays angle in degrees

        telemetry.addLine("=== Right Joystick ==="); // displays section header for right joystick
        telemetry.addData("Cartesian", "(%+.0f, %+.0f)", // displays Cartesian coordinates
                gamepad1.right_stick_x * 100, -gamepad1.right_stick_y * 100); // scaled by 100 for readability
        telemetry.addData("r", "%+.0f", right.getR() * 100); // displays radius scaled by 100
        telemetry.addData("theta", "%+.0f deg", right.getThetaDegrees()); // displays angle in degrees
    }
}
