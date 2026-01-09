package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Chapter 19_3", group = "Exercises")
public class Chapter19_3 extends OpMode {

    // polar coordinate class
    static class Polar {
        double r; // radius
        double theta; // angle

        public Polar(double x, double y) {
            this.r = Math.hypot(x, y);
            this.theta = Math.atan2(y, x);
        }

        public double getR() { return r; }
        public double getThetaDegrees() { return Math.toDegrees(theta); }
    }

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        telemetry.addLine("Format: %+.0f shows sign, no decimals");
    }

    @Override
    public void loop() {
        // convert joysticks to polar
        Polar left = new Polar(gamepad1.left_stick_x, -gamepad1.left_stick_y);
        Polar right = new Polar(gamepad1.right_stick_x, -gamepad1.right_stick_y);

        // display with sign and no decimals using %+.0f format
        telemetry.addLine("=== Left Joystick ===");
        telemetry.addData("Cartesian", "(%+.0f, %+.0f)",
                gamepad1.left_stick_x * 100, -gamepad1.left_stick_y * 100);
        telemetry.addData("r", "%+.0f", left.getR() * 100);
        telemetry.addData("theta", "%+.0f deg", left.getThetaDegrees());

        telemetry.addLine("=== Right Joystick ===");
        telemetry.addData("Cartesian", "(%+.0f, %+.0f)",
                gamepad1.right_stick_x * 100, -gamepad1.right_stick_y * 100);
        telemetry.addData("r", "%+.0f", right.getR() * 100);
        telemetry.addData("theta", "%+.0f deg", right.getThetaDegrees());
    }
}
