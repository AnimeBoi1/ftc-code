package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

@Autonomous(name = "Chapter 16_1", group = "Exercises")
public class Chapter16_1 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard(); // create programming board instance

    // servo positions for TSE detection
    final double SERVO_LEFT = 0.0; // 0 degrees
    final double SERVO_MIDDLE = 0.5; // 90 degrees
    final double SERVO_RIGHT = 1.0; // 180 degrees

    @Override
    public void init() {
        board.init(hardwareMap); // initialize hardware
        telemetry.addData("Status", "Initialized");
        telemetry.addLine("Vision exercise - detect TSE position");
    }

    @Override
    public void init_loop() {
        // vision processor would detect TSE here
        telemetry.addLine("Waiting for vision detection...");
    }

    @Override
    public void start() {
        // move servo based on vision detection
        // LEFT -> 0.0, MIDDLE -> 0.5, RIGHT -> 1.0
    }

    @Override
    public void loop() {
        telemetry.addData("Servo Position", "Based on vision detection");
        telemetry.addLine("LEFT->0.0, MIDDLE->0.5, RIGHT->1.0");
    }
}
