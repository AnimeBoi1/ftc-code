package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp()
public class Chapter17_2 extends OpMode {

    @Override
    public void init() {
        telemetry.addData("Exercise 17.2", "Add Javadoc to TestMotor");
    }

    @Override
    public void loop() {
        telemetry.addLine("Good docs impress judges!");
    }
}
