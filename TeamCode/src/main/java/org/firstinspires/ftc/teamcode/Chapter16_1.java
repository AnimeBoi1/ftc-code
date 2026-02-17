package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.Autonomous; // imports the Autonomous annotation for autonomous mode
import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName; // imports WebcamName for camera access
import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard; // imports the ProgrammingBoard helper class
import org.firstinspires.ftc.teamcode.processors.FirstVisionProcessor; // imports our custom vision processor
import org.firstinspires.ftc.vision.VisionPortal; // imports VisionPortal for camera pipeline management

@Autonomous() // marks this class as an Autonomous OpMode
public class Chapter16_1 extends OpMode { // Exercise 16.1: vision-controlled servo
    private FirstVisionProcessor visionProcessor; // our custom vision processor for TSE detection
    private VisionPortal visionPortal; // manages the camera and vision processing pipeline
    ProgrammingBoard board = new ProgrammingBoard(); // programming board with servo hardware

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed
        visionProcessor = new FirstVisionProcessor(); // creates the vision processor
        visionPortal = VisionPortal.easyCreateWithDefaults( // sets up camera with our processor
                hardwareMap.get(WebcamName.class, "Webcam 1"), visionProcessor);
        board.init(hardwareMap); // initializes all hardware on the programming board
    }

    @Override // indicates we're overriding a method from the parent class
    public void init_loop() { // called repeatedly after init until START is pressed
    }

    @Override // indicates we're overriding a method from the parent class
    public void start() { // called once when START is pressed
        visionPortal.stopStreaming(); // stops camera to save processing power during autonomous
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while OpMode is running
        telemetry.addData("Identified", visionProcessor.getSelection()); // displays which position was detected
        switch (visionProcessor.getSelection()) { // sets servo based on detected TSE position
            case LEFT: // if TSE is on the left
            case NONE: // or if no TSE detected, default to left
                board.setServoPosition(0.0); // servo to position 0.0 for LEFT or NONE
                break;
            case MIDDLE: // if TSE is in the middle
                board.setServoPosition(0.5); // servo to position 0.5 for MIDDLE
                break;
            case RIGHT: // if TSE is on the right
                board.setServoPosition(1.0); // servo to position 1.0 for RIGHT
                break;
        }
    }
}
