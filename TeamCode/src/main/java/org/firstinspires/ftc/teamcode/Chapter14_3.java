package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode
import com.qualcomm.robotcore.hardware.DcMotor; // imports DcMotor class for motor control
import com.qualcomm.robotcore.hardware.DigitalChannel; // imports DigitalChannel for touch sensor
import com.qualcomm.robotcore.hardware.HardwareMap; // imports HardwareMap for hardware access
import com.qualcomm.robotcore.hardware.Servo; // imports Servo class for servo control
import com.qualcomm.robotcore.hardware.AnalogInput; // imports AnalogInput for potentiometer

/**
 * Exercise 14.3: Demonstrates the inheritance chain pattern.
 * Each ProgrammingBoard level extends the previous one, using protected fields
 * and super.init() to chain initialization.
 */
@TeleOp() // marks this class as a TeleOp program visible on the Driver Station
public class Chapter14_3 extends OpMode { // defines our class extending OpMode for iterative execution

    // Level 1: Base class with touch sensor only
    static class ProgrammingBoard1 { // base class with touch sensor functionality
        protected DigitalChannel touchSensor; // protected so children can access

        public void init(HardwareMap hwMap) { // initializes touch sensor hardware
            touchSensor = hwMap.get(DigitalChannel.class, "touch_sensor");
            touchSensor.setMode(DigitalChannel.Mode.INPUT);
        }

        public boolean isTouchSensorPressed() { // returns whether the touch sensor is pressed
            return !touchSensor.getState();
        }
    }

    // Level 2: Adds isTouchSensorReleased, extends Level 1
    static class ProgrammingBoard2 extends ProgrammingBoard1 { // inherits touch sensor from parent
        public boolean isTouchSensorReleased() { // adds the inverse check method
            return touchSensor.getState(); // can access touchSensor because it's protected
        }
    }

    // Level 3: Adds motor, extends Level 2
    static class ProgrammingBoard3 extends ProgrammingBoard2 { // inherits touch sensor methods
        protected DcMotor motor; // protected so children can access

        @Override // overrides parent's init to add motor initialization
        public void init(HardwareMap hwMap) {
            super.init(hwMap); // calls parent's init first to set up touch sensor
            motor = hwMap.get(DcMotor.class, "motor");
            motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }

        public void setMotorSpeed(double speed) { // sets the motor power
            motor.setPower(speed);
        }
    }

    // Level 4: Adds encoder support, extends Level 3
    static class ProgrammingBoard4 extends ProgrammingBoard3 { // inherits motor from parent
        private double ticksPerRotation; // private since no child needs this

        @Override // overrides to add encoder tick calculation
        public void init(HardwareMap hwMap) {
            super.init(hwMap); // calls parent's init to set up touch sensor + motor
            ticksPerRotation = motor.getMotorType().getTicksPerRev();
        }

        public double getMotorRotations() { // returns motor position in rotations
            return motor.getCurrentPosition() / ticksPerRotation;
        }
    }

    // Level 5: Adds servo, extends Level 4
    static class ProgrammingBoard5 extends ProgrammingBoard4 { // inherits all previous hardware
        protected Servo servo; // protected so children can access

        @Override // overrides to add servo initialization
        public void init(HardwareMap hwMap) {
            super.init(hwMap); // chains up through all parent inits
            servo = hwMap.get(Servo.class, "servo");
        }

        public void setServoPosition(double position) { // sets the servo position
            servo.setPosition(position);
        }
    }

    // Level 6: Adds potentiometer, extends Level 5
    static class ProgrammingBoard6 extends ProgrammingBoard5 { // inherits all previous hardware
        protected AnalogInput pot; // protected for potential children

        @Override // overrides to add pot initialization
        public void init(HardwareMap hwMap) {
            super.init(hwMap); // chains up through all parent inits
            pot = hwMap.get(AnalogInput.class, "pot");
        }

        public double getPotAngle() { // returns pot angle in degrees (0-270)
            return (pot.getVoltage() / pot.getMaxVoltage()) * 270.0;
        }
    }

    ProgrammingBoard6 board = new ProgrammingBoard6(); // uses the most derived class

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        board.init(hardwareMap); // one init() call chains through all levels via super.init()
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        telemetry.addData("Touch Pressed", board.isTouchSensorPressed()); // from Level 1
        telemetry.addData("Touch Released", board.isTouchSensorReleased()); // from Level 2
        double speed = gamepad1.left_stick_y; // reads joystick for motor speed
        board.setMotorSpeed(speed); // from Level 3
        telemetry.addData("Motor Speed", speed);
        telemetry.addData("Motor Rotations", board.getMotorRotations()); // from Level 4
        board.setServoPosition(gamepad1.left_trigger); // from Level 5
        telemetry.addData("Servo Pos", gamepad1.left_trigger);
        telemetry.addData("Pot Angle", board.getPotAngle()); // from Level 6
    }
}
