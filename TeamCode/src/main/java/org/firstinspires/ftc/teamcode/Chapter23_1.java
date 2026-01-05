package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Chapter 23 Exercise 1:
 * Make a pipeline that looks for yellow blocks.
 *
 * NOTE: No solution given in the book - this is a challenge exercise!
 *
 * This exercise requires:
 * 1. Limelight 3A hardware configured and connected
 * 2. A color pipeline created on the Limelight web interface
 * 3. Pipeline tuned for yellow color detection
 *
 * Steps to complete:
 * 1. Connect to Limelight web interface (http://limelight.local:5801)
 * 2. Create a new Color pipeline
 * 3. Set the target color to yellow (Hue ~25-35 for yellow)
 * 4. Adjust thresholds for your lighting conditions
 * 5. Save pipeline and set as active
 * 6. Use this OpMode to read detection results
 *
 * Yellow in HSV:
 * - Hue: 20-40 (centered around 30)
 * - Saturation: High (> 100)
 * - Value: Medium to High (> 100)
 */
@Autonomous(name = "Chapter 23_1", group = "Exercises")
@Disabled
public class Chapter23_1 extends OpMode {

    // TODO: Add Limelight
    // private Limelight3A limelight;

    @Override
    public void init() {
        // TODO: Initialize Limelight
        // limelight = hardwareMap.get(Limelight3A.class, "limelight");
        // limelight.pipelineSwitch(0);  // Switch to your yellow pipeline
        // limelight.start();

        telemetry.addData("Status", "Initialized");
        telemetry.addLine("Yellow Block Detection with Limelight");
    }

    @Override
    public void init_loop() {
        // TODO: Display detection results
        // LLResult result = limelight.getLatestResult();
        // if (result != null && result.isValid()) {
        //     List<LLResultTypes.ColorResult> colorResults = result.getColorResults();
        //     if (!colorResults.isEmpty()) {
        //         LLResultTypes.ColorResult detection = colorResults.get(0);
        //         telemetry.addData("Target Found", "YES");
        //         telemetry.addData("X", detection.getTargetXDegrees());
        //         telemetry.addData("Y", detection.getTargetYDegrees());
        //         telemetry.addData("Area", detection.getTargetArea());
        //     } else {
        //         telemetry.addData("Target Found", "No");
        //     }
        // }

        telemetry.addLine("Configure Limelight pipeline for yellow");
        telemetry.addLine("HSV Yellow: H=20-40, S>100, V>100");
    }

    @Override
    public void start() {
        // TODO: Optionally stop Limelight to save processing
        // limelight.stop();
    }

    @Override
    public void loop() {
        telemetry.addLine("Yellow detection complete");
        telemetry.addLine("Use init_loop to see live detection");
    }
}