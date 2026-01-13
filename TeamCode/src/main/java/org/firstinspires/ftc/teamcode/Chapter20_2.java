package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode
import com.qualcomm.robotcore.hardware.DcMotor; // imports the DcMotor class for motor control

@TeleOp() // marks this class as a TeleOp program visible on the Driver Station
public class Chapter20_2 extends OpMode { // defines our class extending OpMode for iterative execution
    DcMotor frontLeft, frontRight, backLeft, backRight; // declares all four mecanum drive motors
    final double ROTATION_SCALE = 0.5; // constant to reduce rotation sensitivity

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        frontLeft = hardwareMap.get(DcMotor.class, "front_left"); // gets front left motor from hardware map
        frontRight = hardwareMap.get(DcMotor.class, "front_right"); // gets front right motor from hardware map
        backLeft = hardwareMap.get(DcMotor.class, "back_left"); // gets back left motor from hardware map
        backRight = hardwareMap.get(DcMotor.class, "back_right"); // gets back right motor from hardware map

        frontRight.setDirection(DcMotor.Direction.REVERSE); // reverses front right motor for proper mecanum drive
        backRight.setDirection(DcMotor.Direction.REVERSE); // reverses back right motor for proper mecanum drive
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        double y = -gamepad1.left_stick_y; // gets forward/backward (negated for intuitive control)
        double x = gamepad1.left_stick_x; // gets strafe left/right
        double rx = gamepad1.right_stick_x * ROTATION_SCALE; // gets rotation with reduced sensitivity

        double fl = y + x + rx; // calculates front left power (mecanum kinematics)
        double fr = y - x - rx; // calculates front right power (mecanum kinematics)
        double bl = y - x + rx; // calculates back left power (mecanum kinematics)
        double br = y + x - rx; // calculates back right power (mecanum kinematics)

        double max = Math.max(Math.abs(fl), Math.max(Math.abs(fr), // finds the maximum power magnitude
                Math.max(Math.abs(bl), Math.abs(br)))); // across all four motors
        if (max > 1.0) { fl /= max; fr /= max; bl /= max; br /= max; } // normalizes all powers if any exceeds 1.0

        frontLeft.setPower(fl); // sends power to front left motor
        frontRight.setPower(fr); // sends power to front right motor
        backLeft.setPower(bl); // sends power to back left motor
        backRight.setPower(br); // sends power to back right motor

        telemetry.addData("Rotation (scaled)", "%.2f", rx); // displays the scaled rotation value
    }
}
