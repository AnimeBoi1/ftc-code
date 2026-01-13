package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode

@TeleOp // marks this class as a TeleOp program visible on the Driver Station
public class Chapter4_2 extends OpMode { // defines our class extending OpMode for iterative execution

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station (empty here)
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        double ySpeed = gamepad1.left_stick_y; // reads left joystick Y value as the Y speed
        double xSpeed = gamepad1.left_stick_x; // reads left joystick X value as the X speed

        if (gamepad1.a) { // checks if the A button is pressed
            ySpeed = gamepad1.left_stick_x; // swaps: X input now controls Y speed
            xSpeed = gamepad1.left_stick_y; // swaps: Y input now controls X speed
        }
        telemetry.addData("X Speed", xSpeed); // displays the X speed value on Driver Station
        telemetry.addData("Y Speed", ySpeed); // displays the Y speed value on Driver Station
    }
}
