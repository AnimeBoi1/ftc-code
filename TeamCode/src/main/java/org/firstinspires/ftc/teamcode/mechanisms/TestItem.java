package org.firstinspires.ftc.teamcode.mechanisms;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Abstract base class for test items used in TestWiring OpMode.
 * Each test item represents a piece of hardware that can be tested.
 */
public abstract class TestItem {
    private String description;

    protected TestItem(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Run the test.
     * @param on Whether the test should be active (e.g., button pressed)
     * @param telemetry Telemetry object to display test results
     */
    public abstract void run(boolean on, Telemetry telemetry);
}