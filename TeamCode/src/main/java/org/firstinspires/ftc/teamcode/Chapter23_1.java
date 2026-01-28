package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.Autonomous; // imports the Autonomous annotation for autonomous mode
import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs

/**
 * Exercise 23.1: Yellow Block Detection with Limelight 3A
 *
 * This demonstrates how to configure Limelight for detecting yellow game elements.
 * The actual pipeline configuration is done in the Limelight web interface at
 * http://limelight.local:5801
 */
@Autonomous() // marks this class as an Autonomous program (runs without driver control)
public class Chapter23_1 extends OpMode { // defines our class extending OpMode for iterative execution

    // Simulated Limelight values (in real code, use Limelight3A class)
    double tx = 0; // horizontal offset from crosshair to target (-27 to 27 degrees)
    double ty = 0; // vertical offset from crosshair to target (-20.5 to 20.5 degrees)
    double ta = 0; // target area (0% to 100% of image)
    boolean targetFound = false; // whether a valid target is detected

    // Pipeline number for yellow detection
    final int YELLOW_PIPELINE = 2; // pipeline index configured for yellow blocks

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        telemetry.addLine("Chapter 23.1: Yellow Detection Setup"); // displays exercise title
        telemetry.addLine(""); // blank line for spacing

        // In real code: limelight3A.pipelineSwitch(YELLOW_PIPELINE);
        telemetry.addData("Pipeline", YELLOW_PIPELINE); // displays which pipeline to use
    }

    @Override // indicates we're overriding a method from the parent class
    public void init_loop() { // called repeatedly after init() until START is pressed
        // Simulate detection during init (use A button to simulate finding target)
        targetFound = gamepad1.a; // simulates target detection with A button
        if (targetFound) { // when "target" is detected
            tx = gamepad1.left_stick_x * 27; // simulates horizontal offset from stick position
            ty = -gamepad1.left_stick_y * 20; // simulates vertical offset from stick position
            ta = 5.0; // simulates 5% area coverage
        }

        telemetry.addLine("=== Limelight Yellow Config Guide ==="); // section header
        telemetry.addLine("1. Go to http://limelight.local:5801"); // step 1
        telemetry.addLine("2. Select Pipeline 2 (or any free slot)"); // step 2
        telemetry.addLine("3. Input Tab: Set 'Color/Retroflective'"); // step 3

        telemetry.addLine(""); // blank line for spacing
        telemetry.addLine("=== Thresholding for Yellow ==="); // section header for HSV values
        telemetry.addLine("Hue: 20-40 (yellow range)"); // hue range for yellow
        telemetry.addLine("Saturation: >100 (filters out gray)"); // saturation threshold
        telemetry.addLine("Value: >100 (filters out dark)"); // value threshold

        telemetry.addLine(""); // blank line for spacing
        telemetry.addLine("=== Live Detection (simulated) ==="); // section header for detection status
        telemetry.addData("Target Found", targetFound ? "YES" : "No"); // displays detection status
        if (targetFound) { // shows values only when target detected
            telemetry.addData("tx (horizontal)", "%.1f deg", tx); // displays horizontal offset
            telemetry.addData("ty (vertical)", "%.1f deg", ty); // displays vertical offset
            telemetry.addData("ta (area)", "%.1f%%", ta); // displays target area percentage
        }

        telemetry.addLine(""); // blank line for spacing
        telemetry.addLine("Hold A + move left stick to simulate"); // simulation instructions
    }

    @Override // indicates we're overriding a method from the parent class
    public void start() { // called once when START is pressed on Driver Station
        // In real code: limelight3A.start();
        telemetry.addLine("Limelight started"); // confirms Limelight activation
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        // Continue detection during autonomous
        targetFound = gamepad1.a; // continues simulation
        if (targetFound) { // updates values when target detected
            tx = gamepad1.left_stick_x * 27; // simulates horizontal offset
            ty = -gamepad1.left_stick_y * 20; // simulates vertical offset
        }

        telemetry.addLine("=== Autonomous Yellow Tracking ==="); // section header
        telemetry.addData("Target", targetFound ? "LOCKED" : "Searching..."); // displays tracking status

        if (targetFound) { // shows guidance when target found
            telemetry.addData("Steer", tx > 2 ? "RIGHT" : (tx < -2 ? "LEFT" : "CENTERED")); // provides steering guidance
            telemetry.addData("tx", "%.1f deg", tx); // displays precise horizontal offset
        }

        telemetry.addLine(""); // blank line for spacing
        telemetry.addLine("In real code: use tx to steer robot"); // usage hint
        telemetry.addLine("toward yellow game elements"); // describes purpose
    }
}
