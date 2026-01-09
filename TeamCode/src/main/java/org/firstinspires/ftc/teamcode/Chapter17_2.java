package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Chapter 17_2", group = "Exercises")
public class Chapter17_2 extends OpMode {

    @Override
    public void init() {
        // documentation exercise - add Javadoc to TestMotor
        telemetry.addData("Exercise 17.2", "Add Javadoc to TestMotor");
        telemetry.addLine("Include: class description, @author");
        telemetry.addLine("Include: @see, @param for all params");
    }

    @Override
    public void loop() {
        // well-documented code helps judges understand your work
        telemetry.addLine("Good docs impress judges!");
    }
}
