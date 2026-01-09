package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

@TeleOp(name = "Chapter 7_1", group = "Exercises")
public class Chapter7_1 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard(); // create programming board instance
    String currentMode = "BRAKE"; // track current zero power behavior

    @Override
    public void init() {
        board.init(hardwareMap); // initialize hardware
        telemetry.addData("Status", "Initialized"); // show status
    }

    @Override
    public void loop() {
        board.setMotorSpeed(gamepad1.left_stick_y); // control motor with left stick

        // change zero power behavior based on button press
        if (gamepad1.a) {
            currentMode = "BRAKE"; // motor brakes when power is zero
        }
        if (gamepad1.b) {
            currentMode = "FLOAT"; // motor coasts when power is zero
        }

        telemetry.addData("Motor Rotations", board.getMotorRotations()); // show encoder count
        telemetry.addData("Current Mode", currentMode); // show current mode
        telemetry.addData("Press A", "for BRAKE mode");
        telemetry.addData("Press B", "for FLOAT mode");
    }
}