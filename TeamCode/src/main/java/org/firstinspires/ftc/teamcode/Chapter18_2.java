package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Chapter 18_2", group = "Exercises")
public class Chapter18_2 extends OpMode {
    double hue = 0; // current color hue (0-360)

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        telemetry.addLine("Gamepad LED color cycling demo");
    }

    @Override
    public void loop() {
        // cycle through colors using hue
        hue += 0.5; // increment hue
        if (hue > 360) hue = 0; // wrap around

        // convert HSV to RGB
        float[] hsv = {(float) hue, 1.0f, 1.0f};
        int rgb = android.graphics.Color.HSVToColor(hsv);
        int r = (rgb >> 16) & 0xFF; // extract red
        int g = (rgb >> 8) & 0xFF; // extract green
        int b = rgb & 0xFF; // extract blue

        // set gamepad LED color (-1 = indefinite duration)
        gamepad1.setLedColor(r / 255.0, g / 255.0, b / 255.0, -1);

        telemetry.addData("LED Hue", "%.0f", hue);
        telemetry.addData("RGB", "(%d, %d, %d)", r, g, b);
    }
}
