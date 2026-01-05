package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Test class for testing an AnalogInput (like a potentiometer).
 * Displays the current value scaled to a specified range.
 */
public class TestAnalogInput extends TestItem {
    private AnalogInput analogInput;
    private double minValue;
    private double maxValue;

    public TestAnalogInput(String description, AnalogInput analogInput, double minValue, double maxValue) {
        super(description);
        this.analogInput = analogInput;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public void run(boolean on, Telemetry telemetry) {
        double voltage = analogInput.getVoltage();
        double scaledValue = Range.scale(voltage, 0, analogInput.getMaxVoltage(), minValue, maxValue);
        telemetry.addData("Voltage", "%.2f", voltage);
        telemetry.addData("Scaled Value", "%.2f", scaledValue);
    }
}