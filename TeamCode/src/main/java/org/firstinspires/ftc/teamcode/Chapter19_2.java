package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Chapter 19_2", group = "Exercises")
public class Chapter19_2 extends OpMode {
    final double MAX_SPEED = 1.0; // constant - cannot be changed
    double currentSpeed = 0.5; // variable - can be changed

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        telemetry.addLine("Demo of 'final' keyword");
    }

    @Override
    public void loop() {
        // MAX_SPEED = 2.0; // ERROR: cannot assign to final variable
        currentSpeed = gamepad1.left_stick_y; // this is fine - not final

        telemetry.addData("MAX_SPEED (final)", MAX_SPEED);
        telemetry.addData("currentSpeed", "%.2f", currentSpeed);
        telemetry.addLine("'final' prevents reassignment");
    }

    // final parameter - cannot be modified inside method
    public void exampleMethod(final double value) {
        // value = 10; // ERROR: cannot assign to final parameter
        double result = value * 2; // reading is ok
    }
}
