package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous()
public class Chapter21_1 extends OpMode {
    double robotX = 0;
    double robotY = 0;
    double robotHeading = 0;

    @Override
    public void init() {
    }

    @Override
    public void loop() {
        telemetry.addData("Robot X", "%.2f", robotX);
        telemetry.addData("Robot Y", "%.2f", robotY);
        telemetry.addData("Heading", "%.2f", robotHeading);
        telemetry.addLine("Implement OTOS + AprilTag fusion");
    }
}
