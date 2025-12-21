package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Chapter 5_1")
public class Chapter5_1 extends OpMode {
    private RobotLocation_5_1 location;

    @Override
    public void init() {
        location = new RobotLocation_5_1(0);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
    }

    @Override
    public void loop() {
        // Use left stick X to turn the robot a few degrees per loop for demonstration.
        double turnInput = -gamepad1.left_stick_x * 5.0; // degrees per loop
        if (Math.abs(turnInput) > 1e-6) {
            location.turn(turnInput);
        }

        telemetry.addData("Raw angle", location.getAngle());
        telemetry.addData("Normalized heading", location.getHeading());
        telemetry.update();
    }
}

/* Package-private helper class kept in the same file so only one public class is present. */
class RobotLocation_5_1 {
    private double angle;

    public RobotLocation_5_1(double angle) {
        this.angle = angle;
    }

    public double getHeading() {
        double a = this.angle;
        while (a > 180) {
            a -= 360;
        }
        while (a < -180) {
            a += 360;
        }
        return a;
    }

    @Override
    public String toString() {
        return "RobotLocation: angle (" + angle + ")";
    }

    public void turn(double angleChange) {
        angle += angleChange;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getAngle() {
        return angle;
    }
}