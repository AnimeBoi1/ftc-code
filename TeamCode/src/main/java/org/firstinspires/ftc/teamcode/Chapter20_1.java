package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode
import com.qualcomm.robotcore.hardware.DcMotor; // imports the DcMotor class for motor control

@TeleOp() // marks this class as a TeleOp program visible on the Driver Station
public class Chapter20_1 extends OpMode { // defines our class extending OpMode for iterative execution
    DcMotor leftMotor; // declares the left drive motor
    DcMotor rightMotor; // declares the right drive motor

    final double NORMAL_SPEED = 0.5; // constant for normal driving speed (half power)
    final double TURBO_SPEED = 1.0; // constant for turbo mode (full power)

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        leftMotor = hardwareMap.get(DcMotor.class, "left_motor"); // gets left motor from hardware map
        rightMotor = hardwareMap.get(DcMotor.class, "right_motor"); // gets right motor from hardware map
        rightMotor.setDirection(DcMotor.Direction.REVERSE); // reverses right motor so both sides drive forward together
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        double drive = -gamepad1.left_stick_y; // gets forward/backward from left stick (negated for intuitive control)
        double turn = gamepad1.right_stick_x; // gets turning from right stick

        double leftPower = drive + turn; // combines drive and turn for left motor (arcade drive)
        double rightPower = drive - turn; // combines drive and turn for right motor (opposite turn direction)

        double speedMultiplier = gamepad1.a ? TURBO_SPEED : NORMAL_SPEED; // selects speed based on A button
        leftPower *= speedMultiplier; // applies speed multiplier to left motor
        rightPower *= speedMultiplier; // applies speed multiplier to right motor

        leftPower = Math.max(-1, Math.min(1, leftPower)); // clamps left power to valid range (-1 to 1)
        rightPower = Math.max(-1, Math.min(1, rightPower)); // clamps right power to valid range (-1 to 1)

        leftMotor.setPower(leftPower); // sends power to left motor
        rightMotor.setPower(rightPower); // sends power to right motor

        telemetry.addData("Mode", gamepad1.a ? "TURBO" : "Normal"); // displays current speed mode
        telemetry.addData("Left", "%.2f", leftPower); // displays left motor power
        telemetry.addData("Right", "%.2f", rightPower); // displays right motor power
    }
}
