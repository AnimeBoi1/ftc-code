package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Chapter 18 Exercise 1:
 * Write an OpMode that uses the telemetry.speak() method.
 *
 * The speak() method allows you to have the Driver Station speak text aloud.
 * This can be useful for:
 * - Announcing game state changes
 * - Alerting drivers to important events
 * - Accessibility features
 *
 * Note: The Driver Station must have text-to-speech enabled.
 */
@TeleOp(name = "Chapter 18_1", group = "Exercises")
@Disabled
public class Chapter18_1 extends OpMode {
    boolean hasSpoken = false;
    boolean wasA = false;
    int count = 0;

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        telemetry.addLine("Press A to hear the robot speak!");

        // Speak during init
        telemetry.speak("Ready to go!");
    }

    @Override
    public void start() {
        // Speak when the OpMode starts
        telemetry.speak("OpMode started!");
        hasSpoken = false;
    }

    @Override
    public void loop() {
        // Speak when A button is pressed (rising edge)
        if (gamepad1.a && !wasA) {
            count++;
            telemetry.speak("Button pressed " + count + " times");
        }
        wasA = gamepad1.a;

        // Speak once after 5 seconds
        if (getRuntime() > 5.0 && !hasSpoken) {
            telemetry.speak("Five seconds have passed");
            hasSpoken = true;
        }

        telemetry.addData("Count", count);
        telemetry.addData("Runtime", "%.1f", getRuntime());
        telemetry.addLine("Press A to speak");
    }
}