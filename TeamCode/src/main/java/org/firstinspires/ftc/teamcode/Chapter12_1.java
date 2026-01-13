package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.Autonomous; // imports the Autonomous annotation for autonomous mode
import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard; // imports the ProgrammingBoard helper class

@Autonomous() // marks this class as an Autonomous program (runs without driver control)
public class Chapter12_1 extends OpMode { // defines our class extending OpMode for iterative execution
    enum State { // defines the possible states for our state machine
        START, // initial state when autonomous begins
        QUARTER_SPEED, // motor running at 25% speed
        HALF_SPEED, // motor running at 50% speed
        THREE_QUARTERS_SPEED, // motor running at 75% speed
        FULL_SPEED, // motor running at 100% speed
        DONE // autonomous sequence completed
    }

    ProgrammingBoard board = new ProgrammingBoard(); // creates an instance of the ProgrammingBoard hardware abstraction
    State state = State.START; // initializes state machine to START state
    double lastStepTime; // stores the timestamp of the last state transition

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        board.init(hardwareMap); // initializes all hardware devices using the robot's hardware map
    }

    @Override // indicates we're overriding a method from the parent class
    public void start() { // called once when START is pressed on Driver Station
        state = State.START; // resets state machine to START state
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        telemetry.addData("State", state); // displays the current state on Driver Station
        switch (state) { // executes code based on current state
            case START: // when in START state
                board.setMotorSpeed(0.250); // sets motor to 25% speed
                state = State.QUARTER_SPEED; // transitions to QUARTER_SPEED state
                lastStepTime = getRuntime(); // records the current time
                break; // exits the switch statement

            case QUARTER_SPEED: // when in QUARTER_SPEED state
                if (getRuntime() > lastStepTime + .250) { // checks if 0.25 seconds have passed
                    board.setMotorSpeed(0.500); // increases motor to 50% speed
                    state = State.HALF_SPEED; // transitions to HALF_SPEED state
                    lastStepTime = getRuntime(); // records the current time
                }
                break; // exits the switch statement

            case HALF_SPEED: // when in HALF_SPEED state
                if (getRuntime() > lastStepTime + .250) { // checks if 0.25 seconds have passed
                    board.setMotorSpeed(0.750); // increases motor to 75% speed
                    state = State.THREE_QUARTERS_SPEED; // transitions to THREE_QUARTERS_SPEED state
                    lastStepTime = getRuntime(); // records the current time
                }
                break; // exits the switch statement

            case THREE_QUARTERS_SPEED: // when in THREE_QUARTERS_SPEED state
                if (getRuntime() > lastStepTime + .250) { // checks if 0.25 seconds have passed
                    board.setMotorSpeed(1.00); // increases motor to full speed
                    state = State.FULL_SPEED; // transitions to FULL_SPEED state
                }
                break; // exits the switch statement

            case FULL_SPEED: // when in FULL_SPEED state
                if (board.isTouchSensorPressed()) { // checks if touch sensor is pressed
                    board.setMotorSpeed(0.0); // stops the motor
                    state = State.DONE; // transitions to DONE state
                }
                break; // exits the switch statement

            default: // handles DONE state and any undefined states
                telemetry.addData("Auto", "Finished"); // displays completion message
        }
    }
}
