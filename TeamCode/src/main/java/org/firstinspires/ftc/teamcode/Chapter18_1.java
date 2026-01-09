package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Chapter 18_1", group = "Exercises")
public class Chapter18_1 extends OpMode {
    boolean hasSpoken = false; // track if 5-second message played
    boolean wasA = false; // previous A button state
    int count = 0; // button press counter

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        telemetry.speak("Ready to go!"); // speak during init
    }

    @Override
    public void start() {
        telemetry.speak("OpMode started!"); // speak when started
        hasSpoken = false; // reset flag
    }

    @Override
    public void loop() {
        // speak on A button press (rising edge)
        if (gamepad1.a && !wasA) {
            count++; // increment counter
            telemetry.speak("Button pressed " + count + " times");
        }
        wasA = gamepad1.a; // remember button state

        // speak once after 5 seconds
        if (getRuntime() > 5.0 && !hasSpoken) {
            telemetry.speak("Five seconds have passed");
            hasSpoken = true;
        }

        telemetry.addData("Count", count);
        telemetry.addData("Runtime", "%.1f", getRuntime());
    }
}
