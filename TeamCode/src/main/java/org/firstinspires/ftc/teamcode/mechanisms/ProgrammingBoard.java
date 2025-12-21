package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

/**
 * ProgrammingBoard class for Learn Java for FTC exercises.
 * This class encapsulates hardware access for the programming board.
 */
public class ProgrammingBoard {
    // Hardware devices
    private DigitalChannel touchSensor;
    private DcMotor motor;
    private Servo servo;
    private AnalogInput pot;
    private ColorSensor colorSensor;
    private DistanceSensor distanceSensor;
    private IMU imu;

    private double ticksPerRotation;

    public void init(HardwareMap hwMap) {
        // Touch sensor (Chapter 6)
        touchSensor = hwMap.get(DigitalChannel.class, "touch_sensor");
        touchSensor.setMode(DigitalChannel.Mode.INPUT);

        // Motor (Chapter 7)
        motor = hwMap.get(DcMotor.class, "motor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ticksPerRotation = motor.getMotorType().getTicksPerRev();

        // Servo (Chapter 8)
        servo = hwMap.get(Servo.class, "servo");

        // Potentiometer (Chapter 9)
        pot = hwMap.get(AnalogInput.class, "pot");

        // Color/Distance sensor (Chapter 10)
        colorSensor = hwMap.get(ColorSensor.class, "sensor_color_distance");
        distanceSensor = hwMap.get(DistanceSensor.class, "sensor_color_distance");

        // IMU (Chapter 11)
        imu = hwMap.get(IMU.class, "imu");
        imu.initialize(new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD)));
    }

    // Chapter 6: Touch Sensor methods
    public boolean isTouchSensorPressed() {
        return !touchSensor.getState();
    }

    // TODO: Exercise 6.1 - Add isTouchSensorReleased() method

    // Chapter 7: Motor methods
    public void setMotorSpeed(double speed) {
        motor.setPower(speed);
    }

    public double getMotorRotations() {
        return motor.getCurrentPosition() / ticksPerRotation;
    }

    // TODO: Exercise 7.1 - Add setZeroPowerBehavior() method

    // Chapter 8: Servo methods
    public void setServoPosition(double position) {
        servo.setPosition(position);
    }

    // Chapter 9: Potentiometer methods
    public double getPotVoltage() {
        return pot.getVoltage();
    }

    // TODO: Exercise 9.1 - Add getPotPosition() method that returns [0.0..1.0]

    // Chapter 10: Color/Distance methods
    public int getAmountRed() {
        return colorSensor.red();
    }

    public int getAmountGreen() {
        return colorSensor.green();
    }

    // TODO: Exercise 10.1 - Add getAmountBlue() method

    public double getDistance(DistanceUnit unit) {
        return distanceSensor.getDistance(unit);
    }

    // Chapter 11: IMU methods
    public double getHeading(AngleUnit unit) {
        return imu.getRobotYawPitchRollAngles().getYaw(unit);
    }

    public void resetHeading() {
        imu.resetYaw();
    }
}