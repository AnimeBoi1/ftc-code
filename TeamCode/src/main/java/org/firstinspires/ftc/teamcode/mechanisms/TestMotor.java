package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Test class for testing a DcMotor.
 * When active, runs the motor at the specified speed.
 */
public class TestMotor extends TestItem {
    private double speed;
    private DcMotor motor;

    /**
     * @param description what to show for the name of this test
     * @param speed the speed that "on" should run the motor at
     * @param motor the motor to test
     */
    public TestMotor(String description, double speed, DcMotor motor) {
        super(description);
        this.speed = speed;
        this.motor = motor;
    }

    /**
     * @param on whether to run the motor or stop the motor
     * @param telemetry where to put the encoder results
     */
    @Override
    public void run(boolean on, Telemetry telemetry) {
        if (on) {
            motor.setPower(speed);
            telemetry.addData("Motor", "Running at %.2f", speed);
        } else {
            motor.setPower(0);
            telemetry.addData("Motor", "Stopped");
        }
        telemetry.addData("Position", motor.getCurrentPosition());
    }
}