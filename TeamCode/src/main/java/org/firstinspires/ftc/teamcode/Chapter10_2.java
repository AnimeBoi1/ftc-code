package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit; // imports DistanceUnit enum for distance measurements
import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard; // imports the ProgrammingBoard helper class

@TeleOp() // marks this class as a TeleOp program visible on the Driver Station
public class Chapter10_2 extends OpMode { // defines our class extending OpMode for iterative execution
    ProgrammingBoard board = new ProgrammingBoard(); // creates an instance of the ProgrammingBoard hardware abstraction

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        board.init(hardwareMap); // initializes all hardware devices using the robot's hardware map
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        double distanceCM = board.getDistance(DistanceUnit.CM); // reads distance from sensor in centimeters

        if (distanceCM < 10.0) { // checks if an object is closer than 10 centimeters
            board.setMotorSpeed(0.0); // stops the motor when object is too close
        } else { // if object is far enough away
            board.setMotorSpeed(0.5); // runs motor at half speed
        }
        telemetry.addData("Distance (CM)", distanceCM); // displays the distance reading on Driver Station
    }
}
