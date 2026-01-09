package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

/**
 * Chapter 9 Exercise 1:
 * Make a class method for your ProgrammingBoard that exposes the pot
 * in the range [0.0..1.0]
 *
 * Steps:
 * 1. Add a getPotPosition() method to ProgrammingBoard
 * 2. The pot returns voltage (typically 0-3.3V)
 * 3. Divide by the max voltage to get 0.0-1.0 range
 *    Hint: pot.getMaxVoltage() gives you the max voltage
 */
@TeleOp(name = "Chapter 9_1", group = "Exercises")
public class Chapter9_1 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard();

    @Override
    public void init() {
        board.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loop() {
        telemetry.addData("Pot Voltage", board.getPotVoltage());
        // TODO: After implementing getPotPosition(), uncomment:
        // telemetry.addData("Pot Position", board.getPotPosition());
        telemetry.addData("Instructions", "Turn the potentiometer");
    }
}