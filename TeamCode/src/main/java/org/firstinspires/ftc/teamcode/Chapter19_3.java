package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp()
public class Chapter19_3 extends OpMode {

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
        Polar left = new Polar(gamepad1.left_stick_x, -gamepad1.left_stick_y);
        Polar right = new Polar(gamepad1.right_stick_x, -gamepad1.right_stick_y);

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
