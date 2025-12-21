package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

/**
 * Chapter 8 Exercise 2:
 * Change the OpMode so that how far you push gamepad1.left_trigger
 * determines the position of the servo.
 *
 * Hint: left_trigger returns a value from 0.0 to 1.0, which is
 * exactly what setServoPosition() expects!
 */
@TeleOp(name = "Chapter 8_2", group = "Exercises")
@Disabled
public class Chapter8_2 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard();

    @Override
    public void init() {
        board.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loop() {
        // TODO: Set servo position based on left_trigger value
        // board.setServoPosition( ??? );

        telemetry.addData("Left Trigger", gamepad1.left_trigger);
        telemetry.addData("Instructions", "Pull left trigger to move servo");
    }
}