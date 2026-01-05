package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;
import org.firstinspires.ftc.teamcode.mechanisms.TestItem;

import java.util.ArrayList;

/**
 * Chapter 14 Exercise 2:
 * Add a test for the servo. You'll need a TestServo class - hint: your constructor
 * probably needs an "on" value and an "off" value for the servo. You'll also need
 * to add it to the getTests() method.
 *
 * This OpMode demonstrates the TestWiring pattern using polymorphism.
 * Use D-pad up/down to cycle through tests, A button to run the test.
 *
 * NOTE: To complete this exercise, you need to:
 * 1. Create TestServo class (already created)
 * 2. Add TestServo to the getTests() method in ProgrammingBoard
 */
@TeleOp(name = "Chapter 14_2", group = "Exercises")
@Disabled
public class Chapter14_2 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard();
    ArrayList<TestItem> tests = new ArrayList<>();
    boolean wasDown, wasUp;
    int testNum;

    @Override
    public void init() {
        board.init(hardwareMap);

        // TODO: Get tests from board.getTests() after implementing it
        // Should include TestServo with appropriate on/off positions

        telemetry.addData("Status", "Initialized");
        telemetry.addLine("Exercise: Add TestServo to getTests()");
        telemetry.addLine("Constructor: TestServo(desc, servo, offPos, onPos)");
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
            TestItem currTest = tests.get(testNum);
            telemetry.addData("Test", currTest.getDescription());
            currTest.run(gamepad1.a, telemetry);
        } else {
            telemetry.addLine("No tests available.");
            telemetry.addLine("Implement getTests() with TestServo");
        }
    }
}