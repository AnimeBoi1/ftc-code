package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

@TeleOp(name = "Chapter 11_2", group = "Exercises")
public class Chapter11_2 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard(); // create programming board instance

    @Override
    public void init() {
        board.init(hardwareMap); // initialize hardware
        telemetry.addData("Status", "Initialized"); // show status
    }

    @Override
    public void loop() {
        double heading = board.getHeading(AngleUnit.DEGREES); // get heading (-180 to 180)
        double motorSpeed = heading / 180.0; // scale to motor range (-1.0 to 1.0)
        board.setMotorSpeed(motorSpeed); // motor speed follows heading

        telemetry.addData("Heading", heading); // show current heading
        telemetry.addData("Motor Speed", motorSpeed); // show motor speed
    }
}
