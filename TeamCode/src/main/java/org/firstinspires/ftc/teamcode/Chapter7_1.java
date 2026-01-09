package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

/**
 * Chapter 7 Exercise 1:
 * Add a method to the ProgrammingBoard that allows you to change the
 * ZeroPowerBehavior of the motor.
 *
 * Then modify this OpMode where:
 * - pressing gamepad1.a sets it to BRAKE
 * - pressing gamepad1.b sets it to FLOAT
 *
 * Steps:
 * 1. Add setZeroPowerBehavior(DcMotor.ZeroPowerBehavior behavior) to ProgrammingBoard
 * 2. Implement the logic below
 */
@TeleOp(name = "Chapter 7_1", group = "Exercises")
public class Chapter7_1 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard();

    @Override
    public void init() {
        board.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loop() {
        // Control motor with left stick
        board.setMotorSpeed(gamepad1.left_stick_y);

        // TODO: Add logic to change ZeroPowerBehavior
        // if (gamepad1.a) { ... set to BRAKE }
        // if (gamepad1.b) { ... set to FLOAT }

        telemetry.addData("Motor Rotations", board.getMotorRotations());
        telemetry.addData("Press A", "for BRAKE mode");
        telemetry.addData("Press B", "for FLOAT mode");
    }
}