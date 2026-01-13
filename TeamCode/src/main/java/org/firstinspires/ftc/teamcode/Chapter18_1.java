package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode

@TeleOp() // marks this class as a TeleOp program visible on the Driver Station
public class Chapter18_1 extends OpMode { // defines our class extending OpMode for iterative execution
    boolean hasSpoken = false; // tracks if the 5-second message has been spoken
    boolean wasA = false; // tracks previous state of A button for edge detection
    int count = 0; // counts number of times A button has been pressed

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        telemetry.speak("Ready to go!"); // uses text-to-speech to announce readiness
    }

    @Override // indicates we're overriding a method from the parent class
    public void start() { // called once when START is pressed on Driver Station
        telemetry.speak("OpMode started!"); // uses text-to-speech to announce start
        hasSpoken = false; // resets the flag for the 5-second announcement
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        if (gamepad1.a && !wasA) { // detects rising edge of A button press
            count++; // increments the button press counter
            telemetry.speak("Button pressed " + count + " times"); // announces the current count
        }
        wasA = gamepad1.a; // stores current A button state for next iteration

        if (getRuntime() > 5.0 && !hasSpoken) { // checks if 5 seconds passed and not yet announced
            telemetry.speak("Five seconds have passed"); // announces the 5-second milestone
            hasSpoken = true; // prevents repeated announcements
        }

        telemetry.addData("Count", count); // displays the button press count
        telemetry.addData("Runtime", "%.1f", getRuntime()); // displays the runtime with 1 decimal place
    }
}
