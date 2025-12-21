package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

/**
 * Chapter 11 Exercise 2:
 * Make the motor:
 * - stopped when heading is 0
 * - go negative when heading is negative
 * - go positive when heading is positive
 *
 * Hint: You can use the heading value directly as motor power,
 * but you'll need to scale it (divide by 180 or similar)
 */
@TeleOp(name = "Chapter 11_2", group = "Exercises")
@Disabled
public class Chapter11_2 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard();

    @Override
    public void init() {
        board.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loop() {
        double heading = board.getHeading(AngleUnit.DEGREES);

        // TODO: Set motor speed based on heading
        // Heading ranges from -180 to 180 degrees
        // Motor power should be -1.0 to 1.0
        // Consider: motorSpeed = heading / 180.0

        telemetry.addData("Heading", heading);
    }
}