package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Chapter 23_2", group = "Exercises")
public class Chapter23_2 extends OpMode {
    boolean wasRumbling = false; // track rumble state
    double lastTargetTime = 0; // when target was last seen
    final double NO_TARGET_THRESHOLD = 1.0; // seconds before rumbling

    @Override
    public void init() {
        // rumble feedback when no vision targets detected
        telemetry.addData("Status", "Initialized");
        telemetry.addLine("Rumbles when no targets visible");
    }

    @Override
    public void loop() {
        // simulate target detection with A button (replace with Limelight)
        boolean targetVisible = gamepad1.a;

        if (targetVisible) {
            lastTargetTime = getRuntime(); // record when target seen
        }

        double timeSinceTarget = getRuntime() - lastTargetTime; // how long since target
        boolean shouldRumble = timeSinceTarget > NO_TARGET_THRESHOLD; // rumble if no target

        // apply rumble feedback
        if (shouldRumble && !wasRumbling) {
            gamepad1.rumbleBlips(2); // start rumble pattern
            wasRumbling = true;
        } else if (!shouldRumble && wasRumbling) {
            gamepad1.stopRumble(); // stop rumble
            wasRumbling = false;
        } else if (shouldRumble && !gamepad1.isRumbling()) {
            gamepad1.rumbleBlips(2); // continue pattern
        }

        telemetry.addData("Target", targetVisible ? "YES" : "No");
        telemetry.addData("Time Since", "%.1f s", timeSinceTarget);
        telemetry.addData("Rumbling", shouldRumble ? "YES" : "No");
        telemetry.addLine("Hold A to simulate target");
    }
}
