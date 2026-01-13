package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.Autonomous; // imports the Autonomous annotation for autonomous mode
import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs

@Autonomous() // marks this class as an Autonomous program (runs without driver control)
public class Chapter23_1 extends OpMode { // defines our class extending OpMode for iterative execution

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        telemetry.addLine("Yellow Block Detection with Limelight"); // displays exercise title
    }

    @Override // indicates we're overriding a method from the parent class
    public void init_loop() { // called repeatedly after init() until START is pressed
        telemetry.addLine("Configure Limelight for yellow:"); // displays configuration instructions
        telemetry.addLine("HSV: H=20-40, S>100, V>100"); // shows HSV range for yellow detection
    }

    @Override // indicates we're overriding a method from the parent class
    public void start() { // called once when START is pressed on Driver Station (empty here)
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        telemetry.addLine("Yellow detection complete"); // displays completion message
        telemetry.addLine("Use init_loop for live detection"); // suggests using init_loop for detection during init
    }
}
