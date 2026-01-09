package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

@TeleOp(name = "Chapter 20_3", group = "Exercises")
public class Chapter20_3 extends OpMode {
    DcMotor frontLeft, frontRight, backLeft, backRight; // mecanum motors
    IMU imu; // gyro sensor
    final double ROTATION_P = 0.02; // proportional gain
    final double DEADZONE = 0.3; // joystick deadzone

    @Override
    public void init() {
        frontLeft = hardwareMap.get(DcMotor.class, "front_left");
        frontRight = hardwareMap.get(DcMotor.class, "front_right");
        backLeft = hardwareMap.get(DcMotor.class, "back_left");
        backRight = hardwareMap.get(DcMotor.class, "back_right");

        frontRight.setDirection(DcMotor.Direction.REVERSE); // reverse right
        backRight.setDirection(DcMotor.Direction.REVERSE);

        // initialize IMU
        imu = hardwareMap.get(IMU.class, "imu");
        imu.initialize(new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD)));

        telemetry.addData("Status", "Initialized");
        telemetry.addLine("Right stick snaps to angle");
    }

    @Override
    public void loop() {
        double y = -gamepad1.left_stick_y; // forward/back
        double x = gamepad1.left_stick_x; // strafe
        double rightX = gamepad1.right_stick_x;
        double rightY = -gamepad1.right_stick_y;
        double rightMag = Math.hypot(rightX, rightY); // joystick magnitude

        double rx = 0; // rotation power

        // snap to angle if right stick pushed past deadzone
        if (rightMag > DEADZONE) {
            double targetAngle = Math.toDegrees(Math.atan2(rightX, rightY)); // target from joystick
            double currentAngle = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);
            double error = targetAngle - currentAngle; // angle difference

            // normalize to [-180, 180]
            while (error > 180) error -= 360;
            while (error < -180) error += 360;

            rx = Math.max(-1, Math.min(1, error * ROTATION_P)); // P control
            telemetry.addData("Target", "%.1f", targetAngle);
            telemetry.addData("Error", "%.1f", error);
        }

        // mecanum formula
        double fl = y + x + rx, fr = y - x - rx;
        double bl = y - x + rx, br = y + x - rx;

        // normalize
        double max = Math.max(Math.abs(fl), Math.max(Math.abs(fr),
                Math.max(Math.abs(bl), Math.abs(br))));
        if (max > 1.0) { fl /= max; fr /= max; bl /= max; br /= max; }

        frontLeft.setPower(fl); frontRight.setPower(fr);
        backLeft.setPower(bl); backRight.setPower(br);

        telemetry.addData("Rotation", "%.2f", rx);
    }
}
