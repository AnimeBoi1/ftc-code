package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

@TeleOp()
public class Chapter6_2 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard();

    @Override
    public void init() {
        board.init(hardwareMap);
    }

    @Override
    public void loop() {
        String touchSensorString = "Not Pressed";
        if (board.isTouchSensorPressed()) {
            touchSensorString = "Pressed";
        }
        telemetry.addData("Touch sensor", touchSensorString);
    }
}