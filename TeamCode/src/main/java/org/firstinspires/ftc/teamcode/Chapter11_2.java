package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode
import com.qualcomm.robotcore.util.Range; // imports Range utility class for value scaling and clamping

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit; // imports AngleUnit enum for angle measurements
import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard; // imports the ProgrammingBoard helper class

@TeleOp() // marks this class as a TeleOp program visible on the Driver Station
public class Chapter11_2 extends OpMode { // defines our class extending OpMode for iterative execution
    ProgrammingBoard board = new ProgrammingBoard(); // creates an instance of the ProgrammingBoard hardware abstraction

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        board.init(hardwareMap); // initializes all hardware devices using the robot's hardware map
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        double headingDegrees = board.getHeading(AngleUnit.DEGREES); // reads the IMU heading in degrees (-180 to 180)
        double motorSpeed = Range.scale(headingDegrees, -180, 180, -1.0, 1.0); // scales heading to motor speed range (-1 to 1)

        telemetry.addData("Our Heading (DEG)", headingDegrees); // displays the heading value on Driver Station
        telemetry.addData("Motor Speed", motorSpeed); // displays the calculated motor speed

        board.setMotorSpeed(motorSpeed); // sets motor speed based on heading (proportional control)
    }
}
