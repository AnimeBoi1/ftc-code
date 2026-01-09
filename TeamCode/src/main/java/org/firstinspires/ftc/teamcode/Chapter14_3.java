package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Chapter 14 Exercise 3:
 * Change ProgrammingBoard2 through ProgrammingBoard9 to derive from
 * the one before it (i.e., ProgrammingBoard2 extends ProgrammingBoard1)
 * adding only what is necessary each time. Make sure all your OpModes
 * still work!
 *
 * Hint: You'll have to change private members to protected so the child
 * can access them.
 *
 * NOTE: The reason the book didn't do this is that you would likely only
 * have the most recent version of a mechanism in your code instead of
 * multiple versions.
 *
 * This exercise is a refactoring task - no new OpMode is needed.
 * This file serves as documentation for the exercise requirements.
 *
 * Example inheritance chain:
 * ProgrammingBoard1 (base - touch sensor only)
 *   -> ProgrammingBoard2 extends ProgrammingBoard1 (adds motor)
 *      -> ProgrammingBoard3 extends ProgrammingBoard2 (adds servo)
 *         -> ProgrammingBoard4 extends ProgrammingBoard3 (adds pot)
 *            ... and so on
 *
 * Benefits of this approach:
 * - Code reuse through inheritance
 * - Each class only adds new functionality
 * - Changes to base class automatically apply to all derived classes
 *
 * Drawbacks:
 * - Deep inheritance hierarchies can be hard to maintain
 * - Coupling between classes increases
 */
@TeleOp(name = "Chapter 14_3", group = "Exercises")
public class Chapter14_3 extends OpMode {

    @Override
    public void init() {
        telemetry.addData("Exercise 14.3", "Inheritance Refactoring");
        telemetry.addLine("");
        telemetry.addLine("This is a refactoring exercise.");
        telemetry.addLine("Modify ProgrammingBoard classes to use inheritance.");
        telemetry.addLine("");
        telemetry.addLine("Steps:");
        telemetry.addLine("1. Change 'private' to 'protected' for members");
        telemetry.addLine("2. Make each board extend the previous one");
        telemetry.addLine("3. Call super.init(hwMap) in derived classes");
        telemetry.addLine("4. Only add new hardware in each class");
    }

    @Override
    public void loop() {
        telemetry.addLine("See source code comments for details.");
    }
}