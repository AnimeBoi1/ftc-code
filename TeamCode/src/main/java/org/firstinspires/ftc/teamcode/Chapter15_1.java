package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

@TeleOp(name = "Chapter 15_1", group = "Exercises")
public class Chapter15_1 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard(); // create programming board instance
    boolean wasPressed = false; // tracks previous touch sensor state

    @Override
    public void init() {
        board.init(hardwareMap); // initialize hardware
        telemetry.addData("Status", "Initialized");
        telemetry.addLine("Press touch sensor to rumble!");
    }

    @Override
    public void loop() {
        boolean isPressed = board.isTouchSensorPressed(); // get current state

        // rumble only on rising edge (first press)
        if (isPressed && !wasPressed) {
            gamepad1.rumble(500); // rumble for 500ms
            telemetry.addLine("RUMBLE!");
        }

        wasPressed = isPressed; // remember state for next loop

        telemetry.addData("Touch Sensor", isPressed ? "PRESSED" : "Released");
    }
}
