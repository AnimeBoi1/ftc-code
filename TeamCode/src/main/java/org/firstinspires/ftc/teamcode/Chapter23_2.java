package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Chapter 23 Exercise 2:
 * Make a TeleOp that if it doesn't see any targets rumbles the gamepad.
 *
 * NOTE: No solution given in the book - this is a challenge exercise!
 *
 * This exercise combines:
 * 1. Limelight vision processing
 * 2. Gamepad rumble feedback
 *
 * The idea is to provide haptic feedback to the driver when no targets
 * are visible, helping them navigate to find game elements.
 *
 * Implementation hints:
 * - Use Limelight to detect targets
 * - If no targets detected for some time, rumble the gamepad
 * - Stop rumbling when targets are found
 * - Consider using rumble patterns (blips) rather than continuous rumble
 */
@TeleOp(name = "Chapter 23_2", group = "Exercises")
@Disabled
public class Chapter23_2 extends OpMode {

    // TODO: Add Limelight
    // private Limelight3A limelight;

    boolean wasRumbling = false;
    double lastTargetTime = 0;
    final double NO_TARGET_THRESHOLD = 1.0;  // Seconds without target before rumbling

    @Override
    public void init() {
        // TODO: Initialize Limelight
        // limelight = hardwareMap.get(Limelight3A.class, "limelight");
        // limelight.pipelineSwitch(0);  // Your detection pipeline
        // limelight.start();

        telemetry.addData("Status", "Initialized");
        telemetry.addLine("Rumbles when no targets visible");
    }

    @Override
    public void loop() {
        boolean targetVisible = false;

        // TODO: Check for targets with Limelight
        // LLResult result = limelight.getLatestResult();
        // if (result != null && result.isValid()) {
        //     // Check color results
        //     List<LLResultTypes.ColorResult> colorResults = result.getColorResults();
        //     if (!colorResults.isEmpty()) {
        //         targetVisible = true;
        //     }
        //     // Or check AprilTag results
        //     List<LLResultTypes.FiducialResult> fiducialResults = result.getFiducialResults();
        //     if (!fiducialResults.isEmpty()) {
        //         targetVisible = true;
        //     }
        // }

        // For demo purposes without Limelight, use gamepad button
        targetVisible = gamepad1.a;  // Simulate target detection with A button

        // Update last target time
        if (targetVisible) {
            lastTargetTime = getRuntime();
        }

        // Check if we should rumble
        double timeSinceTarget = getRuntime() - lastTargetTime;
        boolean shouldRumble = timeSinceTarget > NO_TARGET_THRESHOLD;

        // Apply rumble feedback
        if (shouldRumble && !wasRumbling) {
            // Start rumbling - use blips pattern
            gamepad1.rumbleBlips(2);
            wasRumbling = true;
        } else if (!shouldRumble && wasRumbling) {
            // Stop rumbling
            gamepad1.stopRumble();
            wasRumbling = false;
        } else if (shouldRumble) {
            // Continue rumble pattern
            if (!gamepad1.isRumbling()) {
                gamepad1.rumbleBlips(2);
            }
        }

        // Telemetry
        telemetry.addData("Target Visible", targetVisible ? "YES" : "No");
        telemetry.addData("Time Since Target", "%.1f s", timeSinceTarget);
        telemetry.addData("Rumbling", shouldRumble ? "YES" : "No");
        telemetry.addLine("");
        telemetry.addLine("Hold A to simulate target detection");
        telemetry.addLine("Release A to trigger rumble after 1 sec");
    }
}