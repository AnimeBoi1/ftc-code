package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode

/**
 * Exercise 17.2: Demonstrates Javadoc on a TestMotor class.
 * Good documentation helps judges understand your code and impresses them!
 */
@TeleOp() // marks this class as a TeleOp program visible on the Driver Station
public class Chapter17_2 extends OpMode { // defines our class extending OpMode for iterative execution

    /**
     * Interface for testable hardware items.
     * Implement this to create wiring tests for any hardware component.
     */
    interface TestItem {
        /**
         * Gets the name of this test item for display.
         * @return the human-readable name of this test
         */
        String getName();

        /**
         * Runs one iteration of the test.
         * @param on true if the test should activate hardware, false to deactivate
         */
        void run(boolean on);
    }

    /**
     * Test class for verifying motor wiring and functionality.
     * Creates a simple on/off test that runs the motor at half speed.
     *
     * <p>Example usage:</p>
     * <pre>
     * TestMotor test = new TestMotor("left_motor", hardwareMap);
     * test.run(true);  // Motor runs at 0.5 speed
     * test.run(false); // Motor stops
     * </pre>
     *
     * @author Team 12345
     * @see TestItem
     */
    static class DocumentedTestMotor implements TestItem {
        /** The name of the motor being tested. */
        private final String motorName;

        /** Speed to run during test (0.0 to 1.0). */
        private static final double TEST_SPEED = 0.5;

        /**
         * Creates a new TestMotor for the specified motor.
         *
         * @param motorName the name of the motor in the hardware configuration
         */
        public DocumentedTestMotor(String motorName) {
            this.motorName = motorName; // stores the motor name for later use
        }

        /**
         * {@inheritDoc}
         * Returns the motor name for identification in the test menu.
         */
        @Override
        public String getName() {
            return "Motor: " + motorName; // returns formatted name for display
        }

        /**
         * {@inheritDoc}
         * When on, runs motor at {@link #TEST_SPEED}. When off, stops motor.
         */
        @Override
        public void run(boolean on) {
            double power = on ? TEST_SPEED : 0.0; // selects power based on on/off state
            // In real code: motor.setPower(power);
        }
    }

    DocumentedTestMotor testMotor = new DocumentedTestMotor("motor"); // creates instance for demonstration

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        telemetry.addLine("Exercise 17.2: Javadoc on TestMotor"); // displays exercise title
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        telemetry.addLine("=== TestMotor Javadoc Demo ==="); // section header
        telemetry.addData("Test Name", testMotor.getName()); // shows the test item's name

        telemetry.addLine(""); // blank line for spacing
        telemetry.addLine("Important Javadoc tags:"); // explains key tags
        telemetry.addLine("@see - links to related classes"); // describes @see tag
        telemetry.addLine("@author - credits the author"); // describes @author tag
        telemetry.addLine("{@inheritDoc} - copies parent docs"); // describes inheritDoc tag
        telemetry.addLine("{@link #method} - links to method"); // describes link tag

        telemetry.addLine(""); // blank line for spacing
        telemetry.addLine("Good docs impress judges!"); // motivational message about documentation value
    }
}
