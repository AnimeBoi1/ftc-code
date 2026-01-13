package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp()
public class Chapter19_1 extends OpMode {

    static class Polar {
        double r;
        double theta;

        public Polar(double x, double y) {
            this.r = Math.hypot(x, y);
            this.theta = Math.atan2(y, x);
        }

        public double getR() { return r; }
        public double getThetaDegrees() { return Math.toDegrees(theta); }
    }

    @Override
    public void init() {
    }

    @Override
    public void loop() {
        Polar leftStick = new Polar(gamepad1.left_stick_x, -gamepad1.left_stick_y);
        Polar rightStick = new Polar(gamepad1.right_stick_x, -gamepad1.right_stick_y);

        telemetry.addLine("=== Left Joystick ===");
        telemetry.addData("r (radius)", "%.2f", leftStick.getR());
        telemetry.addData("theta (deg)", "%.1f", leftStick.getThetaDegrees());

        telemetry.addLine("=== Right Joystick ===");
        telemetry.addData("r (radius)", "%.2f", rightStick.getR());
        telemetry.addData("theta (deg)", "%.1f", rightStick.getThetaDegrees());
    }
}
