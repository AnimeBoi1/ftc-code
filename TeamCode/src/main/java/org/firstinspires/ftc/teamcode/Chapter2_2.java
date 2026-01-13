package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode

@TeleOp() // marks this class as a TeleOp program visible on the Driver Station
public class Chapter2_2 extends OpMode { // defines our class extending OpMode for iterative execution

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        String myName = "Mayank"; // declares a String variable to store the name
        int grade = 12; // declares an int variable to store the grade number

        telemetry.addData("Hello", myName); // displays "Hello: Mayank" on the Driver Station
        telemetry.addData("Grade", grade); // displays "Grade: 12" on the Driver Station
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running (empty here)
    }
}
