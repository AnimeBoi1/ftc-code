package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Chapter 19 Exercise 2:
 * Add the final keyword to various places to cause compiler errors
 * so you can see what they look like.
 *
 * The 'final' keyword has different meanings depending on where it's used:
 *
 * 1. final variable - Cannot be reassigned after initialization
 *    final int x = 5;
 *    x = 10; // COMPILER ERROR!
 *
 * 2. final method - Cannot be overridden in subclasses
 *    public final void doSomething() { }
 *
 * 3. final class - Cannot be extended
 *    public final class MyClass { }
 *
 * 4. final parameter - Cannot be modified inside the method
 *    public void process(final int value) {
 *        value = 10; // COMPILER ERROR!
 *    }
 *
 * This exercise is about experimentation - try adding 'final' in your code!
 */
@TeleOp(name = "Chapter 19_2", group = "Exercises")
@Disabled
public class Chapter19_2 extends OpMode {

    // Example: final variable (constant)
    final double MAX_SPEED = 1.0;

    // Example: non-final variable (can be changed)
    double currentSpeed = 0.5;

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        telemetry.addLine("This exercise is about experimentation!");
        telemetry.addLine("");
        telemetry.addLine("Try adding 'final' to:");
        telemetry.addLine("- Variables");
        telemetry.addLine("- Method parameters");
        telemetry.addLine("- Methods");
        telemetry.addLine("- Classes");
    }

    @Override
    public void loop() {
        // This would cause a compiler error if MAX_SPEED was final:
        // MAX_SPEED = 2.0; // ERROR: Cannot assign to final variable

        // This is fine because currentSpeed is not final:
        currentSpeed = gamepad1.left_stick_y;

        telemetry.addData("MAX_SPEED (final)", MAX_SPEED);
        telemetry.addData("currentSpeed", "%.2f", currentSpeed);
        telemetry.addLine("");
        telemetry.addLine("Uncomment the line in code to see error");
    }

    // Example: final parameter
    public void exampleMethod(final double value) {
        // value = 10; // This would cause a compiler error!
        double result = value * 2; // This is fine - we're reading, not modifying
    }
}