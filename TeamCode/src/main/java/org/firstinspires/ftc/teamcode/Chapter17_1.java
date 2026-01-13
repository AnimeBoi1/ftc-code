package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp()
public class Chapter17_1 extends OpMode {

    @Override
    public void init() {
        telemetry.addData("Exercise 17.1", "Add Javadoc");
    }

    @Override
    public void loop() {
        telemetry.addLine("Generate docs: ./gradlew javadoc");
    }
}
