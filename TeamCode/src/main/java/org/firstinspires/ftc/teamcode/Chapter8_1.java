package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode
import com.qualcomm.robotcore.hardware.Servo; // imports Servo class for direct servo configuration

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard; // imports the ProgrammingBoard helper class

@TeleOp() // marks this class as a TeleOp program visible on the Driver Station
public class Chapter8_1 extends OpMode { // defines our class extending OpMode for iterative execution
    ProgrammingBoard board = new ProgrammingBoard(); // creates an instance of the ProgrammingBoard hardware abstraction

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        board.init(hardwareMap); // initializes all hardware devices using the robot's hardware map
        // Exercise 8.1: configure servo to go backwards and only from midpoint to far left
        Servo servo = hardwareMap.get(Servo.class, "servo"); // gets servo reference for additional configuration
        servo.setDirection(Servo.Direction.REVERSE); // makes servo go backwards
        servo.scaleRange(0.5, 1.0); // restricts range to midpoint to far left only
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        board.setServoPosition(gamepad1.left_trigger); // sets servo position based on left trigger input
    }
}
