package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

/**
 * Chapter 10 Exercise 2:
 * Make the motor stop when the distance sensor sees something closer
 * than 10cm and go at half speed when farther than that.
 */
@TeleOp(name = "Chapter 10_2", group = "Exercises")
public class Chapter10_2 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard();

    @Override
    public void init() {
        board.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loop() {
        double distance = board.getDistance(DistanceUnit.CM);

        // TODO: Implement the logic:
        // if distance < 10cm: stop motor (speed = 0)
        // else: half speed (speed = 0.5)

        telemetry.addData("Distance (cm)", distance);
    }
}