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

import java.util.ArrayList;

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

    /**
     * Initializes all hardware on the programming board.
     * @param hwMap the hardware map from the opMode
     */
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

    /**
     * @return whether the touch sensor is pressed or not
     */
    public boolean isTouchSensorPressed() {
        return !touchSensor.getState();
    }

    /**
     * @return whether the touch sensor is released or not
     */
    public boolean isTouchSensorReleased() {
        return touchSensor.getState();
    }

    /**
     * @param speed the speed (-1.0 to 1.0) where negative is backwards
     */
    public void setMotorSpeed(double speed) {
        motor.setPower(speed);
    }

    /**
     * @return returns the number of rotations from the encoder
     */
    public double getMotorRotations() {
        return motor.getCurrentPosition() / ticksPerRotation;
    }

    public void setMotorZeroBehavior(DcMotor.ZeroPowerBehavior behavior) {
        motor.setZeroPowerBehavior(behavior);
    }

    /**
     * @param position the position (0.0-1.0) for the servo
     */
    public void setServoPosition(double position) {
        servo.setPosition(position);
    }

    /**
     * @return the raw voltage from the potentiometer
     */
    public double getPotVoltage() {
        return pot.getVoltage();
    }

    public double getPotRange() {
        return pot.getVoltage() / pot.getMaxVoltage();
    }

    /**
     * @return the angle (0 - 270) the potentiometer is pointed to
     */
    public double getPotAngle() {
        return getPotRange() * 270.0;
    }

    public double getPotPosition() {
        return pot.getVoltage() / pot.getMaxVoltage();
    }

    /**
     * @return the amount red (0-255) the color sensor sees
     */
    public int getAmountRed() {
        return colorSensor.red();
    }

    public int getAmountGreen() {
        return colorSensor.green();
    }

    public int getAmountBlue() {
        return colorSensor.blue();
    }

    /**
     * @param unit what units to return distance in
     * @return distance seen by distance sensor
     */
    public double getDistance(DistanceUnit unit) {
        return distanceSensor.getDistance(unit);
    }

    /**
     * @param unit what units to return the angle in
     * @return the heading (Z axis of the IMU)
     */
    public double getHeading(AngleUnit unit) {
        return imu.getRobotYawPitchRollAngles().getYaw(unit);
    }

    public void resetHeading() {
        imu.resetYaw();
    }

    /**
     * @return a list of tests for the hardware on the board - used by TestWiring
     */
    public ArrayList<TestItem> getTests() {
        ArrayList<TestItem> tests = new ArrayList<>();
        tests.add(new TestMotor("PB Motor", 0.5, motor));
        tests.add(new TestAnalogInput("PB Pot", pot, 0, 270));
        tests.add(new TestDigitalChannel("PB Touch", touchSensor));
        tests.add(new TestServo("PB Servo", servo, 0.0, 1.0));
        return tests;
    }
}