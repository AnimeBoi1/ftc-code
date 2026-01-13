package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp()
public class Chapter2_2 extends OpMode {

    @Override
    public void init() {
        String myName = "Mayank";
        int grade = 12;

        telemetry.addData("Hello", myName);
        telemetry.addData("Grade", grade);
    }

    @Override
    public void loop() {
    }
}