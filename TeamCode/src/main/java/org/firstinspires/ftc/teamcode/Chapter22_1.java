package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode

@TeleOp() // marks this class as a TeleOp program visible on the Driver Station
public class Chapter22_1 extends OpMode { // defines our class extending OpMode for iterative execution

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        telemetry.addLine("Add LEDs matching your team brand!"); // displays exercise instructions
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        telemetry.addLine("LED Branding Exercise"); // displays exercise title
        telemetry.addLine("Options: Blinkin, LED Stick, Digital LED"); // lists LED hardware options
        telemetry.addLine("Make it match your team identity!"); // encourages team customization
    }
}
