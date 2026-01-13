package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp()
public class Chapter22_1 extends OpMode {

    @Override
    public void init() {
        telemetry.addLine("Add LEDs matching your team brand!");
    }

    @Override
    public void loop() {
        telemetry.addLine("LED Branding Exercise");
        telemetry.addLine("Options: Blinkin, LED Stick, Digital LED");
        telemetry.addLine("Make it match your team identity!");
    }
}
