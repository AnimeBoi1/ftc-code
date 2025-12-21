package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

/**
 * Chapter 10 Exercise 1:
 * Add a method getAmountBlue() to the ProgrammingBoard and report it
 * back by changing this OpMode.
 *
 * Steps:
 * 1. Add getAmountBlue() method to ProgrammingBoard (similar to getAmountRed)
 * 2. Display it in telemetry below
 */
@TeleOp(name = "Chapter 10_1", group = "Exercises")
@Disabled
public class Chapter10_1 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard();

    @Override
    public void init() {
        board.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loop() {
        telemetry.addData("Red", board.getAmountRed());
        telemetry.addData("Green", board.getAmountGreen());
        // TODO: Add blue after implementing getAmountBlue()
        // telemetry.addData("Blue", board.getAmountBlue());
    }
}