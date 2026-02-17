package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard; // imports the ProgrammingBoard helper class

/**
 * Exercise 17.1: Javadoc comments added to ProgrammingBoard class.
 * See ProgrammingBoard.java in the mechanisms package for the Javadoc.
 * Generate docs: Tools > Generate JavaDoc, select Module 'TeamCode'.
 */
@TeleOp() // marks this class as a TeleOp program visible on the Driver Station
public class Chapter17_1 extends OpMode { // defines our class extending OpMode for iterative execution
    ProgrammingBoard board = new ProgrammingBoard(); // creates an instance of the documented ProgrammingBoard

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        board.init(hardwareMap); // initializes all hardware devices using the robot's hardware map
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        telemetry.addLine("Exercise 17.1: Javadoc on ProgrammingBoard"); // displays exercise title
        telemetry.addLine("See ProgrammingBoard.java for Javadoc comments"); // directs user to documented class
        telemetry.addData("Touch Pressed", board.isTouchSensorPressed()); // demonstrates documented method
        telemetry.addData("Touch Released", board.isTouchSensorReleased()); // demonstrates documented method
    }
}
