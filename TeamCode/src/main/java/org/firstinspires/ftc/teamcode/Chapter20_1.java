package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp()
public class Chapter20_1 extends OpMode {
    DcMotor leftMotor;
    DcMotor rightMotor;

    final double NORMAL_SPEED = 0.5;
    final double TURBO_SPEED = 1.0;

    @Override
    public void init() {
        leftMotor = hardwareMap.get(DcMotor.class, "left_motor");
        rightMotor = hardwareMap.get(DcMotor.class, "right_motor");
        rightMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        double drive = -gamepad1.left_stick_y;
        double turn = gamepad1.right_stick_x;

        double leftPower = drive + turn;
        double rightPower = drive - turn;

        double speedMultiplier = gamepad1.a ? TURBO_SPEED : NORMAL_SPEED;
        leftPower *= speedMultiplier;
        rightPower *= speedMultiplier;

        leftPower = Math.max(-1, Math.min(1, leftPower));
        rightPower = Math.max(-1, Math.min(1, rightPower));

        leftMotor.setPower(leftPower);
        rightMotor.setPower(rightPower);

        telemetry.addData("Mode", gamepad1.a ? "TURBO" : "Normal");
        telemetry.addData("Left", "%.2f", leftPower);
        telemetry.addData("Right", "%.2f", rightPower);
    }
}
