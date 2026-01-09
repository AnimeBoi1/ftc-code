package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Chapter 14_3", group = "Exercises")
public class Chapter14_3 extends OpMode {

    @Override
    public void init() {
        // this is a refactoring exercise - no hardware needed
        telemetry.addData("Exercise 14.3", "Inheritance Refactoring");
        telemetry.addLine("Modify ProgrammingBoard classes to use inheritance");
    }

    @Override
    public void loop() {
        // display instructions for the exercise
        telemetry.addLine("Steps:");
        telemetry.addLine("1. Change 'private' to 'protected'");
        telemetry.addLine("2. Make each board extend the previous");
        telemetry.addLine("3. Call super.init(hwMap) in derived classes");
    }
}
