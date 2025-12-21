package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

/**
 * Chapter 6 Exercise 1:
 * Add a method isTouchSensorReleased() to the ProgrammingBoard class
 * and use it in this OpMode.
 *
 * Steps:
 * 1. Open ProgrammingBoard.java in the mechanisms folder
 * 2. Add a new method isTouchSensorReleased() that returns true when NOT pressed
 * 3. Use it below in the loop() method
 */
@TeleOp(name = "Chapter 6_1", group = "Exercises")
@Disabled
public class Chapter6_1 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard();

    @Override
    public void init() {
        board.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loop() {
        telemetry.addData("Touch Pressed", board.isTouchSensorPressed());
        // TODO: Add telemetry for isTouchSensorReleased() after implementing it
        // telemetry.addData("Touch Released", board.isTouchSensorReleased());
    }
}