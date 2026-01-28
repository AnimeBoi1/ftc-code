package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.Autonomous; // imports the Autonomous annotation for autonomous mode
import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs

/**
 * Exercise 21.1: Combine Sparkfun OTOS with AprilTags for improved accuracy.
 *
 * Strategy: Use OTOS for continuous tracking, correct with AprilTag when visible.
 * OTOS drifts over time, AprilTags provide absolute position but need line of sight.
 */
@Autonomous() // marks this class as an Autonomous program (runs without driver control)
public class Chapter21_1 extends OpMode { // defines our class extending OpMode for iterative execution
    // Position tracking variables (would come from OTOS in real implementation)
    double otosX = 0; // X position from Optical Tracking Odometry Sensor
    double otosY = 0; // Y position from OTOS
    double otosHeading = 0; // heading from OTOS

    // AprilTag correction values (would come from VisionPortal)
    double aprilTagX = 0; // X position calculated from AprilTag
    double aprilTagY = 0; // Y position from AprilTag
    boolean aprilTagVisible = false; // whether an AprilTag is currently detected

    // Fused position (best estimate combining both sensors)
    double fusedX = 0; // final X position after sensor fusion
    double fusedY = 0; // final Y position after sensor fusion
    double fusedHeading = 0; // final heading after sensor fusion

    // Simulated time for demo
    double lastAprilTagTime = 0; // timestamp when AprilTag was last seen

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        telemetry.addLine("Exercise 21.1: OTOS + AprilTag Fusion"); // displays exercise title
        telemetry.addLine("Press A to simulate AprilTag detection"); // displays simulation instructions
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        // Simulate OTOS drift over time
        otosX += 0.01; // simulates gradual position drift
        otosY += 0.005; // simulates gradual Y drift
        otosHeading += 0.1; // simulates heading drift

        // Simulate AprilTag detection when A is pressed
        aprilTagVisible = gamepad1.a; // simulates AprilTag visibility with A button
        if (aprilTagVisible) { // when AprilTag is "detected"
            aprilTagX = 24.0; // simulated absolute X position from AprilTag (inches)
            aprilTagY = 48.0; // simulated absolute Y position from AprilTag (inches)
            lastAprilTagTime = getRuntime(); // records when AprilTag was last seen
        }

        // Sensor Fusion: When AprilTag visible, snap to its position
        // Otherwise, use OTOS with accumulated drift
        double timeSinceAprilTag = getRuntime() - lastAprilTagTime; // calculates time since last AprilTag sighting
        if (timeSinceAprilTag < 0.5) { // if AprilTag was seen recently (within 0.5 seconds)
            fusedX = aprilTagX; // trusts AprilTag position for X
            fusedY = aprilTagY; // trusts AprilTag position for Y
            // Reset OTOS offset to match AprilTag (in real code)
        } else { // if no recent AprilTag data
            fusedX = otosX; // falls back to OTOS position (with drift)
            fusedY = otosY; // falls back to OTOS Y position
        }
        fusedHeading = otosHeading; // heading typically from OTOS (AprilTag heading less reliable)

        // Display sensor fusion results
        telemetry.addLine("=== OTOS (drifts over time) ==="); // section header for OTOS data
        telemetry.addData("OTOS X", "%.2f in", otosX); // displays OTOS X position
        telemetry.addData("OTOS Y", "%.2f in", otosY); // displays OTOS Y position

        telemetry.addLine("=== AprilTag (absolute, when visible) ==="); // section header for AprilTag data
        telemetry.addData("AprilTag Visible", aprilTagVisible ? "YES" : "No"); // displays AprilTag visibility
        if (aprilTagVisible) { // only shows AprilTag position when visible
            telemetry.addData("AprilTag X", "%.2f in", aprilTagX); // displays AprilTag X position
            telemetry.addData("AprilTag Y", "%.2f in", aprilTagY); // displays AprilTag Y position
        }

        telemetry.addLine("=== Fused Position (best estimate) ==="); // section header for fused data
        telemetry.addData("Fused X", "%.2f in", fusedX); // displays fused X position
        telemetry.addData("Fused Y", "%.2f in", fusedY); // displays fused Y position
        telemetry.addData("Heading", "%.1f deg", fusedHeading); // displays heading

        telemetry.addLine(""); // blank line for spacing
        telemetry.addLine("Hold A to simulate seeing AprilTag"); // reminder for simulation controls
    }
}
