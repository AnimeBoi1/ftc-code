package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;
import org.firstinspires.ftc.teamcode.mechanisms.TestItem;

import java.util.ArrayList;

@TeleOp(name = "Chapter 14_1", group = "Exercises")
public class Chapter14_1 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard(); // create programming board instance
    ArrayList<TestItem> tests = new ArrayList<>(); // list of test items
    boolean wasDown, wasUp; // track previous button states
    int testNum; // current test index

    @Override
    public void init() {
        board.init(hardwareMap); // initialize hardware
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loop() {
        // move up in test list (with edge detection)
        if (gamepad1.dpad_up && !wasUp) {
            testNum--; // go to previous test
            if (testNum < 0) {
                testNum = Math.max(0, tests.size() - 1); // wrap to end
            }
        }
        wasUp = gamepad1.dpad_up; // remember button state

        // move down in test list (with edge detection)
        if (gamepad1.dpad_down && !wasDown) {
            testNum++; // go to next test
            if (testNum >= tests.size()) {
                testNum = 0; // wrap to beginning
            }
        }
        wasDown = gamepad1.dpad_down; // remember button state

        telemetry.addLine("D-pad up/down to select test");
        telemetry.addLine("Press A to run test");

        if (tests.size() > 0) {
            TestItem currTest = tests.get(testNum); // get current test
            telemetry.addData("Test", currTest.getDescription()); // show test name
            currTest.run(gamepad1.a, telemetry); // run if A pressed
        } else {
            telemetry.addLine("No tests available");
        }
    }
}
