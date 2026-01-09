package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

@Autonomous(name = "Chapter 12_2", group = "Exercises")
public class Chapter12_2 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard(); // create programming board instance

    // state machine states
    enum State {
        MOTOR_RUNNING, // motor is running
        SERVO_MOVING,  // servo is moving
        DONE           // program complete
    }

    State currentState = State.MOTOR_RUNNING; // initial state
    double startTime; // tracks when motor started
    final double TIMEOUT_SECONDS = 5.0; // max time to run motor
    final double DISTANCE_THRESHOLD_CM = 10.0; // distance to stop at

    @Override
    public void init() {
        board.init(hardwareMap); // initialize hardware
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void start() {
        startTime = getRuntime(); // record start time
        currentState = State.MOTOR_RUNNING;
        board.setMotorSpeed(0.5); // start motor at half speed
    }

    @Override
    public void loop() {
        double elapsedTime = getRuntime() - startTime; // time since start
        double distance = board.getDistance(DistanceUnit.CM); // get distance reading

        switch (currentState) {
            case MOTOR_RUNNING:
                // stop if distance < 10cm OR timeout reached
                if (distance < DISTANCE_THRESHOLD_CM || elapsedTime >= TIMEOUT_SECONDS) {
                    board.setMotorSpeed(0); // stop motor
                    board.setServoPosition(0.5); // move servo
                    currentState = State.SERVO_MOVING;
                }
                break;

            case SERVO_MOVING:
                currentState = State.DONE; // transition to done
                break;

            case DONE:
                break; // program complete
        }

        telemetry.addData("State", currentState);
        telemetry.addData("Distance (cm)", "%.2f", distance);
        telemetry.addData("Elapsed Time", "%.2f", elapsedTime);
    }
}
