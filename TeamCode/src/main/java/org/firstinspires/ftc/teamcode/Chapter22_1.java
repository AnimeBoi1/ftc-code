package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Chapter 22_1", group = "Exercises")
public class Chapter22_1 extends OpMode {

    @Override
    public void init() {
        // LED branding exercise - customize robot LEDs
        telemetry.addData("Status", "Initialized");
        telemetry.addLine("Add LEDs matching your team brand!");
    }

    @Override
    public void loop() {
        // LED options:
        // 1. REV Blinkin - servo patterns
        // 2. Sparkfun LED Stick - RGB control
        // 3. REV Digital LED - simple red/green

        telemetry.addLine("LED Branding Exercise");
        telemetry.addLine("Options: Blinkin, LED Stick, Digital LED");
        telemetry.addLine("Make it match your team identity!");
    }
}
