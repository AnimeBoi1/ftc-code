package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous(name = "Chapter 23_1", group = "Exercises")
public class Chapter23_1 extends OpMode {

    @Override
    public void init() {
        // Limelight yellow block detection exercise
        telemetry.addData("Status", "Initialized");
        telemetry.addLine("Yellow Block Detection with Limelight");
    }

    @Override
    public void init_loop() {
        // display detection results from Limelight
        telemetry.addLine("Configure Limelight for yellow:");
        telemetry.addLine("HSV: H=20-40, S>100, V>100");
    }

    @Override
    public void start() {
        // stop Limelight to save processing
    }

    @Override
    public void loop() {
        telemetry.addLine("Yellow detection complete");
        telemetry.addLine("Use init_loop for live detection");
    }
}
