package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp()
public class Chapter14_3 extends OpMode {

    @Override
    public void init() {
        telemetry.addData("Exercise 14.3", "Inheritance Refactoring");
    }

    @Override
    public void loop() {
        telemetry.addLine("Modify ProgrammingBoard classes to use inheritance");
    }
}
