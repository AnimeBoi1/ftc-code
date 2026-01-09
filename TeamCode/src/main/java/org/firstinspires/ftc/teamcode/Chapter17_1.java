package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Chapter 17 Exercise 1:
 * Add Javadoc comments to your ProgrammingBoard class.
 *
 * Javadoc is a special type of comment that generates documentation.
 * It starts with /** and ends with * /
 *
 * Example Javadoc for a class:
 * /**
 *  * A class that manages the programming board hardware.
 *  * This includes sensors, motors, and servos for training exercises.
 *  * /
 *
 * Example Javadoc for a method:
 * /**
 *  * Gets the current heading from the IMU.
 *  * @param unit The angle unit to return (DEGREES or RADIANS)
 *  * @return The current heading in the specified unit
 *  * /
 *
 * Benefits of Javadoc:
 * 1. Android Studio shows help when using your classes
 * 2. Can generate HTML documentation with: ./gradlew javadoc
 * 3. Impresses judges when you show professional documentation!
 *
 * This exercise is a documentation task - modify ProgrammingBoard.java
 */
@TeleOp(name = "Chapter 17_1", group = "Exercises")
public class Chapter17_1 extends OpMode {

    @Override
    public void init() {
        telemetry.addData("Exercise 17.1", "Add Javadoc to ProgrammingBoard");
        telemetry.addLine("");
        telemetry.addLine("Javadoc comment format:");
        telemetry.addLine("/** Description here */");
        telemetry.addLine("");
        telemetry.addLine("Tags to use:");
        telemetry.addLine("@param - describe parameters");
        telemetry.addLine("@return - describe return value");
    }

    @Override
    public void loop() {
        telemetry.addLine("Generate docs: ./gradlew javadoc");
    }
}