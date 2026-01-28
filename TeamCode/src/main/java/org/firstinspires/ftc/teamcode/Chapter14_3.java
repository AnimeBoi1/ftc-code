package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode

/**
 * Exercise 14.3: Demonstrates inheritance refactoring pattern
 * The exercise asks to make ProgrammingBoard2 extend ProgrammingBoard1,
 * ProgrammingBoard3 extend ProgrammingBoard2, etc.
 * Key changes needed: change private members to protected so children can access them.
 */
@TeleOp() // marks this class as a TeleOp program visible on the Driver Station
public class Chapter14_3 extends OpMode { // defines our class extending OpMode for iterative execution

    // Example base class showing inheritance pattern (simplified)
    static class BoardBase { // base class with touch sensor functionality
        protected String touchSensorName = "touch_sensor"; // protected so children can access

        public String getDescription() { // returns description of this board level
            return "Base: Touch Sensor";
        }
    }

    // Example child class extending base, adding motor functionality
    static class BoardWithMotor extends BoardBase { // extends BoardBase to inherit touch sensor
        protected String motorName = "motor"; // adds motor, protected for further children

        @Override // overrides parent method to include new functionality
        public String getDescription() { // returns combined description
            return super.getDescription() + " + Motor"; // calls parent's method and adds to it
        }
    }

    // Example grandchild class extending motor board, adding servo functionality
    static class BoardWithServo extends BoardWithMotor { // extends BoardWithMotor to inherit both
        protected String servoName = "servo"; // adds servo

        @Override // overrides to include all three components
        public String getDescription() { // returns full inheritance chain description
            return super.getDescription() + " + Servo"; // builds on parent's description
        }
    }

    BoardBase base = new BoardBase(); // instance of base class
    BoardWithMotor withMotor = new BoardWithMotor(); // instance showing first level of inheritance
    BoardWithServo withServo = new BoardWithServo(); // instance showing full inheritance chain

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        telemetry.addLine("Exercise 14.3: Inheritance Demonstration"); // displays exercise title
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        telemetry.addLine("=== Inheritance Chain Demo ==="); // section header
        telemetry.addData("BoardBase", base.getDescription()); // shows base class description
        telemetry.addData("BoardWithMotor", withMotor.getDescription()); // shows inherited + added
        telemetry.addData("BoardWithServo", withServo.getDescription()); // shows full chain

        telemetry.addLine(""); // blank line for spacing
        telemetry.addLine("Key pattern: Each child class 'extends' parent"); // explains the pattern
        telemetry.addLine("Use 'protected' instead of 'private'"); // key change needed
        telemetry.addLine("for members that children need to access"); // explains why protected
    }
}
