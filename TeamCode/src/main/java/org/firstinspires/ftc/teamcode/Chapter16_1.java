package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.Autonomous; // imports the Autonomous annotation for autonomous mode
import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard; // imports the ProgrammingBoard helper class

@Autonomous() // marks this class as an Autonomous program (runs without driver control)
public class Chapter16_1 extends OpMode { // defines our class extending OpMode for iterative execution
    ProgrammingBoard board = new ProgrammingBoard(); // creates an instance of the ProgrammingBoard hardware abstraction

    final double SERVO_LEFT = 0.0; // constant for servo left position (minimum)
    final double SERVO_MIDDLE = 0.5; // constant for servo center position
    final double SERVO_RIGHT = 1.0; // constant for servo right position (maximum)

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        board.init(hardwareMap); // initializes all hardware devices using the robot's hardware map
    }

    @Override // indicates we're overriding a method from the parent class
    public void init_loop() { // called repeatedly after init() until START is pressed (empty here)
    }

    @Override // indicates we're overriding a method from the parent class
    public void start() { // called once when START is pressed on Driver Station (empty here)
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        telemetry.addLine("Vision exercise - detect TSE position"); // displays exercise instructions for computer vision
    }
}
