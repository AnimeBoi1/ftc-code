package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode

@TeleOp() // marks this class as a TeleOp program visible on the Driver Station
public class Chapter19_2 extends OpMode { // defines our class extending OpMode for iterative execution
    final double MAX_SPEED = 1.0; // constant maximum speed (cannot be changed after initialization)
    double currentSpeed = 0.5; // variable current speed (can be changed)

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station (empty here)
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        currentSpeed = gamepad1.left_stick_y; // updates current speed from joystick (demonstrates non-final can change)

        telemetry.addData("MAX_SPEED (final)", MAX_SPEED); // displays the constant max speed
        telemetry.addData("currentSpeed", "%.2f", currentSpeed); // displays the variable current speed
    }

    public void exampleMethod(final double value) { // demonstrates final parameter (cannot be reassigned in method)
        double result = value * 2; // can use the final parameter in expressions
    }
}
