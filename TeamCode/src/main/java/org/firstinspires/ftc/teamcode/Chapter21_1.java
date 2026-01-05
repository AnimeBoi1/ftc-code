package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Chapter 21 Exercise 1:
 * Combine the Sparkfun Optical Tracking Odometry Sensor with the April Tags
 * code to be even more accurate for where you are on the field.
 *
 * This is a conceptual exercise that combines:
 * 1. Sparkfun OTOS sensor for continuous position tracking (odometry)
 * 2. AprilTags for periodic absolute position corrections
 *
 * The idea is:
 * - OTOS provides smooth, continuous position updates
 * - AprilTags provide accurate absolute position when visible
 * - When AprilTag is detected, use it to correct OTOS drift
 *
 * This technique is called "sensor fusion" and is commonly used
 * in robotics for more accurate localization.
 *
 * NOTE: This requires:
 * - Sparkfun OTOS sensor configured in hardware
 * - Webcam configured for AprilTag detection
 * - AprilTags visible on the field
 */
@Autonomous(name = "Chapter 21_1", group = "Exercises")
@Disabled
public class Chapter21_1 extends OpMode {

    // TODO: Add SparkFunOTOS sensor
    // private SparkFunOTOS otos;

    // TODO: Add AprilTag processor
    // private AprilTagProcessor aprilTagProcessor;
    // private VisionPortal visionPortal;

    // Position tracking
    double robotX = 0;
    double robotY = 0;
    double robotHeading = 0;

    @Override
    public void init() {
        // TODO: Initialize OTOS sensor
        // otos = hardwareMap.get(SparkFunOTOS.class, "sensor_otos");
        // otos.calibrateImu();
        // otos.resetTracking();

        // TODO: Initialize AprilTag detection
        // WebcamName webcamName = hardwareMap.get(WebcamName.class, "Webcam 1");
        // aprilTagProcessor = AprilTagProcessor.easyCreateWithDefaults();
        // visionPortal = VisionPortal.easyCreateWithDefaults(webcamName, aprilTagProcessor);

        telemetry.addData("Status", "Initialized");
        telemetry.addLine("Sensor Fusion: OTOS + AprilTags");
    }

    @Override
    public void loop() {
        // Step 1: Get position from OTOS (continuous updates)
        // SparkFunOTOS.Pose2D pos = otos.getPosition();
        // robotX = pos.x;
        // robotY = pos.y;
        // robotHeading = pos.h;

        // Step 2: Check for AprilTag detections
        // List<AprilTagDetection> detections = aprilTagProcessor.getDetections();

        // Step 3: If AprilTag detected with known field position, correct OTOS
        // for (AprilTagDetection detection : detections) {
        //     if (detection.metadata != null) {
        //         // Get robot position from AprilTag detection
        //         double tagX = detection.ftcPose.x;
        //         double tagY = detection.ftcPose.y;
        //
        //         // Reset OTOS position to match AprilTag (sensor fusion)
        //         SparkFunOTOS.Pose2D correctedPos = new SparkFunOTOS.Pose2D(tagX, tagY, robotHeading);
        //         otos.setPosition(correctedPos);
        //
        //         robotX = tagX;
        //         robotY = tagY;
        //     }
        // }

        telemetry.addData("Robot X", "%.2f", robotX);
        telemetry.addData("Robot Y", "%.2f", robotY);
        telemetry.addData("Heading", "%.2f", robotHeading);
        telemetry.addLine("");
        telemetry.addLine("Implement OTOS + AprilTag fusion");
        telemetry.addLine("for accurate field localization");
    }
}