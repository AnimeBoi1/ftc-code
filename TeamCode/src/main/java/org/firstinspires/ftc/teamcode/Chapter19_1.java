package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Chapter 19_1", group = "Exercises")
public class Chapter19_1 extends OpMode {

    // polar coordinate class - converts (x,y) to (r, theta)
    static class Polar {
        double r; // radius (distance from origin)
        double theta; // angle from x-axis

        public Polar(double x, double y) {
            this.r = Math.hypot(x, y); // calculate radius
            this.theta = Math.atan2(y, x); // calculate angle
        }

        public double getR() { return r; }
        public double getThetaDegrees() { return Math.toDegrees(theta); }
    }

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        telemetry.addLine("Move joysticks to see polar coords");
    }

    @Override
    public void loop() {
        // convert joysticks to polar coordinates
        Polar leftStick = new Polar(gamepad1.left_stick_x, -gamepad1.left_stick_y);
        Polar rightStick = new Polar(gamepad1.right_stick_x, -gamepad1.right_stick_y);

        // display left joystick
        telemetry.addLine("=== Left Joystick ===");
        telemetry.addData("r (radius)", "%.2f", leftStick.getR());
        telemetry.addData("theta (deg)", "%.1f", leftStick.getThetaDegrees());

        // display right joystick
        telemetry.addLine("=== Right Joystick ===");
        telemetry.addData("r (radius)", "%.2f", rightStick.getR());
        telemetry.addData("theta (deg)", "%.1f", rightStick.getThetaDegrees());
    }
}
