package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;

/**
 * Chapter 12 Exercise 2:
 * Make a program that turns the motor until the distance sensor is less
 * than 10cm OR 5 seconds has passed and then turns the servo.
 *
 * This demonstrates combining time-based and sensor-based state transitions.
 */
@Autonomous(name = "Chapter 12_2", group = "Exercises")
public class Chapter12_2 extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard();

    enum State {
        MOTOR_RUNNING,
        SERVO_MOVING,
        DONE
    }

    State currentState = State.MOTOR_RUNNING;
    double startTime;
    final double TIMEOUT_SECONDS = 5.0;
    final double DISTANCE_THRESHOLD_CM = 10.0;
    final double SERVO_POSITION = 0.5;

    @Override
    public void init() {
        board.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void start() {
        startTime = getRuntime();
        currentState = State.MOTOR_RUNNING;
        board.setMotorSpeed(0.5);
    }

    @Override
    public void loop() {
        double elapsedTime = getRuntime() - startTime;
        double distance = board.getDistance(DistanceUnit.CM);

        switch (currentState) {
            case MOTOR_RUNNING:
                // Check if distance is less than 10cm OR 5 seconds have passed
                if (distance < DISTANCE_THRESHOLD_CM || elapsedTime >= TIMEOUT_SECONDS) {
                    // Stop motor and move servo
                    board.setMotorSpeed(0);
                    board.setServoPosition(SERVO_POSITION);
                    currentState = State.SERVO_MOVING;

                    if (distance < DISTANCE_THRESHOLD_CM) {
                        telemetry.addData("Trigger", "Distance threshold reached");
                    } else {
                        telemetry.addData("Trigger", "Timeout reached");
                    }
                }
                break;

            case SERVO_MOVING:
                currentState = State.DONE;
                break;

            case DONE:
                // Program complete
                break;
        }

        telemetry.addData("State", currentState);
        telemetry.addData("Distance (cm)", "%.2f", distance);
        telemetry.addData("Elapsed Time", "%.2f", elapsedTime);
    }
}