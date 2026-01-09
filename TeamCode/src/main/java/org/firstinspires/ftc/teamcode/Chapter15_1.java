package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

/**
 * Chapter 15 Exercise 1:
 * Write a program that rumbles when the touch sensor is first pressed.
 * (Use one of the programming board files from earlier that has a touch sensor)
 *
 * This demonstrates gamepad rumble feedback based on sensor input.
 */
@TeleOp(name = "Chapter 15_1", group = "Exercises")
public class Chapter15_1 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard();
    boolean wasPressed = false;

    @Override
    public void init() {
        board.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        telemetry.addLine("Press the touch sensor to feel a rumble!");
    }

    @Override
    public void loop() {
        boolean isPressed = board.isTouchSensorPressed();

        // Rumble only when touch sensor is FIRST pressed (rising edge)
        if (isPressed && !wasPressed) {
            // Rumble gamepad1 for 500 milliseconds
            gamepad1.rumble(500);
            telemetry.addLine("RUMBLE!");
        }

        // Remember the previous state
        wasPressed = isPressed;

        // Display current state
        telemetry.addData("Touch Sensor", isPressed ? "PRESSED" : "Released");
        telemetry.addLine("Press touch sensor to rumble controller");
    }
}