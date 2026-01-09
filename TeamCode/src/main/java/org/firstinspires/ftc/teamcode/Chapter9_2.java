package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

@TeleOp(name = "Chapter 9_2", group = "Exercises")
public class Chapter9_2 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard(); // create programming board instance

    @Override
    public void init() {
        board.init(hardwareMap); // initialize hardware
        telemetry.addData("Status", "Initialized"); // show status
    }

    @Override
    public void loop() {
        double potVoltage = board.getPotVoltage(); // get pot voltage (0-3.3V typically)
        double potPosition = potVoltage / 3.3; // convert to 0.0-1.0 range
        board.setServoPosition(potPosition); // servo follows pot position

        telemetry.addData("Pot Position", potPosition); // show normalized position
        telemetry.addData("Instructions", "Turn pot to move servo");
    }
}
