package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit; // imports AngleUnit enum for angle measurements
import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard; // imports the ProgrammingBoard helper class

@TeleOp() // marks this class as a TeleOp program visible on the Driver Station
public class Chapter11_1 extends OpMode { // defines our class extending OpMode for iterative execution
    ProgrammingBoard board = new ProgrammingBoard(); // creates an instance of the ProgrammingBoard hardware abstraction

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        board.init(hardwareMap); // initializes all hardware devices using the robot's hardware map
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        telemetry.addData("Our Heading (DEG)", board.getHeading(AngleUnit.DEGREES)); // displays IMU heading in degrees
        telemetry.addData("Our Heading (RAD)", board.getHeading(AngleUnit.RADIANS)); // displays IMU heading in radians
    }
}
