package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp()
public class Chapter18_2 extends OpMode {
    double hue = 0;

    @Override
    public void init() {
    }

    @Override
    public void loop() {
        hue += 0.5;
        if (hue > 360) hue = 0;

        float[] hsv = {(float) hue, 1.0f, 1.0f};
        int rgb = android.graphics.Color.HSVToColor(hsv);
        int r = (rgb >> 16) & 0xFF;
        int g = (rgb >> 8) & 0xFF;
        int b = rgb & 0xFF;

        gamepad1.setLedColor(r / 255.0, g / 255.0, b / 255.0, -1);

        telemetry.addData("LED Hue", "%.0f", hue);
        telemetry.addData("RGB", "(%d, %d, %d)", r, g, b);
    }
}
