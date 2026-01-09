package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Chapter 18 Exercise 2:
 * Look through the FTC SDK documentation and find something we haven't done
 * before and try it.
 *
 * The FTC SDK Javadoc is available at:
 * https://javadoc.io/doc/org.firstinspires.ftc
 *
 * Some interesting things to explore:
 * - gamepad1.setLedColor() - Change the LED color on supported gamepads
 * - telemetry.setMsTransmissionInterval() - Change telemetry update rate
 * - hardwareMap.getAll() - Get all hardware of a certain type
 * - Various sensor methods not covered in the book
 *
 * This OpMode demonstrates gamepad LED control as an example.
 */
@TeleOp(name = "Chapter 18_2", group = "Exercises")
public class Chapter18_2 extends OpMode {
    double hue = 0;

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        telemetry.addLine("This demonstrates gamepad LED control");
        telemetry.addLine("");
        telemetry.addLine("Explore the FTC SDK Javadoc at:");
        telemetry.addLine("javadoc.io/doc/org.firstinspires.ftc");
    }

    @Override
    public void loop() {
        // Cycle through colors using HSV
        hue += 0.5;
        if (hue > 360) hue = 0;

        // Convert HSV to RGB
        float[] hsv = {(float) hue, 1.0f, 1.0f};
        int rgb = android.graphics.Color.HSVToColor(hsv);
        int r = (rgb >> 16) & 0xFF;
        int g = (rgb >> 8) & 0xFF;
        int b = rgb & 0xFF;

        // Set gamepad LED color (if supported)
        // Duration is in milliseconds, -1 means indefinite
        gamepad1.setLedColor(r / 255.0, g / 255.0, b / 255.0, -1);

        telemetry.addData("LED Hue", "%.0f", hue);
        telemetry.addData("RGB", "(%d, %d, %d)", r, g, b);
        telemetry.addLine("");
        telemetry.addLine("Gamepad LED cycling through colors");
        telemetry.addLine("(if your gamepad supports it)");
    }
}