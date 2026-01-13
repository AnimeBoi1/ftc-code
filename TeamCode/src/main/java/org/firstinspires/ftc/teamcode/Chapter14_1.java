package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard; // imports the ProgrammingBoard helper class
import org.firstinspires.ftc.teamcode.mechanisms.TestItem; // imports the TestItem interface for hardware testing

import java.util.ArrayList; // imports ArrayList class for dynamic array functionality

@TeleOp() // marks this class as a TeleOp program visible on the Driver Station
public class Chapter14_1 extends OpMode { // defines our class extending OpMode for iterative execution
    ProgrammingBoard board = new ProgrammingBoard(); // creates an instance of the ProgrammingBoard hardware abstraction
    ArrayList<TestItem> tests = new ArrayList<>(); // creates a list to hold test items for hardware testing
    boolean wasDown, wasUp; // tracks previous state of D-pad buttons for edge detection
    int testNum; // index of the currently selected test

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        board.init(hardwareMap); // initializes all hardware devices using the robot's hardware map
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        if (gamepad1.dpad_up && !wasUp) { // checks for D-pad up press (edge detection - only triggers once)
            testNum--; // moves to the previous test
            if (testNum < 0) { // checks if we went below the first test
                testNum = Math.max(0, tests.size() - 1); // wraps around to the last test (or 0 if list is empty)
            }
        }
        wasUp = gamepad1.dpad_up; // stores current D-pad up state for next iteration

        if (gamepad1.dpad_down && !wasDown) { // checks for D-pad down press (edge detection - only triggers once)
            testNum++; // moves to the next test
            if (testNum >= tests.size()) { // checks if we went past the last test
                testNum = 0; // wraps around to the first test
            }
        }
        wasDown = gamepad1.dpad_down; // stores current D-pad down state for next iteration

        if (tests.size() > 0) { // checks if there are any tests in the list
            TestItem currTest = tests.get(testNum); // gets the currently selected test
            telemetry.addData("Test", currTest.getDescription()); // displays the test description
            currTest.run(gamepad1.a, telemetry); // runs the test (A button activates, telemetry for output)
        }
    }
}
