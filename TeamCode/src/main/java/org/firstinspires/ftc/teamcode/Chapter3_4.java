package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp()
public class Chapter3_4 extends OpMode {

    @Override
    public void init() {
    }

    @Override
    public void loop() {
        telemetry.addData("sum triggers",
                gamepad1.left_trigger + gamepad1.right_trigger);
    }
}