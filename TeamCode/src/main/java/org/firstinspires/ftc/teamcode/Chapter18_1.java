package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp()
public class Chapter18_1 extends OpMode {
    boolean hasSpoken = false;
    boolean wasA = false;
    int count = 0;

    @Override
    public void init() {
        telemetry.speak("Ready to go!");
    }

    @Override
    public void start() {
        telemetry.speak("OpMode started!");
        hasSpoken = false;
    }

    @Override
    public void loop() {
        if (gamepad1.a && !wasA) {
            count++;
            telemetry.speak("Button pressed " + count + " times");
        }
        wasA = gamepad1.a;

        if (getRuntime() > 5.0 && !hasSpoken) {
            telemetry.speak("Five seconds have passed");
            hasSpoken = true;
        }

        telemetry.addData("Count", count);
        telemetry.addData("Runtime", "%.1f", getRuntime());
    }
}
