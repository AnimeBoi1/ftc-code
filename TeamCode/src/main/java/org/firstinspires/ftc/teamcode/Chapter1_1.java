package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Chapter 1_1")
public class Chapter1_1 extends OpMode {

    @Override
    public void init() {
        telemetry.addData("Hello", "Mayank");
        telemetry.update();
    }

    @Override
    public void loop() {
        // exercise loop code
    }
}
