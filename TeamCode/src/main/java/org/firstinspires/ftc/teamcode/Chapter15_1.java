package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

@TeleOp()
public class Chapter15_1 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard();
    boolean wasPressed = false;

    @Override
    public void init() {
        board.init(hardwareMap);
    }

    @Override
    public void loop() {
        boolean isPressed = board.isTouchSensorPressed();

        if (isPressed && !wasPressed) {
            gamepad1.rumble(500);
        }

        wasPressed = isPressed;

        telemetry.addData("Touch Sensor", isPressed ? "PRESSED" : "Released");
    }
}
