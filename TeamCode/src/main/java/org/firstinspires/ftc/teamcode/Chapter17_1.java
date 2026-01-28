package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit; // imports AngleUnit for angle measurement

/**
 * Exercise 17.1: Demonstrates proper Javadoc commenting style.
 * This OpMode shows how to document a ProgrammingBoard-style class.
 *
 * @author Team 12345
 * @version 1.0
 */
@TeleOp() // marks this class as a TeleOp program visible on the Driver Station
public class Chapter17_1 extends OpMode { // defines our class extending OpMode for iterative execution

    /**
     * Example class demonstrating Javadoc on a mechanism class.
     * In real code, add this style of documentation to your ProgrammingBoard class.
     */
    static class DocumentedProgrammingBoard {
        /** The current heading offset in degrees. */
        private double headingOffset = 0;

        /**
         * Gets the current IMU heading adjusted by the offset.
         *
         * @param angleUnit the unit to return the angle in (DEGREES or RADIANS)
         * @return the current heading in the specified angle unit
         */
        public double getHeading(AngleUnit angleUnit) {
            double rawHeading = 45.0; // simulated IMU reading
            return angleUnit.fromDegrees(rawHeading - headingOffset); // applies offset and converts units
        }

        /**
         * Resets the heading offset so current position becomes zero.
         * Call this at the start of autonomous to establish a reference point.
         */
        public void resetHeading() {
            headingOffset = 45.0; // simulated: sets offset to current heading
        }

        /**
         * Checks if the touch sensor is currently pressed.
         *
         * @return true if pressed, false otherwise
         */
        public boolean isTouchSensorPressed() {
            return false; // simulated sensor reading
        }
    }

    DocumentedProgrammingBoard board = new DocumentedProgrammingBoard(); // creates instance of documented class

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        telemetry.addLine("Exercise 17.1: Javadoc on ProgrammingBoard"); // displays exercise title
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        telemetry.addLine("=== Javadoc Style Guide ==="); // section header
        telemetry.addLine("/** Class description */"); // shows class doc format
        telemetry.addLine("@param name - parameter description"); // shows param tag format
        telemetry.addLine("@return - what the method returns"); // shows return tag format
        telemetry.addLine(""); // blank line for spacing
        telemetry.addLine("Generate docs: Tools > Generate JavaDoc"); // shows how to generate documentation
        telemetry.addLine("Select Module 'TeamCode'"); // specific instructions for Android Studio

        telemetry.addData("Simulated Heading", "%.1f deg", board.getHeading(AngleUnit.DEGREES)); // shows method in use
    }
}
