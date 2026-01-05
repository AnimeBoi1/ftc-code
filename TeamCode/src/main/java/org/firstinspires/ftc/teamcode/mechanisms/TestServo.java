package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Chapter 14 Exercise 2:
 * Test class for testing a Servo.
 * When active, moves servo to "on" position; otherwise moves to "off" position.
 */
public class TestServo extends TestItem {
    private Servo servo;
    private double onPosition;
    private double offPosition;

    public TestServo(String description, Servo servo, double offPosition, double onPosition) {
        super(description);
        this.servo = servo;
        this.offPosition = offPosition;
        this.onPosition = onPosition;
    }

    @Override
    public void run(boolean on, Telemetry telemetry) {
        if (on) {
            servo.setPosition(onPosition);
            telemetry.addData("Servo", "ON position (%.2f)", onPosition);
        } else {
            servo.setPosition(offPosition);
            telemetry.addData("Servo", "OFF position (%.2f)", offPosition);
        }
        telemetry.addData("Current Position", "%.2f", servo.getPosition());
    }
}