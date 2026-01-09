package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

@TeleOp(name = "Chapter 6_1", group = "Exercises")
public class Chapter6_1 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard(); // create programming board instance

    @Override
    public void init() {
        board.init(hardwareMap); // initialize hardware
        telemetry.addData("Status", "Initialized"); // show status
    }

    @Override
    public void loop() {
        // display touch sensor state
        telemetry.addData("Touch Pressed", board.isTouchSensorPressed());
        telemetry.addData("Touch Released", !board.isTouchSensorPressed()); // opposite of pressed
    }
}