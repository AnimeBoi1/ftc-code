package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

/**
 * Chapter 20 Exercise 3 (CHALLENGE):
 * Make the right joystick snap the robot to the angle of where the joystick
 * is pressed.
 *
 * HINT: You'll need to get the theta of the joystick and figure out which
 * way to make the robot rotate to get closer.
 *
 * NOTE: Sample solution NOT given in the book - this is a challenge exercise!
 *
 * This implementation uses a simple proportional controller to rotate
 * the robot toward the joystick angle.
 */
@TeleOp(name = "Chapter 20_3", group = "Exercises")
public class Chapter20_3 extends OpMode {
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    IMU imu;

    final double ROTATION_P = 0.02;  // Proportional gain for rotation
    final double DEADZONE = 0.3;     // Joystick deadzone

    @Override
    public void init() {
        // Initialize motors
        frontLeft = hardwareMap.get(DcMotor.class, "front_left");
        frontRight = hardwareMap.get(DcMotor.class, "front_right");
        backLeft = hardwareMap.get(DcMotor.class, "back_left");
        backRight = hardwareMap.get(DcMotor.class, "back_right");

        // Reverse right side
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);

        // Initialize IMU
        imu = hardwareMap.get(IMU.class, "imu");
        imu.initialize(new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD)));

        telemetry.addData("Status", "Initialized");
        telemetry.addLine("CHALLENGE: Right stick snaps to angle");
    }

    @Override
    public void loop() {
        // Get translation from left stick
        double y = -gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x;

        // Get target angle from right stick
        double rightX = gamepad1.right_stick_x;
        double rightY = -gamepad1.right_stick_y;
        double rightMagnitude = Math.hypot(rightX, rightY);

        double rx = 0;  // Rotation power

        // Only snap to angle if right stick is pushed past deadzone
        if (rightMagnitude > DEADZONE) {
            // Get target angle from joystick (in degrees)
            double targetAngle = Math.toDegrees(Math.atan2(rightX, rightY));

            // Get current robot heading
            double currentAngle = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);

            // Calculate angle error
            double error = targetAngle - currentAngle;

            // Normalize error to [-180, 180]
            while (error > 180) error -= 360;
            while (error < -180) error += 360;

            // Apply proportional control
            rx = error * ROTATION_P;

            // Clamp rotation power
            rx = Math.max(-1, Math.min(1, rx));

            telemetry.addData("Target Angle", "%.1f", targetAngle);
            telemetry.addData("Current Angle", "%.1f", currentAngle);
            telemetry.addData("Error", "%.1f", error);
        }

        // Calculate mecanum motor powers
        double frontLeftPower = y + x + rx;
        double frontRightPower = y - x - rx;
        double backLeftPower = y - x + rx;
        double backRightPower = y + x - rx;

        // Normalize
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

        telemetry.addData("Rotation Power", "%.2f", rx);
        telemetry.addLine("Push right stick to snap to angle");
    }
}