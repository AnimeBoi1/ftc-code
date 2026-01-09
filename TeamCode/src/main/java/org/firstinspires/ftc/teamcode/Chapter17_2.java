package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Chapter 17 Exercise 2:
 * Add Javadoc comments to your TestMotor class.
 * (Because once you have TestWiring all working for your robot,
 * you'll want to show it to judges!)
 *
 * Example Javadoc for TestMotor:
 *
 * /**
 *  * Test class for testing a DcMotor.
 *  * Part of the TestWiring system that allows easy hardware verification.
 *  *
 *  * Usage:
 *  * <pre>
 *  * TestMotor test = new TestMotor("Drive Motor", 0.5, motor);
 *  * tests.add(test);
 *  * </pre>
 *  *
 *  * @author Your Team Name
 *  * @see TestItem
 *  * @see TestWiring
 *  * /
 *
 * Constructor Javadoc:
 * /**
 *  * Creates a new motor test.
 *  * @param description The name shown in TestWiring menu
 *  * @param speed The speed to run the motor (0.0 to 1.0)
 *  * @param motor The DcMotor to test
 *  * /
 *
 * This exercise is a documentation task - modify TestMotor.java
 */
@TeleOp(name = "Chapter 17_2", group = "Exercises")
public class Chapter17_2 extends OpMode {

    @Override
    public void init() {
        telemetry.addData("Exercise 17.2", "Add Javadoc to TestMotor");
        telemetry.addLine("");
        telemetry.addLine("Good Javadoc includes:");
        telemetry.addLine("- Class description");
        telemetry.addLine("- Usage examples with <pre> tags");
        telemetry.addLine("- @author tag");
        telemetry.addLine("- @see for related classes");
        telemetry.addLine("- @param for all parameters");
    }

    @Override
    public void loop() {
        telemetry.addLine("Well-documented code impresses judges!");
    }
}