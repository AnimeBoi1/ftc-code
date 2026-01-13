package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.Autonomous; // imports the Autonomous annotation for autonomous mode
import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs

@Autonomous() // marks this class as an Autonomous program (runs without driver control)
public class Chapter21_1 extends OpMode { // defines our class extending OpMode for iterative execution
    double robotX = 0; // stores robot's X position on the field
    double robotY = 0; // stores robot's Y position on the field
    double robotHeading = 0; // stores robot's heading/orientation

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station (empty here)
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        telemetry.addData("Robot X", "%.2f", robotX); // displays robot's X position
        telemetry.addData("Robot Y", "%.2f", robotY); // displays robot's Y position
        telemetry.addData("Heading", "%.2f", robotHeading); // displays robot's heading
        telemetry.addLine("Implement OTOS + AprilTag fusion"); // exercise instructions for sensor fusion
    }
}
