package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

/**
 * Chapter 12 Exercise 1:
 * Make a program that ramps your motor to full speed (.25 for 250ms, .50
 * for 250ms, .75 for 250ms, 1.0) and goes at full speed until the touch
 * sensor is pressed.
 *
 * This demonstrates state machine programming with timed transitions.
 */
@Autonomous(name = "Chapter 12_1", group = "Exercises")
public class Chapter12_1 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard();

    // State machine states
    enum State {
        RAMP_25,
        RAMP_50,
        RAMP_75,
        FULL_SPEED,
        STOPPED
    }

    State currentState = State.RAMP_25;
    double stateStartTime;

    @Override
    public void init() {
        board.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void start() {
        stateStartTime = getRuntime();
        currentState = State.RAMP_25;
        board.setMotorSpeed(0.25);
    }

    @Override
    public void loop() {
        double elapsedTime = getRuntime() - stateStartTime;

        switch (currentState) {
            case RAMP_25:
                if (elapsedTime >= 0.250) {
                    currentState = State.RAMP_50;
                    board.setMotorSpeed(0.50);
                    stateStartTime = getRuntime();
                }
                break;

            case RAMP_50:
                if (elapsedTime >= 0.250) {
                    currentState = State.RAMP_75;
                    board.setMotorSpeed(0.75);
                    stateStartTime = getRuntime();
                }
                break;

            case RAMP_75:
                if (elapsedTime >= 0.250) {
                    currentState = State.FULL_SPEED;
                    board.setMotorSpeed(1.0);
                }
                break;

            case FULL_SPEED:
                if (board.isTouchSensorPressed()) {
                    currentState = State.STOPPED;
                    board.setMotorSpeed(0);
                }
                break;

            case STOPPED:
                // Motor is stopped, do nothing
                break;
        }

        telemetry.addData("State", currentState);
        telemetry.addData("Motor Speed", getSpeedForState(currentState));
        telemetry.addData("Touch Sensor", board.isTouchSensorPressed() ? "Pressed" : "Released");
    }

    private double getSpeedForState(State state) {
        switch (state) {
            case RAMP_25: return 0.25;
            case RAMP_50: return 0.50;
            case RAMP_75: return 0.75;
            case FULL_SPEED: return 1.0;
            default: return 0.0;
        }
    }
}