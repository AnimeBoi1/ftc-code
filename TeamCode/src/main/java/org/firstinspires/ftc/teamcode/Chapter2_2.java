// File: `TeamCode/src/main/java/org/firstinspires/ftc/teamcode/Chapter2_2.java`
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Chapter 2_2")
public class Chapter2_2 extends OpMode {

    @Override
    public void init() {
        String myName = "Mayank";
        int grade = 12;

        telemetry.addData("Hello", myName);
        telemetry.addData("Grade", grade);
        telemetry.update();
    }

    @Override
    public void loop() {
        // exercise loop code
    }
}