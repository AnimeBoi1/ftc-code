package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation to mark this as driver-controlled

@TeleOp // marks this class as a TeleOp program visible on the Driver Station
public class Chapter5_1 extends OpMode { // defines our class extending OpMode for iterative execution
    RobotLocation_5_1 robotLocation = new RobotLocation_5_1(0); // creates a RobotLocation object starting at angle 0

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        robotLocation.setAngle(0); // resets the robot's angle to 0 degrees
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        if (gamepad1.a) { // checks if the A button is pressed on gamepad 1
            robotLocation.turn(0.1); // rotates the robot 0.1 degrees clockwise
        } else if (gamepad1.b) { // checks if the B button is pressed instead
            robotLocation.turn(-0.1); // rotates the robot 0.1 degrees counter-clockwise
        }
        telemetry.addData("Location", robotLocation); // displays the robotLocation object (calls toString)
        telemetry.addData("Heading", robotLocation.getHeading()); // displays heading normalized to -180 to 180
        telemetry.addData("Angle", robotLocation.getAngle()); // displays the raw cumulative angle
    }
}

class RobotLocation_5_1 { // helper class to track robot's rotational position
    double angle; // stores the cumulative rotation angle in degrees

    public RobotLocation_5_1(double angle) { // constructor that takes an initial angle
        this.angle = angle; // sets the instance variable to the provided angle
    }

    public double getHeading() { // returns angle normalized to -180 to 180 range
        double angle = this.angle; // creates a local copy of the angle to modify
        while (angle > 180) { // if angle is greater than 180 degrees
            angle -= 360; // subtract 360 to bring it into range
        }
        while (angle < -180) { // if angle is less than -180 degrees
            angle += 360; // add 360 to bring it into range
        }
        return angle; // returns the normalized heading
    }

    @Override // indicates we're overriding toString from Object class
    public String toString() { // converts the object to a string for display
        return "RobotLocation: angle (" + angle + ")"; // returns a formatted string with the angle
    }

    public void turn(double angleChange) { // adds rotation to the current angle
        angle += angleChange; // increments the angle by the specified amount
    }

    public void setAngle(double angle) { // sets the angle to a specific value
        this.angle = angle; // assigns the parameter value to the instance variable
    }

    public double getAngle() { // getter method to retrieve the raw angle
        return angle; // returns the cumulative angle (not normalized)
    }
}
