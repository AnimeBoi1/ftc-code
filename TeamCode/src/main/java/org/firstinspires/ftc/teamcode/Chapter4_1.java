package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode

@TeleOp // marks this class as a TeleOp program visible on the Driver Station
public class Chapter4_1 extends OpMode { // defines our class extending OpMode for iterative execution

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station (empty here)
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        double fwdSpeed = gamepad1.left_stick_y; // reads the left joystick Y value as forward speed (-1 to 1)

        if (!gamepad1.a) { // checks if the A button is NOT pressed
            fwdSpeed *= 0.5; // reduces speed to half when A is not pressed (slow mode)
        }
        telemetry.addData("Forward Speed", fwdSpeed); // displays the calculated forward speed on Driver Station
    }
}
