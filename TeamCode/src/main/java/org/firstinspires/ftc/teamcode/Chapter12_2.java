package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.Autonomous; // imports the Autonomous annotation for autonomous mode
import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit; // imports DistanceUnit enum for distance measurements
import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard; // imports the ProgrammingBoard helper class

@Autonomous() // marks this class as an Autonomous program (runs without driver control)
public class Chapter12_2 extends OpMode { // defines our class extending OpMode for iterative execution
    enum State { // defines the possible states for our state machine
        START, // initial state when autonomous begins
        GO_UNTIL_DISTANCE, // driving until distance sensor detects object
        TURN_SERVO, // turning the servo after stopping
        DONE // autonomous sequence completed
    }

    ProgrammingBoard board = new ProgrammingBoard(); // creates an instance of the ProgrammingBoard hardware abstraction
    State state = State.START; // initializes state machine to START state
    double lastStepTime; // stores the timestamp of the last state transition

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        board.init(hardwareMap); // initializes all hardware devices using the robot's hardware map
        state = State.START; // ensures state machine starts in START state
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        telemetry.addData("State", state); // displays the current state on Driver Station
        switch (state) { // executes code based on current state
            case START: // when in START state
                board.setMotorSpeed(0.5); // starts motor at half speed
                board.setServoPosition(0.0); // moves servo to minimum position
                resetRuntime(); // resets the runtime timer to zero
                state = State.GO_UNTIL_DISTANCE; // transitions to GO_UNTIL_DISTANCE state
                break; // exits the switch statement

            case GO_UNTIL_DISTANCE: // when in GO_UNTIL_DISTANCE state
                if ((board.getDistance(DistanceUnit.CM) < 10) || (getRuntime() > 5.0)) { // checks if object is close OR 5 seconds passed
                    board.setMotorSpeed(0.0); // stops the motor
                    state = State.TURN_SERVO; // transitions to TURN_SERVO state
                }
                break; // exits the switch statement

            case TURN_SERVO: // when in TURN_SERVO state
                board.setServoPosition(0.5); // moves servo to center position
                state = State.DONE; // transitions to DONE state
                break; // exits the switch statement

            default: // handles DONE state and any undefined states
                telemetry.addData("Auto", "Finished"); // displays completion message
        }
    }
}
