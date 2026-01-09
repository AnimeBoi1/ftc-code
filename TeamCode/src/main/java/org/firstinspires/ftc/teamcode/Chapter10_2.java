package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

@TeleOp(name = "Chapter 10_2", group = "Exercises")
public class Chapter10_2 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard(); // create programming board instance

    @Override
    public void init() {
        board.init(hardwareMap); // initialize hardware
        telemetry.addData("Status", "Initialized"); // show status
    }

    @Override
    public void loop() {
        double distance = board.getDistance(DistanceUnit.CM); // get distance in centimeters

        // stop motor if object closer than 10cm, otherwise half speed
        if (distance < 10.0) {
            board.setMotorSpeed(0.0); // stop motor
        } else {
            board.setMotorSpeed(0.5); // run at half speed
        }

        telemetry.addData("Distance (cm)", distance); // show distance reading
    }
}
