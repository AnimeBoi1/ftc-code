package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard; // imports the ProgrammingBoard helper class

@TeleOp() // marks this class as a TeleOp program visible on the Driver Station
public class Chapter7_2 extends OpMode { // defines our class extending OpMode for iterative execution
    ProgrammingBoard board = new ProgrammingBoard(); // creates an instance of the ProgrammingBoard hardware abstraction

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        board.init(hardwareMap); // initializes all hardware devices using the robot's hardware map
    }

    double squareInputWithSign(double input) { // helper method to square input while preserving sign
        double output = input * input; // squares the input value (always positive)
        if (input < 0) { // checks if the original input was negative
            output = output * -1; // makes the output negative to preserve original sign
        }
        return output; // returns the squared value with correct sign
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        double motorSpeed = squareInputWithSign(gamepad1.left_stick_y); // squares joystick input for finer control at low speeds

        board.setMotorSpeed(motorSpeed); // sets the motor to the processed speed value
    }
}
