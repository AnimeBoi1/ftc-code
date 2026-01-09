package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

/**
 * Chapter 7 Exercise 2:
 * Make the joystick less sensitive in the middle without losing range
 * by using the squareInputWithSign() method.
 *
 * The idea: square the input value but keep the sign.
 * This makes small values even smaller (better fine control)
 * while still allowing full power at the extremes.
 */
@TeleOp(name = "Chapter 7_2", group = "Exercises")
public class Chapter7_2 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard();

    @Override
    public void init() {
        board.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loop() {
        double rawInput = gamepad1.left_stick_y;
        double adjustedInput = squareInputWithSign(rawInput);

        board.setMotorSpeed(adjustedInput);

        telemetry.addData("Raw Input", rawInput);
        telemetry.addData("Adjusted Input", adjustedInput);
        telemetry.addData("Motor Rotations", board.getMotorRotations());
    }

    /**
     * TODO: Implement this method
     * Squares the input value while preserving its sign.
     * Example: 0.5 -> 0.25, -0.5 -> -0.25, 1.0 -> 1.0, -1.0 -> -1.0
     */
    private double squareInputWithSign(double input) {
        // TODO: Implement this
        return input; // Replace with correct implementation
    }
}