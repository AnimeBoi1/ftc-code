package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

/**
 * Chapter 9 Exercise 2:
 * Make an OpMode that sets the servo to the position that the pot
 * is returning. Turn the pot and it will cause the servo to "follow" it.
 *
 * Prerequisites: Complete Exercise 9.1 first (getPotPosition method)
 */
@TeleOp(name = "Chapter 9_2", group = "Exercises")
@Disabled
public class Chapter9_2 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard();

    @Override
    public void init() {
        board.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loop() {
        // TODO: Get pot position and set servo to that position
        // double potPosition = board.getPotPosition();
        // board.setServoPosition(potPosition);

        telemetry.addData("Instructions", "Turn pot to move servo");
        // telemetry.addData("Pot Position", potPosition);
    }
}