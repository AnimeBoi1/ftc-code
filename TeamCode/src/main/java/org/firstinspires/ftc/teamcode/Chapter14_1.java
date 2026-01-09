package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;
import org.firstinspires.ftc.teamcode.mechanisms.TestItem;

import java.util.ArrayList;

/**
 * Chapter 14 Exercise 1:
 * Add a test for the touchSensor. You'll need a TestDigitalChannel class
 * and add it to the getTests() method in ProgrammingBoard.
 *
 * This OpMode demonstrates the TestWiring pattern using polymorphism.
 * Use D-pad up/down to cycle through tests, A button to run the test.
 *
 * NOTE: To complete this exercise, you need to:
 * 1. Create TestDigitalChannel class (already created)
 * 2. Modify ProgrammingBoard to have a getTests() method that returns
 *    an ArrayList<TestItem> including the TestDigitalChannel
 */
@TeleOp(name = "Chapter 14_1", group = "Exercises")
public class Chapter14_1 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard();
    ArrayList<TestItem> tests = new ArrayList<>();
    boolean wasDown, wasUp;
    int testNum;

    @Override
    public void init() {
        board.init(hardwareMap);

        // TODO: Ideally, get tests from board.getTests() after implementing it
        // For now, we demonstrate the pattern with inline test creation
        // To complete exercise: add getTests() method to ProgrammingBoard

        telemetry.addData("Status", "Initialized");
        telemetry.addLine("Exercise: Add getTests() to ProgrammingBoard");
        telemetry.addLine("that includes TestDigitalChannel for touch sensor");
    }

    @Override
    public void loop() {
        // Move up in the list of tests
        if (gamepad1.dpad_up && !wasUp) {
            testNum--;
            if (testNum < 0) {
                testNum = Math.max(0, tests.size() - 1);
            }
        }
        wasUp = gamepad1.dpad_up;

        // Move down in the list of tests
        if (gamepad1.dpad_down && !wasDown) {
            testNum++;
            if (testNum >= tests.size()) {
                testNum = 0;
            }
        }
        wasDown = gamepad1.dpad_down;

        // Put instructions on the telemetry
        telemetry.addLine("Use Up and Down on D-pad to cycle through choices");
        telemetry.addLine("Press A to run test");

        if (tests.size() > 0) {
            // Put the test on the telemetry
            TestItem currTest = tests.get(testNum);
            telemetry.addData("Test", currTest.getDescription());
            // Run or don't run based on A button
            currTest.run(gamepad1.a, telemetry);
        } else {
            telemetry.addLine("No tests available.");
            telemetry.addLine("Implement getTests() in ProgrammingBoard");
        }
    }
}