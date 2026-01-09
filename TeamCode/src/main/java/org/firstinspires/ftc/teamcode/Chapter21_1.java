package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous(name = "Chapter 21_1", group = "Exercises")
public class Chapter21_1 extends OpMode {
    // position tracking variables
    double robotX = 0; // x position on field
    double robotY = 0; // y position on field
    double robotHeading = 0; // heading angle

    @Override
    public void init() {
        // sensor fusion: combine OTOS (continuous) with AprilTags (absolute)
        telemetry.addData("Status", "Initialized");
        telemetry.addLine("Sensor Fusion: OTOS + AprilTags");
    }

    @Override
    public void loop() {
        // step 1: get position from OTOS (continuous tracking)
        // step 2: check for AprilTag detections (absolute position)
        // step 3: when AprilTag seen, correct OTOS drift

        telemetry.addData("Robot X", "%.2f", robotX);
        telemetry.addData("Robot Y", "%.2f", robotY);
        telemetry.addData("Heading", "%.2f", robotHeading);
        telemetry.addLine("Implement OTOS + AprilTag fusion");
    }
}
