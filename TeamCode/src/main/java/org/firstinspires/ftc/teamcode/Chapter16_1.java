package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

/**
 * Chapter 16 Exercise 1:
 * Using our FirstVisionProcessor, and the programming board from chapter 8,
 * write an opmode that moves a servo to 0 if the TSE is in the left rectangle,
 * 90 if it is in the middle rect, and 180 if it is in the right rectangle.
 *
 * NOTE: This requires:
 * 1. FirstVisionProcessor class (see Chapter 16 in the PDF)
 * 2. A webcam configured as "Webcam 1"
 * 3. ProgrammingBoard with servo
 *
 * The VisionProcessor determines which rectangle has the highest saturation
 * (where the Team Scoring Element is located) and moves the servo accordingly.
 */
@Autonomous(name = "Chapter 16_1", group = "Exercises")
@Disabled
public class Chapter16_1 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard();

    // TODO: Uncomment and use when FirstVisionProcessor is implemented
    // private FirstVisionProcessor visionProcessor;
    // private VisionPortal visionPortal;

    // Servo positions for each detection
    final double SERVO_LEFT = 0.0;      // 0 degrees
    final double SERVO_MIDDLE = 0.5;    // 90 degrees (approximately)
    final double SERVO_RIGHT = 1.0;     // 180 degrees

    @Override
    public void init() {
        board.init(hardwareMap);

        // TODO: Initialize vision when FirstVisionProcessor is implemented
        // WebcamName webcamName = hardwareMap.get(WebcamName.class, "Webcam 1");
        // visionProcessor = new FirstVisionProcessor();
        // visionPortal = VisionPortal.easyCreateWithDefaults(webcamName, visionProcessor);

        telemetry.addData("Status", "Initialized");
        telemetry.addLine("Exercise: Implement FirstVisionProcessor");
        telemetry.addLine("to detect TSE position and move servo");
    }

    @Override
    public void init_loop() {
        // TODO: Uncomment when FirstVisionProcessor is implemented
        // FirstVisionProcessor.Selected selection = visionProcessor.getSelection();
        // telemetry.addData("Detection", selection);

        telemetry.addLine("Waiting for vision processor...");
        telemetry.addLine("(Implement FirstVisionProcessor from Ch16)");
    }

    @Override
    public void start() {
        // TODO: Stop streaming to save CPU
        // visionPortal.stopStreaming();

        // TODO: Move servo based on detection
        // FirstVisionProcessor.Selected selection = visionProcessor.getSelection();
        // switch (selection) {
        //     case LEFT:
        //         board.setServoPosition(SERVO_LEFT);
        //         break;
        //     case MIDDLE:
        //         board.setServoPosition(SERVO_MIDDLE);
        //         break;
        //     case RIGHT:
        //         board.setServoPosition(SERVO_RIGHT);
        //         break;
        //     default:
        //         // No detection, stay at middle
        //         board.setServoPosition(SERVO_MIDDLE);
        //         break;
        // }
    }

    @Override
    public void loop() {
        telemetry.addData("Servo Position", "Based on vision detection");
        telemetry.addLine("LEFT -> 0.0, MIDDLE -> 0.5, RIGHT -> 1.0");
    }
}