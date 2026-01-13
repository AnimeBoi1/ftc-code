package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode
import com.qualcomm.robotcore.hardware.DcMotor; // imports the DcMotor class for motor control

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard; // imports the ProgrammingBoard helper class

@TeleOp() // marks this class as a TeleOp program visible on the Driver Station
public class Chapter7_1 extends OpMode { // defines our class extending OpMode for iterative execution
    ProgrammingBoard board = new ProgrammingBoard(); // creates an instance of the ProgrammingBoard hardware abstraction

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        board.init(hardwareMap); // initializes all hardware devices using the robot's hardware map
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        double motorSpeed = gamepad1.left_stick_y; // reads the left joystick Y value as motor speed (-1 to 1)

        board.setMotorSpeed(motorSpeed); // sets the motor to the joystick-controlled speed
        telemetry.addData("speed", motorSpeed); // displays the current motor speed on Driver Station
        if (gamepad1.a) { // checks if the A button is pressed
            board.setMotorZeroBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // sets motor to brake mode (holds position when stopped)
            telemetry.addData("Zero", "Brake"); // displays that brake mode is active
        } else if (gamepad1.b) { // checks if the B button is pressed instead
            board.setMotorZeroBehavior(DcMotor.ZeroPowerBehavior.FLOAT); // sets motor to float mode (coasts when stopped)
            telemetry.addData("Zero", "Float"); // displays that float mode is active
        }
    }
}
