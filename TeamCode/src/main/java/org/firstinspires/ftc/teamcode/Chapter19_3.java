package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Chapter 19 Exercise 3:
 * Use formatting so the telemetry for exercise 1 always shows the positive
 * or negative sign and no decimals.
 *
 * Format specifiers:
 * %d - integer
 * %f - floating point
 * %.2f - floating point with 2 decimal places
 * %+d - integer with sign always shown
 * %+.0f - floating point with sign, no decimals
 *
 * Examples:
 * String.format("%+d", 5)   -> "+5"
 * String.format("%+d", -5)  -> "-5"
 * String.format("%+.0f", 3.7) -> "+4" (rounded)
 */
@TeleOp(name = "Chapter 19_3", group = "Exercises")
public class Chapter19_3 extends OpMode {

    /**
     * Polar coordinate class from Exercise 19.1
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

        public double getThetaDegrees() {
            return Math.toDegrees(theta);
        }
    }

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        telemetry.addLine("Move joysticks - values show +/- sign");
    }

    @Override
    public void loop() {
        // Left joystick
        Polar leftStick = new Polar(gamepad1.left_stick_x, -gamepad1.left_stick_y);

        // Right joystick
        Polar rightStick = new Polar(gamepad1.right_stick_x, -gamepad1.right_stick_y);

        telemetry.addLine("=== Left Joystick ===");
        // Using %+.0f for sign and no decimals
        telemetry.addData("Cartesian", "(%+.0f, %+.0f)",
                gamepad1.left_stick_x * 100, -gamepad1.left_stick_y * 100);
        telemetry.addData("r", "%+.0f", leftStick.getR() * 100);
        telemetry.addData("theta", "%+.0f deg", leftStick.getThetaDegrees());

        telemetry.addLine("");
        telemetry.addLine("=== Right Joystick ===");
        telemetry.addData("Cartesian", "(%+.0f, %+.0f)",
                gamepad1.right_stick_x * 100, -gamepad1.right_stick_y * 100);
        telemetry.addData("r", "%+.0f", rightStick.getR() * 100);
        telemetry.addData("theta", "%+.0f deg", rightStick.getThetaDegrees());

        telemetry.addLine("");
        telemetry.addLine("Values scaled by 100 for readability");
        telemetry.addLine("Format: %+.0f shows sign, no decimals");
    }
}