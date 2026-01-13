package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot; // imports REV Hub orientation configuration
import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode
import com.qualcomm.robotcore.hardware.DcMotor; // imports the DcMotor class for motor control
import com.qualcomm.robotcore.hardware.IMU; // imports the IMU class for gyroscope/orientation sensing

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit; // imports AngleUnit enum for angle measurements

@TeleOp() // marks this class as a TeleOp program visible on the Driver Station
public class Chapter20_3 extends OpMode { // defines our class extending OpMode for iterative execution
    DcMotor frontLeft, frontRight, backLeft, backRight; // declares all four mecanum drive motors
    IMU imu; // declares the IMU for heading measurement
    final double ROTATION_P = 0.02; // proportional constant for heading correction
    final double DEADZONE = 0.3; // minimum joystick magnitude to activate heading control

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        frontLeft = hardwareMap.get(DcMotor.class, "front_left"); // gets front left motor from hardware map
        frontRight = hardwareMap.get(DcMotor.class, "front_right"); // gets front right motor from hardware map
        backLeft = hardwareMap.get(DcMotor.class, "back_left"); // gets back left motor from hardware map
        backRight = hardwareMap.get(DcMotor.class, "back_right"); // gets back right motor from hardware map

        frontRight.setDirection(DcMotor.Direction.REVERSE); // reverses front right motor for proper mecanum drive
        backRight.setDirection(DcMotor.Direction.REVERSE); // reverses back right motor for proper mecanum drive

        imu = hardwareMap.get(IMU.class, "imu"); // gets the IMU from hardware map
        imu.initialize(new IMU.Parameters(new RevHubOrientationOnRobot( // initializes IMU with hub orientation
                RevHubOrientationOnRobot.LogoFacingDirection.UP, // specifies logo faces up
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD))); // specifies USB faces forward
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        double y = -gamepad1.left_stick_y; // gets forward/backward (negated for intuitive control)
        double x = gamepad1.left_stick_x; // gets strafe left/right
        double rightX = gamepad1.right_stick_x; // gets right stick X for heading control
        double rightY = -gamepad1.right_stick_y; // gets right stick Y for heading control (negated)
        double rightMag = Math.hypot(rightX, rightY); // calculates magnitude of right stick

        double rx = 0; // rotation power, starts at zero

        if (rightMag > DEADZONE) { // only calculates heading if stick is pushed past deadzone
            double targetAngle = Math.toDegrees(Math.atan2(rightX, rightY)); // calculates target heading from stick direction
            double currentAngle = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES); // gets current robot heading
            double error = targetAngle - currentAngle; // calculates heading error

            while (error > 180) error -= 360; // normalizes error to -180 to 180 range
            while (error < -180) error += 360; // wraps angle to prevent spinning the long way

            rx = Math.max(-1, Math.min(1, error * ROTATION_P)); // calculates rotation with P control, clamped to -1 to 1
            telemetry.addData("Target", "%.1f", targetAngle); // displays target heading
            telemetry.addData("Error", "%.1f", error); // displays heading error
        }

        double fl = y + x + rx, fr = y - x - rx; // calculates front motor powers (mecanum kinematics)
        double bl = y - x + rx, br = y + x - rx; // calculates back motor powers (mecanum kinematics)

        double max = Math.max(Math.abs(fl), Math.max(Math.abs(fr), // finds the maximum power magnitude
                Math.max(Math.abs(bl), Math.abs(br)))); // across all four motors
        if (max > 1.0) { fl /= max; fr /= max; bl /= max; br /= max; } // normalizes all powers if any exceeds 1.0

        frontLeft.setPower(fl); frontRight.setPower(fr); // sends power to front motors
        backLeft.setPower(bl); backRight.setPower(br); // sends power to back motors

        telemetry.addData("Rotation", "%.2f", rx); // displays the calculated rotation power
    }
}
