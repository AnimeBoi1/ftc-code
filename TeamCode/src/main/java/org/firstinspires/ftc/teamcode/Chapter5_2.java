// File: `TeamCode/src/main/java/org/firstinspires/ftc/teamcode/Chapter5_2.java`
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Chapter 5_2")
public class Chapter5_2 extends OpMode {
    private RobotLocation_5_2 location;

    @Override
    public void init() {
        location = new RobotLocation_5_2(0.0, 0.0);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
    }

    @Override
    public void loop() {
        // Turn with left stick X (degrees per loop), adjust X with right stick X.
        double turnInput = -gamepad1.left_stick_x * 5.0; // degrees per loop
        double xChange = gamepad1.right_stick_x * 0.1;   // units per loop

        if (Math.abs(turnInput) > 1e-6) {
            location.turn(turnInput);
        }
        if (Math.abs(xChange) > 1e-6) {
            location.changeX(xChange);
        }

        telemetry.addData("Raw angle", location.getAngle());
        telemetry.addData("Normalized heading", location.getHeading());
        telemetry.addData("X position", location.getX());
        telemetry.update();
    }
}

/* Package-private helper kept in the same file */
class RobotLocation_5_2 {
    private double angle;
    private double x;

    public RobotLocation_5_2(double angle, double x) {
        this.angle = angle;
        this.x = x;
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
