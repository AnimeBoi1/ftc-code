package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp()
public class Chapter19_2 extends OpMode {
    final double MAX_SPEED = 1.0;
    double currentSpeed = 0.5;

    @Override
    public void init() {
    }

    @Override
    public void loop() {
        currentSpeed = gamepad1.left_stick_y;

        telemetry.addData("MAX_SPEED (final)", MAX_SPEED);
        telemetry.addData("currentSpeed", "%.2f", currentSpeed);
    }

    public void exampleMethod(final double value) {
        double result = value * 2;
    }
}
