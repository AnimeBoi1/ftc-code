package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Chapter 22 Exercise 1:
 * If you have either the Sparkfun LED stick or the Blinkin, go add colored
 * LEDs to your robot that go along with your team's brand.
 *
 * This exercise does not have a solution in the appendix - it's about
 * personalizing your robot!
 *
 * Options covered in Chapter 22:
 * 1. REV Digital LED Indicator - Simple red/green LED
 * 2. Sparkfun QWIIC LED Stick - 10 RGB LEDs, I2C controlled
 * 3. REV Blinkin - Controls addressable LED strips, many patterns
 *
 * Ideas for team branding:
 * - Set LEDs to your team colors
 * - Create patterns that match your team logo
 * - Use colors to indicate robot state (initialized, running, error)
 * - Flash LEDs during endgame for excitement
 */
@TeleOp(name = "Chapter 22_1", group = "Exercises")
@Disabled
public class Chapter22_1 extends OpMode {

    // Example with REV Blinkin:
    // private Servo blinkin;
    // final double TEAM_COLOR_1 = 0.61;  // Example: Blue
    // final double TEAM_COLOR_2 = 0.77;  // Example: Green

    // Example with Sparkfun LED Stick:
    // private SparkFunLEDStick ledStick;

    @Override
    public void init() {
        // Initialize your LED hardware here
        // blinkin = hardwareMap.get(Servo.class, "blinkin");
        // ledStick = hardwareMap.get(SparkFunLEDStick.class, "ledStick");

        telemetry.addData("Status", "Initialized");
        telemetry.addLine("Add LEDs that match your team brand!");
    }

    @Override
    public void loop() {
        // Example: Cycle between team colors with button press
        // if (gamepad1.a) {
        //     blinkin.setPosition(TEAM_COLOR_1);
        // } else if (gamepad1.b) {
        //     blinkin.setPosition(TEAM_COLOR_2);
        // }

        // Example with LED Stick: Set all LEDs to team color
        // int teamRed = 255;
        // int teamGreen = 165;
        // int teamBlue = 0;  // Orange
        // for (int i = 0; i < 10; i++) {
        //     ledStick.setLEDColor(i, teamRed, teamGreen, teamBlue);
        // }

        telemetry.addLine("LED Branding Exercise");
        telemetry.addLine("");
        telemetry.addLine("Choose your hardware:");
        telemetry.addLine("1. REV Blinkin (servo patterns)");
        telemetry.addLine("2. Sparkfun LED Stick (RGB control)");
        telemetry.addLine("3. REV Digital LED (simple red/green)");
        telemetry.addLine("");
        telemetry.addLine("Make it match your team identity!");
    }
}