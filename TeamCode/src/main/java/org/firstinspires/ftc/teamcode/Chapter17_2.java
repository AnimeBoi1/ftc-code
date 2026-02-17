package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard; // imports the ProgrammingBoard helper class
import org.firstinspires.ftc.teamcode.mechanisms.TestItem; // imports the TestItem interface for hardware testing

import java.util.ArrayList; // imports ArrayList class for dynamic array functionality

/**
 * Exercise 17.2: Javadoc comments added to TestMotor class.
 * See TestMotor.java in the mechanisms package for the Javadoc.
 * Good documentation impresses judges!
 */
@TeleOp() // marks this class as a TeleOp program visible on the Driver Station
public class Chapter17_2 extends OpMode { // defines our class extending OpMode for iterative execution
    ProgrammingBoard board = new ProgrammingBoard(); // creates an instance of the ProgrammingBoard
    ArrayList<TestItem> tests = new ArrayList<>(); // creates a list to hold test items

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        board.init(hardwareMap); // initializes all hardware devices
        tests = board.getTests(); // gets the documented test items including TestMotor
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        telemetry.addLine("Exercise 17.2: Javadoc on TestMotor"); // displays exercise title
        telemetry.addLine("See TestMotor.java for Javadoc comments"); // directs user to documented class
        telemetry.addData("Number of tests", tests.size()); // shows how many test items are registered
        for (int i = 0; i < tests.size(); i++) { // iterates through all tests
            telemetry.addData("Test " + i, tests.get(i).getDescription()); // displays each test description
        }
    }
}
