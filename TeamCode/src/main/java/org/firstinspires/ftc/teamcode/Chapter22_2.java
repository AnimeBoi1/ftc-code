package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode
import com.qualcomm.robotcore.hardware.ColorSensor; // imports ColorSensor class for color detection
import com.qualcomm.robotcore.hardware.DigitalChannel; // imports DigitalChannel class for LED control

@TeleOp() // marks this class as a TeleOp program visible on the Driver Station
public class Chapter22_2 extends OpMode { // defines our class extending OpMode for iterative execution
    ColorSensor colorSensor; // declares the color sensor for detecting game pieces
    DigitalChannel greenLed, redLed; // declares digital channels for LED indicators

    final int RED_THRESHOLD = 150; // minimum red value to detect red game piece
    final int BLUE_THRESHOLD = 150; // minimum blue value to detect blue game piece
    boolean isRedAlliance = true; // tracks which alliance the robot is on

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        colorSensor = hardwareMap.get(ColorSensor.class, "sensor_color_distance"); // gets color sensor from hardware map
        greenLed = hardwareMap.get(DigitalChannel.class, "green_led"); // gets green LED from hardware map
        redLed = hardwareMap.get(DigitalChannel.class, "red_led"); // gets red LED from hardware map

        greenLed.setMode(DigitalChannel.Mode.OUTPUT); // sets green LED pin as output
        redLed.setMode(DigitalChannel.Mode.OUTPUT); // sets red LED pin as output

        telemetry.addLine("Press X to toggle alliance"); // displays instructions for alliance selection
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        if (gamepad1.x) { // checks if X button is pressed
            isRedAlliance = !isRedAlliance; // toggles between red and blue alliance
            try { Thread.sleep(200); } catch (InterruptedException e) {} // debounce delay to prevent rapid toggling
        }

        int red = colorSensor.red(); // reads red color intensity from sensor
        int blue = colorSensor.blue(); // reads blue color intensity from sensor

        boolean detected = isRedAlliance ? // checks if correct alliance color is detected
                (red > RED_THRESHOLD && red > blue) : // for red alliance: red must exceed threshold and be greater than blue
                (blue > BLUE_THRESHOLD && blue > red); // for blue alliance: blue must exceed threshold and be greater than red

        if (detected) { // if correct alliance color is detected
            redLed.setState(isRedAlliance); // turns on red LED if red alliance
            greenLed.setState(!isRedAlliance); // turns on green LED if blue alliance
        } else { // if no detection
            redLed.setState(false); // turns off red LED
            greenLed.setState(false); // turns off green LED
        }

        telemetry.addData("Alliance", isRedAlliance ? "RED" : "BLUE"); // displays current alliance
        telemetry.addData("Red", red); // displays red sensor value
        telemetry.addData("Blue", blue); // displays blue sensor value
        telemetry.addData("Detected", detected ? "YES!" : "No"); // displays detection status
    }
}
