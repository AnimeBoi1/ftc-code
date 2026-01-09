package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

@TeleOp(name = "Chapter 8_2", group = "Exercises")
public class Chapter8_2 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard(); // create programming board instance

    @Override
    public void init() {
        board.init(hardwareMap); // initialize hardware
        telemetry.addData("Status", "Initialized"); // show status
    }

    @Override
    public void loop() {
        // trigger value (0.0-1.0) directly controls servo position (0.0-1.0)
        board.setServoPosition(gamepad1.left_trigger);

        telemetry.addData("Left Trigger", gamepad1.left_trigger); // show trigger value
        telemetry.addData("Instructions", "Pull left trigger to move servo");
    }
}
