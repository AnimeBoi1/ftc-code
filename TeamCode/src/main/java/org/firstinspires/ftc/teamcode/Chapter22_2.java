package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DigitalChannel;

@TeleOp(name = "Chapter 22_2", group = "Exercises")
public class Chapter22_2 extends OpMode {
    ColorSensor colorSensor; // detects colors
    DigitalChannel greenLed, redLed; // LED indicators

    final int RED_THRESHOLD = 150; // red detection threshold
    final int BLUE_THRESHOLD = 150; // blue detection threshold
    boolean isRedAlliance = true; // true = red, false = blue

    @Override
    public void init() {
        colorSensor = hardwareMap.get(ColorSensor.class, "sensor_color_distance");
        greenLed = hardwareMap.get(DigitalChannel.class, "green_led");
        redLed = hardwareMap.get(DigitalChannel.class, "red_led");

        greenLed.setMode(DigitalChannel.Mode.OUTPUT); // set as output
        redLed.setMode(DigitalChannel.Mode.OUTPUT);

        telemetry.addData("Status", "Initialized");
        telemetry.addLine("Press X to toggle alliance");
    }

    @Override
    public void loop() {
        if (gamepad1.x) { // toggle alliance color
            isRedAlliance = !isRedAlliance;
            try { Thread.sleep(200); } catch (InterruptedException e) {} // debounce
        }

        int red = colorSensor.red(); // read red value
        int blue = colorSensor.blue(); // read blue value

        // check if alliance color detected
        boolean detected = isRedAlliance ?
                (red > RED_THRESHOLD && red > blue) :
                (blue > BLUE_THRESHOLD && blue > red);

        // light up LED when alliance color seen
        if (detected) {
            redLed.setState(isRedAlliance); // red LED for red alliance
            greenLed.setState(!isRedAlliance); // green LED for blue alliance
        } else {
            redLed.setState(false); // turn off
            greenLed.setState(false);
        }

        telemetry.addData("Alliance", isRedAlliance ? "RED" : "BLUE");
        telemetry.addData("Red", red);
        telemetry.addData("Blue", blue);
        telemetry.addData("Detected", detected ? "YES!" : "No");
    }
}
