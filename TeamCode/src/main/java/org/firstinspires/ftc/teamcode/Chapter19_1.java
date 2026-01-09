package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Chapter 19 Exercise 1:
 * Use the Polar class to make a new OpMode that reports the joysticks on
 * the gamepad in polar coordinates - show the angle in degrees.
 *
 * Polar coordinates represent a point using:
 * - r (radius): distance from origin
 * - theta: angle from positive x-axis
 */
@TeleOp(name = "Chapter 19_1", group = "Exercises")
public class Chapter19_1 extends OpMode {

    /**
     * Simple Polar coordinate class.
     * Converts from Cartesian (x, y) to Polar (r, theta).
     */
    static class Polar {
        double r;
        double theta;

        public Polar(double x, double y) {
            this.r = Math.hypot(x, y);
            this.theta = Math.atan2(y, x);
        }

        public double getR() {
            return r;
        }

        public double getThetaRadians() {
            return theta;
        }

        public double getThetaDegrees() {
            return Math.toDegrees(theta);
        }
    }

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        telemetry.addLine("Move joysticks to see polar coordinates");
    }

    @Override
    public void loop() {
        // Left joystick
        Polar leftStick = new Polar(gamepad1.left_stick_x, -gamepad1.left_stick_y);

        // Right joystick
        Polar rightStick = new Polar(gamepad1.right_stick_x, -gamepad1.right_stick_y);

        telemetry.addLine("=== Left Joystick ===");
        telemetry.addData("Cartesian", "(%.2f, %.2f)",
                gamepad1.left_stick_x, -gamepad1.left_stick_y);
        telemetry.addData("r (radius)", "%.2f", leftStick.getR());
        telemetry.addData("theta (degrees)", "%.1f", leftStick.getThetaDegrees());

        telemetry.addLine("");
        telemetry.addLine("=== Right Joystick ===");
        telemetry.addData("Cartesian", "(%.2f, %.2f)",
                gamepad1.right_stick_x, -gamepad1.right_stick_y);
        telemetry.addData("r (radius)", "%.2f", rightStick.getR());
        telemetry.addData("theta (degrees)", "%.1f", rightStick.getThetaDegrees());
    }
}