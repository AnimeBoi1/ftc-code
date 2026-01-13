package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode

@TeleOp // marks this class as a TeleOp program visible on the Driver Station
public class Chapter5_2 extends OpMode { // defines our class extending OpMode for iterative execution
    RobotLocation_5_2 robotLocation = new RobotLocation_5_2(0); // creates a RobotLocation object starting at angle 0

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        robotLocation.setAngle(0); // resets the robot's angle to 0 degrees
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        if (gamepad1.a) { // checks if the A button is pressed
            robotLocation.turn(0.1); // rotates the robot 0.1 degrees clockwise
        } else if (gamepad1.b) { // checks if the B button is pressed instead
            robotLocation.turn(-0.1); // rotates the robot 0.1 degrees counter-clockwise
        }
        if (gamepad1.dpad_left) { // checks if the left D-pad is pressed
            robotLocation.changeX(-0.1); // moves the robot 0.1 units left (negative X)
        } else if (gamepad1.dpad_right) { // checks if the right D-pad is pressed
            robotLocation.changeX(0.1); // moves the robot 0.1 units right (positive X)
        }
        telemetry.addData("Location", robotLocation); // displays the robotLocation object (calls toString)
        telemetry.addData("Heading", robotLocation.getHeading()); // displays heading normalized to -180 to 180
    }
}

class RobotLocation_5_2 { // helper class to track robot's position and rotation
    double angle; // stores the cumulative rotation angle in degrees
    double x; // stores the robot's X position

    public RobotLocation_5_2(double angle) { // constructor that takes an initial angle
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
        return "RobotLocation: angle (" + angle + ") x (" + x + ")"; // returns formatted string with angle and x position
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

    public double getX() { // getter method to retrieve the X position
        return x; // returns the current X position
    }

    public void changeX(double change) { // modifies the X position by a delta
        x += change; // adds the change value to the current X position
    }

    public void setX(double x) { // sets the X position to a specific value
        this.x = x; // assigns the parameter value to the instance variable
    }
}
