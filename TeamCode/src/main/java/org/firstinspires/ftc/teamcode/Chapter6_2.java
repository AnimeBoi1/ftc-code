package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

@TeleOp(name = "Chapter 6_2", group = "Exercises")
public class Chapter6_2 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard(); // create programming board instance

    @Override
    public void init() {
        board.init(hardwareMap); // initialize hardware
        telemetry.addData("Status", "Initialized"); // show status
    }

    @Override
    public void loop() {
        // display "Pressed" or "Not Pressed" instead of true/false
        if (board.isTouchSensorPressed()) {
            telemetry.addData("Touch Sensor", "Pressed");
        } else {
            telemetry.addData("Touch Sensor", "Not Pressed");
        }
    }
}