package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

@TeleOp()
public class Chapter7_2 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard();

    @Override
    public void init() {
        board.init(hardwareMap);
    }

    double squareInputWithSign(double input) {
        double output = input * input;
        if (input < 0) {
            output = output * -1;
        }
        return output;
    }

    @Override
    public void loop() {
        double motorSpeed = squareInputWithSign(gamepad1.left_stick_y);

        board.setMotorSpeed(motorSpeed);
    }
}
