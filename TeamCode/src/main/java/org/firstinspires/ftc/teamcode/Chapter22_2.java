package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DigitalChannel;

/**
 * Chapter 22 Exercise 2:
 * For any of the three LED options, make them light up when a color sensor
 * sees a game element of your alliance color.
 *
 * This exercise does not have a solution in the appendix.
 *
 * This demonstrates using LEDs for driver feedback:
 * - LEDs light up when color sensor detects target color
 * - Helps drivers know when game element is in position
 *
 * This example uses REV Digital LED Indicator (simplest option)
 */
@TeleOp(name = "Chapter 22_2", group = "Exercises")
public class Chapter22_2 extends OpMode {
    ColorSensor colorSensor;
    DigitalChannel greenLed;
    DigitalChannel redLed;

    // Color thresholds - adjust based on your game elements
    final int RED_THRESHOLD = 150;
    final int BLUE_THRESHOLD = 150;

    // Set to true for red alliance, false for blue alliance
    boolean isRedAlliance = true;

    @Override
    public void init() {
        // Initialize color sensor
        colorSensor = hardwareMap.get(ColorSensor.class, "sensor_color_distance");

        // Initialize LED indicator (REV Digital LED uses two digital channels)
        greenLed = hardwareMap.get(DigitalChannel.class, "green_led");
        redLed = hardwareMap.get(DigitalChannel.class, "red_led");

        greenLed.setMode(DigitalChannel.Mode.OUTPUT);
        redLed.setMode(DigitalChannel.Mode.OUTPUT);

        telemetry.addData("Status", "Initialized");
        telemetry.addData("Alliance", isRedAlliance ? "RED" : "BLUE");
        telemetry.addLine("Press X to toggle alliance color");
    }

    @Override
    public void loop() {
        // Toggle alliance with X button
        if (gamepad1.x) {
            isRedAlliance = !isRedAlliance;
            try {
                Thread.sleep(200);  // Simple debounce
            } catch (InterruptedException e) {
                // Ignore
            }
        }

        // Read color sensor values
        int red = colorSensor.red();
        int blue = colorSensor.blue();

        // Check if we see our alliance color
        boolean seesAllianceColor;
        if (isRedAlliance) {
            seesAllianceColor = red > RED_THRESHOLD && red > blue;
        } else {
            seesAllianceColor = blue > BLUE_THRESHOLD && blue > red;
        }

        // Light up LED if we see alliance color
        if (seesAllianceColor) {
            if (isRedAlliance) {
                redLed.setState(true);
                greenLed.setState(false);
            } else {
                // Blue alliance - light green LED (or use different indicator)
                redLed.setState(false);
                greenLed.setState(true);
            }
        } else {
            // No detection - turn off LEDs
            redLed.setState(false);
            greenLed.setState(false);
        }

        // Telemetry
        telemetry.addData("Alliance", isRedAlliance ? "RED" : "BLUE");
        telemetry.addData("Color - Red", red);
        telemetry.addData("Color - Blue", blue);
        telemetry.addData("Detected", seesAllianceColor ? "YES!" : "No");
        telemetry.addLine("");
        telemetry.addLine("LED lights when alliance color detected");
    }
}