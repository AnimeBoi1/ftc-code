package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

/**
 * Chapter 11 Exercise 1:
 * Change the OpMode to show the heading in RADIANS as well as DEGREES.
 */
@TeleOp(name = "Chapter 11_1", group = "Exercises")
public class Chapter11_1 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard();

    @Override
    public void init() {
        board.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loop() {
        double headingDegrees = board.getHeading(AngleUnit.DEGREES);
        double headingRadians = board.getHeading(AngleUnit.RADIANS);

        telemetry.addData("Heading (degrees)", headingDegrees);
        telemetry.addData("Heading (radians)", headingRadians);
    }
}