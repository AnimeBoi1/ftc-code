package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

/**
 * Chapter 6 Exercise 2:
 * Have your OpMode send "Pressed" and "Not Pressed" for the touch sensor
 * instead of true or false.
 *
 * Hint: Use an if/else statement to choose what string to display
 */
@TeleOp(name = "Chapter 6_2", group = "Exercises")
@Disabled
public class Chapter6_2 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard();

    @Override
    public void init() {
        board.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loop() {
        // TODO: Change this to display "Pressed" or "Not Pressed" instead of true/false
        telemetry.addData("Touch Sensor", board.isTouchSensorPressed());
    }
}