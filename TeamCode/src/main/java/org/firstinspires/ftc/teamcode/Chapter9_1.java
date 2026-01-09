package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

@TeleOp(name = "Chapter 9_1", group = "Exercises")
public class Chapter9_1 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard(); // create programming board instance

    @Override
    public void init() {
        board.init(hardwareMap); // initialize hardware
        telemetry.addData("Status", "Initialized"); // show status
    }

    @Override
    public void loop() {
        telemetry.addData("Pot Voltage", board.getPotVoltage()); // show raw voltage
        telemetry.addData("Instructions", "Turn the potentiometer");
    }
}
