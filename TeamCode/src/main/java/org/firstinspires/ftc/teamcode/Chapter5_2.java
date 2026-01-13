package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class Chapter5_2 extends OpMode {
    RobotLocation_5_2 robotLocation = new RobotLocation_5_2(0);

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
        if (gamepad1.dpad_left) {
            robotLocation.changeX(-0.1);
        } else if (gamepad1.dpad_right) {
            robotLocation.changeX(0.1);
        }
        telemetry.addData("Location", robotLocation);
        telemetry.addData("Heading", robotLocation.getHeading());
    }
}

class RobotLocation_5_2 {
    double angle;
    double x;

    public RobotLocation_5_2(double angle) {
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
        return "RobotLocation: angle (" + angle + ") x (" + x + ")";
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

    public double getX() {
        return x;
    }

    public void changeX(double change) {
        x += change;
    }

    public void setX(double x) {
        this.x = x;
    }
}
