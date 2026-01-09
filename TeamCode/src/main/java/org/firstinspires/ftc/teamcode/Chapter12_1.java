package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

@Autonomous(name = "Chapter 12_1", group = "Exercises")
public class Chapter12_1 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard(); // create programming board instance

    // state machine states for motor ramping
    enum State {
        RAMP_25,      // 25% speed
        RAMP_50,      // 50% speed
        RAMP_75,      // 75% speed
        FULL_SPEED,   // 100% speed
        STOPPED       // motor stopped
    }

    State currentState = State.RAMP_25; // start at 25% speed
    double stateStartTime; // tracks when current state began

    @Override
    public void init() {
        board.init(hardwareMap); // initialize hardware
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void start() {
        stateStartTime = getRuntime(); // record start time
        currentState = State.RAMP_25; // begin at first ramp state
        board.setMotorSpeed(0.25); // set initial speed
    }

    @Override
    public void loop() {
        double elapsedTime = getRuntime() - stateStartTime; // time in current state

        switch (currentState) {
            case RAMP_25:
                if (elapsedTime >= 0.250) { // after 250ms
                    currentState = State.RAMP_50; // advance to next state
                    board.setMotorSpeed(0.50); // increase speed
                    stateStartTime = getRuntime(); // reset timer
                }
                break;

            case RAMP_50:
                if (elapsedTime >= 0.250) { // after 250ms
                    currentState = State.RAMP_75;
                    board.setMotorSpeed(0.75);
                    stateStartTime = getRuntime();
                }
                break;

            case RAMP_75:
                if (elapsedTime >= 0.250) { // after 250ms
                    currentState = State.FULL_SPEED;
                    board.setMotorSpeed(1.0); // full speed
                }
                break;

            case FULL_SPEED:
                if (board.isTouchSensorPressed()) { // wait for touch sensor
                    currentState = State.STOPPED;
                    board.setMotorSpeed(0); // stop motor
                }
                break;

            case STOPPED:
                break; // do nothing, motor is stopped
        }

        telemetry.addData("State", currentState);
        telemetry.addData("Touch Sensor", board.isTouchSensorPressed() ? "Pressed" : "Released");
    }
}
