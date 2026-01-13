package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

@Autonomous()
public class Chapter16_1 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard();

    final double SERVO_LEFT = 0.0;
    final double SERVO_MIDDLE = 0.5;
    final double SERVO_RIGHT = 1.0;

    @Override
    public void init() {
        board.init(hardwareMap);
    }

    @Override
    public void init_loop() {
    }

    @Override
    public void start() {
    }

    @Override
    public void loop() {
        telemetry.addLine("Vision exercise - detect TSE position");
    }
}
