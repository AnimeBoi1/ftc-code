package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

@TeleOp(name = "Chapter 7_2", group = "Exercises")
public class Chapter7_2 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard(); // create programming board instance

    @Override
    public void init() {
        board.init(hardwareMap); // initialize hardware
        telemetry.addData("Status", "Initialized"); // show status
    }

    @Override
    public void loop() {
        double rawInput = gamepad1.left_stick_y; // get raw joystick input
        double adjustedInput = squareInputWithSign(rawInput); // apply squared scaling

        board.setMotorSpeed(adjustedInput); // set motor to adjusted speed

        telemetry.addData("Raw Input", rawInput); // show original input
        telemetry.addData("Adjusted Input", adjustedInput); // show squared input
        telemetry.addData("Motor Rotations", board.getMotorRotations()); // show encoder
    }

    // squares the input while keeping the sign (+ or -)
    private double squareInputWithSign(double input) {
        return Math.signum(input) * input * input; // signum returns -1, 0, or 1
    }
}
