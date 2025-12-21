package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Chapter 4_2")
public class Chapter4_2 extends OpMode {

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
    }

    @Override
    public void loop() {
        double ySpeed = gamepad1.left_stick_y;
        double xSpeed = gamepad1.left_stick_x;

        if (gamepad1.a) { // crazy mode: swap axes
            double tmp = ySpeed;
            ySpeed = xSpeed;
            xSpeed = tmp;
        }

        telemetry.addData("X Speed", xSpeed);
        telemetry.addData("Y Speed", ySpeed);
        telemetry.update();
    }
}