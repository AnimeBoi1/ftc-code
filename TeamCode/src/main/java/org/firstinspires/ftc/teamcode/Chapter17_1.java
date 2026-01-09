package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Chapter 17_1", group = "Exercises")
public class Chapter17_1 extends OpMode {

    @Override
    public void init() {
        // documentation exercise - add Javadoc to ProgrammingBoard
        telemetry.addData("Exercise 17.1", "Add Javadoc");
        telemetry.addLine("Format: /** Description */");
        telemetry.addLine("Tags: @param, @return");
    }

    @Override
    public void loop() {
        // generate docs with: ./gradlew javadoc
        telemetry.addLine("Generate docs: ./gradlew javadoc");
    }
}
