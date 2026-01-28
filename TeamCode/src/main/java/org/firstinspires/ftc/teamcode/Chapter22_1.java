package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode

/**
 * Exercise 22.1: Add LEDs matching your team brand!
 *
 * Note: This exercise does NOT have a provided solution (per the PDF).
 * Each team should customize LEDs to match their unique branding.
 *
 * Hardware options:
 * - REV Blinkin LED Driver (RevBlinkinLedDriver class)
 * - Sparkfun QWIIC LED Stick (SparkFunLEDStick class)
 * - REV Digital LED Indicator (LED class)
 */
@TeleOp() // marks this class as a TeleOp program visible on the Driver Station
public class Chapter22_1 extends OpMode { // defines our class extending OpMode for iterative execution

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        telemetry.addLine("Exercise 22.1: LED Team Branding"); // displays exercise title
        telemetry.addLine("(No solution provided - customize for YOUR team!)"); // notes no standard solution
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        telemetry.addLine("=== LED Hardware Options ==="); // section header
        telemetry.addLine(""); // blank line for spacing

        telemetry.addLine("1. REV Blinkin LED Driver"); // option 1
        telemetry.addLine("   - RevBlinkinLedDriver class"); // class to use
        telemetry.addLine("   - 100+ built-in patterns"); // feature highlight
        telemetry.addLine("   - .setPattern(BlinkinPattern.XXX)"); // method hint
        telemetry.addLine(""); // blank line for spacing

        telemetry.addLine("2. Sparkfun QWIIC LED Stick"); // option 2
        telemetry.addLine("   - SparkFunLEDStick class"); // class to use
        telemetry.addLine("   - 10 individually addressable LEDs"); // feature highlight
        telemetry.addLine("   - .setColor(Color.XXX)"); // method hint
        telemetry.addLine(""); // blank line for spacing

        telemetry.addLine("3. REV Digital LED Indicator"); // option 3
        telemetry.addLine("   - LED class (red + green = yellow)"); // class to use
        telemetry.addLine("   - Simple .on() and .off()"); // method hint
        telemetry.addLine(""); // blank line for spacing

        telemetry.addLine("=== Ideas ==="); // section header for suggestions
        telemetry.addLine("- Team colors during teleop"); // idea 1
        telemetry.addLine("- Flash when game element detected"); // idea 2
        telemetry.addLine("- Rainbow during celebration"); // idea 3
        telemetry.addLine("- Alliance color indicator"); // idea 4
    }
}
