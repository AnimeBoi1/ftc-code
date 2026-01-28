package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode
import com.qualcomm.robotcore.hardware.Servo; // imports Servo class for direct servo configuration

@TeleOp() // marks this class as a TeleOp program visible on the Driver Station
public class Chapter8_1 extends OpMode { // defines our class extending OpMode for iterative execution
    Servo servo; // declares a servo variable for direct configuration

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        servo = hardwareMap.get(Servo.class, "servo"); // gets servo from hardware map
        servo.setDirection(Servo.Direction.REVERSE); // makes servo go backwards (Exercise 8.1 requirement)
        servo.scaleRange(0.5, 1.0); // restricts range to midpoint to far left only (Exercise 8.1 requirement)
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        if (gamepad1.a) { // checks if the A button is pressed
            servo.setPosition(1.0); // with REVERSE and scaleRange(0,0.5), this goes to far left
        } else if (gamepad1.b) { // checks if the B button is pressed instead
            servo.setPosition(0.0); // with REVERSE and scaleRange(0,0.5), this goes to midpoint
        } else { // if neither A nor B is pressed
            servo.setPosition(0.5); // moves servo to center of restricted range
        }

        telemetry.addData("Direction", "REVERSE"); // displays that servo direction is reversed
        telemetry.addData("Range", "0.5 to 1.0 (midpoint to far left with REVERSE)"); // displays restricted range
    }
}
