package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

@TeleOp()
public class Chapter20_3 extends OpMode {
    DcMotor frontLeft, frontRight, backLeft, backRight;
    IMU imu;
    final double ROTATION_P = 0.02;
    final double DEADZONE = 0.3;

    @Override
    public void init() {
        frontLeft = hardwareMap.get(DcMotor.class, "front_left");
        frontRight = hardwareMap.get(DcMotor.class, "front_right");
        backLeft = hardwareMap.get(DcMotor.class, "back_left");
        backRight = hardwareMap.get(DcMotor.class, "back_right");

        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);

        imu = hardwareMap.get(IMU.class, "imu");
        imu.initialize(new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD)));
    }

    @Override
    public void loop() {
        double y = -gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x;
        double rightX = gamepad1.right_stick_x;
        double rightY = -gamepad1.right_stick_y;
        double rightMag = Math.hypot(rightX, rightY);

        double rx = 0;

        if (rightMag > DEADZONE) {
            double targetAngle = Math.toDegrees(Math.atan2(rightX, rightY));
            double currentAngle = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);
            double error = targetAngle - currentAngle;

            while (error > 180) error -= 360;
            while (error < -180) error += 360;

            rx = Math.max(-1, Math.min(1, error * ROTATION_P));
            telemetry.addData("Target", "%.1f", targetAngle);
            telemetry.addData("Error", "%.1f", error);
        }

        double fl = y + x + rx, fr = y - x - rx;
        double bl = y - x + rx, br = y + x - rx;

        double max = Math.max(Math.abs(fl), Math.max(Math.abs(fr),
                Math.max(Math.abs(bl), Math.abs(br))));
        if (max > 1.0) { fl /= max; fr /= max; bl /= max; br /= max; }

        frontLeft.setPower(fl); frontRight.setPower(fr);
        backLeft.setPower(bl); backRight.setPower(br);

        telemetry.addData("Rotation", "%.2f", rx);
    }
}
