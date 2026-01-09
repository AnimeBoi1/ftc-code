package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Chapter 20_1", group = "Exercises")
public class Chapter20_1 extends OpMode {
    DcMotor leftMotor; // left drive motor
    DcMotor rightMotor; // right drive motor

    final double NORMAL_SPEED = 0.5; // half speed normally
    final double TURBO_SPEED = 1.0; // full speed with A button

    @Override
    public void init() {
        leftMotor = hardwareMap.get(DcMotor.class, "left_motor"); // get left motor
        rightMotor = hardwareMap.get(DcMotor.class, "right_motor"); // get right motor
        rightMotor.setDirection(DcMotor.Direction.REVERSE); // reverse right motor

        telemetry.addData("Status", "Initialized");
        telemetry.addLine("Hold A for turbo mode");
    }

    @Override
    public void loop() {
        double drive = -gamepad1.left_stick_y; // forward/backward
        double turn = gamepad1.right_stick_x; // left/right turn

        // arcade drive formula
        double leftPower = drive + turn;
        double rightPower = drive - turn;

        // apply speed limiter - turbo when A pressed
        double speedMultiplier = gamepad1.a ? TURBO_SPEED : NORMAL_SPEED;
        leftPower *= speedMultiplier;
        rightPower *= speedMultiplier;

        // clamp to [-1, 1]
        leftPower = Math.max(-1, Math.min(1, leftPower));
        rightPower = Math.max(-1, Math.min(1, rightPower));

        leftMotor.setPower(leftPower); // set left motor
        rightMotor.setPower(rightPower); // set right motor

        telemetry.addData("Mode", gamepad1.a ? "TURBO" : "Normal");
        telemetry.addData("Left", "%.2f", leftPower);
        telemetry.addData("Right", "%.2f", rightPower);
    }
}
