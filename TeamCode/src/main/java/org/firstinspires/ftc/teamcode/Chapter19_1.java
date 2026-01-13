package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode

@TeleOp() // marks this class as a TeleOp program visible on the Driver Station
public class Chapter19_1 extends OpMode { // defines our class extending OpMode for iterative execution

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
        Polar leftStick = new Polar(gamepad1.left_stick_x, -gamepad1.left_stick_y); // converts left joystick to polar (negated Y for standard orientation)
        Polar rightStick = new Polar(gamepad1.right_stick_x, -gamepad1.right_stick_y); // converts right joystick to polar (negated Y for standard orientation)

        telemetry.addLine("=== Left Joystick ==="); // displays section header for left joystick
        telemetry.addData("r (radius)", "%.2f", leftStick.getR()); // displays left stick radius with 2 decimal places
        telemetry.addData("theta (deg)", "%.1f", leftStick.getThetaDegrees()); // displays left stick angle in degrees

        telemetry.addLine("=== Right Joystick ==="); // displays section header for right joystick
        telemetry.addData("r (radius)", "%.2f", rightStick.getR()); // displays right stick radius with 2 decimal places
        telemetry.addData("theta (deg)", "%.1f", rightStick.getThetaDegrees()); // displays right stick angle in degrees
    }
}
