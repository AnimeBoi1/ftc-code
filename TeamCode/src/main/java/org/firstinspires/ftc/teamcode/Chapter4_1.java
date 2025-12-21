package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Chapter 4_1")
public class Chapter4_1 extends OpMode {

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
    }

    @Override
    public void loop() {
        double fwdSpeed = gamepad1.left_stick_y;

        if (!gamepad1.a) {
            fwdSpeed *= 0.5;
        }

        telemetry.addData("Forward Speed", fwdSpeed);
        telemetry.update();
    }
}