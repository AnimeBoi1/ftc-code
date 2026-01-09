package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Chapter 20 Exercise 2:
 * Change the mecanum drive to only rotate at half the speed.
 *
 * This is useful for precision driving - full translation speed but
 * reduced rotation speed for better control.
 */
@TeleOp(name = "Chapter 20_2", group = "Exercises")
public class Chapter20_2 extends OpMode {
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;

    final double ROTATION_SCALE = 0.5;  // Rotation at half speed

    @Override
    public void init() {
        // Initialize motors - adjust names to match your configuration
        frontLeft = hardwareMap.get(DcMotor.class, "front_left");
        frontRight = hardwareMap.get(DcMotor.class, "front_right");
        backLeft = hardwareMap.get(DcMotor.class, "back_left");
        backRight = hardwareMap.get(DcMotor.class, "back_right");

        // Reverse right side motors
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Status", "Initialized");
        telemetry.addLine("Rotation speed is reduced to 50%");
    }

    @Override
    public void loop() {
        // Get joystick values
        double y = -gamepad1.left_stick_y;  // Forward/backward (inverted)
        double x = gamepad1.left_stick_x;   // Strafe left/right
        double rx = gamepad1.right_stick_x; // Rotation

        // Apply rotation scaling - THIS IS THE KEY CHANGE
        rx *= ROTATION_SCALE;

        // Calculate motor powers for mecanum drive
        double frontLeftPower = y + x + rx;
        double frontRightPower = y - x - rx;
        double backLeftPower = y - x + rx;
        double backRightPower = y + x - rx;

        // Normalize if any value exceeds 1.0
        double max = Math.max(Math.abs(frontLeftPower),
                Math.max(Math.abs(frontRightPower),
                        Math.max(Math.abs(backLeftPower), Math.abs(backRightPower))));
        if (max > 1.0) {
            frontLeftPower /= max;
            frontRightPower /= max;
            backLeftPower /= max;
            backRightPower /= max;
        }

        // Set motor powers
        frontLeft.setPower(frontLeftPower);
        frontRight.setPower(frontRightPower);
        backLeft.setPower(backLeftPower);
        backRight.setPower(backRightPower);

        // Telemetry
        telemetry.addData("Drive (y)", "%.2f", y);
        telemetry.addData("Strafe (x)", "%.2f", x);
        telemetry.addData("Rotation (scaled)", "%.2f (was %.2f)",
                rx, gamepad1.right_stick_x);
        telemetry.addLine("");
        telemetry.addData("FL", "%.2f", frontLeftPower);
        telemetry.addData("FR", "%.2f", frontRightPower);
        telemetry.addData("BL", "%.2f", backLeftPower);
        telemetry.addData("BR", "%.2f", backRightPower);
    }
}