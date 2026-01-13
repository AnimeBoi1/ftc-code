package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode

@TeleOp() // marks this class as a TeleOp program visible on the Driver Station
public class Chapter23_2 extends OpMode { // defines our class extending OpMode for iterative execution
    boolean wasRumbling = false; // tracks if gamepad was rumbling in previous loop
    double lastTargetTime = 0; // stores timestamp when target was last seen
    final double NO_TARGET_THRESHOLD = 1.0; // seconds without target before rumbling

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        telemetry.addLine("Rumbles when no targets visible"); // displays program description
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        boolean targetVisible = gamepad1.a; // simulates target visibility with A button (for testing)

        if (targetVisible) { // if target is currently visible
            lastTargetTime = getRuntime(); // update the last seen timestamp
        }

        double timeSinceTarget = getRuntime() - lastTargetTime; // calculate time since target was last seen
        boolean shouldRumble = timeSinceTarget > NO_TARGET_THRESHOLD; // determine if we should rumble

        if (shouldRumble && !wasRumbling) { // if we should start rumbling (rising edge)
            gamepad1.rumbleBlips(2); // sends 2 rumble blips to gamepad
            wasRumbling = true; // records that we started rumbling
        } else if (!shouldRumble && wasRumbling) { // if we should stop rumbling (falling edge)
            gamepad1.stopRumble(); // stops any ongoing rumble
            wasRumbling = false; // records that we stopped rumbling
        } else if (shouldRumble && !gamepad1.isRumbling()) { // if we should keep rumbling but it stopped
            gamepad1.rumbleBlips(2); // restart the rumble blips
        }

        telemetry.addData("Target", targetVisible ? "YES" : "No"); // displays target visibility
        telemetry.addData("Time Since", "%.1f s", timeSinceTarget); // displays time since last target
        telemetry.addData("Rumbling", shouldRumble ? "YES" : "No"); // displays rumble status
        telemetry.addLine("Hold A to simulate target"); // instructions for testing
    }
}
