package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

/**
 * Chapter 8 Exercise 1:
 * Change the ProgrammingBoard class so that the servo is backwards
 * and only goes from the midpoint to far left.
 *
 * Hints:
 * - Use servo.setDirection(Servo.Direction.REVERSE) to reverse it
 * - Use servo.scaleRange(min, max) to limit the range
 * - For midpoint to far left reversed: scaleRange(0.5, 1.0)
 *
 * Modify ProgrammingBoard.init() to add these settings for the servo
 */
@TeleOp(name = "Chapter 8_1", group = "Exercises")
@Disabled
public class Chapter8_1 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard();

    @Override
    public void init() {
        board.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loop() {
        if (gamepad1.a) {
            board.setServoPosition(1.0);
        } else if (gamepad1.b) {
            board.setServoPosition(0.0);
        } else {
            board.setServoPosition(0.5);
        }

        telemetry.addData("Press A", "for position 1.0");
        telemetry.addData("Press B", "for position 0.0");
        telemetry.addData("Release", "for position 0.5");
    }
}