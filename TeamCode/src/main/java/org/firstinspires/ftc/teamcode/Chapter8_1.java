package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

@TeleOp(name = "Chapter 8_1", group = "Exercises")
public class Chapter8_1 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard(); // create programming board instance

    @Override
    public void init() {
        board.init(hardwareMap); // initialize hardware
        telemetry.addData("Status", "Initialized"); // show status
    }

    @Override
    public void loop() {
        // set servo position based on button press
        if (gamepad1.a) {
            board.setServoPosition(1.0); // move to max position
        } else if (gamepad1.b) {
            board.setServoPosition(0.0); // move to min position
        } else {
            board.setServoPosition(0.5); // move to middle position
        }

        telemetry.addData("Press A", "for position 1.0");
        telemetry.addData("Press B", "for position 0.0");
        telemetry.addData("Release", "for position 0.5");
    }
}
