package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Chapter 20 Exercise 1:
 * Make the arcade drive (2 wheel drive) only be able to go half as fast
 * unless the A button is pressed in and then it can go full speed.
 *
 * This demonstrates a "turbo" or "boost" button pattern commonly used
 * in FTC to give drivers finer control at low speeds but full power
 * when needed.
 */
@TeleOp(name = "Chapter 20_1", group = "Exercises")
public class Chapter20_1 extends OpMode {
    DcMotor leftMotor;
    DcMotor rightMotor;

    final double NORMAL_SPEED = 0.5;  // Half speed when A not pressed
    final double TURBO_SPEED = 1.0;   // Full speed when A is pressed

    @Override
    public void init() {
        // Initialize motors - adjust names to match your configuration
        leftMotor = hardwareMap.get(DcMotor.class, "left_motor");
        rightMotor = hardwareMap.get(DcMotor.class, "right_motor");

        // Reverse one motor so both drive forward
        rightMotor.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Status", "Initialized");
        telemetry.addLine("Hold A for full speed (turbo)");
    }

    @Override
    public void loop() {
        // Get joystick values for arcade drive
        double drive = -gamepad1.left_stick_y;  // Forward/backward
        double turn = gamepad1.right_stick_x;   // Left/right turn

        // Calculate motor powers using arcade drive formula
        double leftPower = drive + turn;
        double rightPower = drive - turn;

        // Apply speed limiter based on A button
        double speedMultiplier = gamepad1.a ? TURBO_SPEED : NORMAL_SPEED;

        leftPower *= speedMultiplier;
        rightPower *= speedMultiplier;

        // Clamp values to [-1, 1] range
        leftPower = Math.max(-1, Math.min(1, leftPower));
        rightPower = Math.max(-1, Math.min(1, rightPower));

        // Set motor powers
        leftMotor.setPower(leftPower);
        rightMotor.setPower(rightPower);

        // Telemetry
        telemetry.addData("Speed Mode", gamepad1.a ? "TURBO (100%)" : "Normal (50%)");
        telemetry.addData("Left Power", "%.2f", leftPower);
        telemetry.addData("Right Power", "%.2f", rightPower);
        telemetry.addLine("");
        telemetry.addLine("Hold A for turbo mode!");
    }
}