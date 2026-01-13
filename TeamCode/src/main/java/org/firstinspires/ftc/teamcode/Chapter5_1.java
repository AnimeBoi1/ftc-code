package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class Chapter5_1 extends OpMode {
    RobotLocation_5_1 robotLocation = new RobotLocation_5_1(0);

    @Override
    public void init() {
        robotLocation.setAngle(0);
    }
    @Override
    public void loop() {
        if (gamepad1.a) {
            robotLocation.turn(0.1);
        } else if (gamepad1.b) {
            robotLocation.turn(-0.1);
        }
        telemetry.addData("Location", robotLocation);
        telemetry.addData("Heading", robotLocation.getHeading());
        telemetry.addData("Angle", robotLocation.getAngle());
    }
}

class RobotLocation_5_1 {
    double angle;

    public RobotLocation_5_1(double angle) {
        this.angle = angle;
    }

    public double getHeading() {
        double angle = this.angle;
        while (angle > 180) {
            angle -= 360;
        }
        while (angle < -180) {
            angle += 360;
        }
        return angle;
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
