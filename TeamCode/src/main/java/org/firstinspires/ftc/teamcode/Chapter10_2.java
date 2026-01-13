package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

@TeleOp()
public class Chapter10_2 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard();

    @Override
    public void init() {
        board.init(hardwareMap);
    }

    @Override
    public void loop() {
        double distanceCM = board.getDistance(DistanceUnit.CM);

        if (distanceCM < 10.0) {
            board.setMotorSpeed(0.0);
        } else {
            board.setMotorSpeed(0.5);
        }
        telemetry.addData("Distance (CM)", distanceCM);
    }
}
