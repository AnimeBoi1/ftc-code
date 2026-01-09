package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

@TeleOp(name = "Chapter 11_1", group = "Exercises")
public class Chapter11_1 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard(); // create programming board instance

    @Override
    public void init() {
        board.init(hardwareMap); // initialize hardware
        telemetry.addData("Status", "Initialized"); // show status
    }

    @Override
    public void loop() {
        double headingDegrees = board.getHeading(AngleUnit.DEGREES); // get heading in degrees
        double headingRadians = board.getHeading(AngleUnit.RADIANS); // get heading in radians

        telemetry.addData("Heading (degrees)", headingDegrees); // show degrees
        telemetry.addData("Heading (radians)", headingRadians); // show radians
    }
}
