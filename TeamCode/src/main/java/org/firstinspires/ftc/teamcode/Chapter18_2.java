package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode

@TeleOp() // marks this class as a TeleOp program visible on the Driver Station
public class Chapter18_2 extends OpMode { // defines our class extending OpMode for iterative execution
    double hue = 0; // stores the current hue value (0-360) for rainbow effect

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station (empty here)
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        hue += 0.5; // slowly increments the hue for smooth color transition
        if (hue > 360) hue = 0; // wraps hue back to 0 after completing full spectrum

        float[] hsv = {(float) hue, 1.0f, 1.0f}; // creates HSV array with current hue, full saturation, full value
        int rgb = android.graphics.Color.HSVToColor(hsv); // converts HSV to RGB integer color
        int r = (rgb >> 16) & 0xFF; // extracts red component using bit shifting
        int g = (rgb >> 8) & 0xFF; // extracts green component using bit shifting
        int b = rgb & 0xFF; // extracts blue component using bit masking

        gamepad1.setLedColor(r / 255.0, g / 255.0, b / 255.0, -1); // sets gamepad LED to current rainbow color

        telemetry.addData("LED Hue", "%.0f", hue); // displays current hue value
        telemetry.addData("RGB", "(%d, %d, %d)", r, g, b); // displays RGB component values
    }
}
