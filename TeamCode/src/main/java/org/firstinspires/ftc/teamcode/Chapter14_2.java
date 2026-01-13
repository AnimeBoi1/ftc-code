package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;
import org.firstinspires.ftc.teamcode.mechanisms.TestItem;

import java.util.ArrayList;

@TeleOp()
public class Chapter14_2 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard();
    ArrayList<TestItem> tests = new ArrayList<>();
    boolean wasDown, wasUp;
    int testNum;

    @Override
    public void init() {
        board.init(hardwareMap);
    }

    @Override
    public void loop() {
        if (gamepad1.dpad_up && !wasUp) {
            testNum--;
            if (testNum < 0) {
                testNum = Math.max(0, tests.size() - 1);
            }
        }
        wasUp = gamepad1.dpad_up;

        if (gamepad1.dpad_down && !wasDown) {
            testNum++;
            if (testNum >= tests.size()) {
                testNum = 0;
            }
        }
        wasDown = gamepad1.dpad_down;

        if (tests.size() > 0) {
            TestItem currTest = tests.get(testNum);
            telemetry.addData("Test", currTest.getDescription());
            currTest.run(gamepad1.a, telemetry);
        }
    }
}
