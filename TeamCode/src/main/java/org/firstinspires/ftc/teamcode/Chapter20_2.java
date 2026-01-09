package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Chapter 20_2", group = "Exercises")
public class Chapter20_2 extends OpMode {
    DcMotor frontLeft, frontRight, backLeft, backRight; // mecanum motors
    final double ROTATION_SCALE = 0.5; // rotation at half speed

    @Override
    public void init() {
        frontLeft = hardwareMap.get(DcMotor.class, "front_left");
        frontRight = hardwareMap.get(DcMotor.class, "front_right");
        backLeft = hardwareMap.get(DcMotor.class, "back_left");
        backRight = hardwareMap.get(DcMotor.class, "back_right");

        frontRight.setDirection(DcMotor.Direction.REVERSE); // reverse right side
        backRight.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Status", "Initialized");
        telemetry.addLine("Rotation speed reduced to 50%");
    }

    @Override
    public void loop() {
        double y = -gamepad1.left_stick_y; // forward/back
        double x = gamepad1.left_stick_x; // strafe
        double rx = gamepad1.right_stick_x * ROTATION_SCALE; // rotation (scaled)

        // mecanum drive formula
        double fl = y + x + rx;
        double fr = y - x - rx;
        double bl = y - x + rx;
        double br = y + x - rx;

        // normalize if > 1.0
        double max = Math.max(Math.abs(fl), Math.max(Math.abs(fr),
                Math.max(Math.abs(bl), Math.abs(br))));
        if (max > 1.0) { fl /= max; fr /= max; bl /= max; br /= max; }

        frontLeft.setPower(fl);
        frontRight.setPower(fr);
        backLeft.setPower(bl);
        backRight.setPower(br);

        telemetry.addData("Rotation (scaled)", "%.2f", rx);
    }
}
