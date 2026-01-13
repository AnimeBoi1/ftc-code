package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard; // imports the ProgrammingBoard helper class

@TeleOp() // marks this class as a TeleOp program visible on the Driver Station
public class Chapter15_1 extends OpMode { // defines our class extending OpMode for iterative execution
    ProgrammingBoard board = new ProgrammingBoard(); // creates an instance of the ProgrammingBoard hardware abstraction
    boolean wasPressed = false; // tracks previous state of touch sensor for edge detection

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        board.init(hardwareMap); // initializes all hardware devices using the robot's hardware map
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        boolean isPressed = board.isTouchSensorPressed(); // reads current state of touch sensor

        if (isPressed && !wasPressed) { // detects rising edge (sensor just pressed, wasn't pressed before)
            gamepad1.rumble(500); // vibrates the gamepad for 500 milliseconds
        }

        wasPressed = isPressed; // stores current state for next iteration

        telemetry.addData("Touch Sensor", isPressed ? "PRESSED" : "Released"); // displays sensor status using ternary operator
    }
}
