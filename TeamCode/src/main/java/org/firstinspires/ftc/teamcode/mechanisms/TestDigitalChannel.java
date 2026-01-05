package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DigitalChannel;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Chapter 14 Exercise 1:
 * Test class for testing a DigitalChannel (like a touch sensor).
 * Displays whether the sensor is pressed or released.
 */
public class TestDigitalChannel extends TestItem {
    private DigitalChannel digitalChannel;

    public TestDigitalChannel(String description, DigitalChannel digitalChannel) {
        super(description);
        this.digitalChannel = digitalChannel;
    }

    @Override
    public void run(boolean on, Telemetry telemetry) {
        // For a touch sensor, getState() returns false when pressed
        boolean isPressed = !digitalChannel.getState();
        telemetry.addData("State", isPressed ? "PRESSED" : "Released");
    }
}