package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Chapter 2_1")
public class Chapter2_1 extends OpMode {

    @Override
    public void init() {
        String myName = "Mayank";
        telemetry.addData("Hello", myName);
        telemetry.update();
    }

    @Override
    public void loop() {
        // exercise loop code
    }
}