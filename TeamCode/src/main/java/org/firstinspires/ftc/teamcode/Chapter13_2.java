package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode

import java.util.ArrayList; // imports ArrayList class for dynamic array functionality

@TeleOp() // marks this class as a TeleOp program visible on the Driver Station
public class Chapter13_2 extends OpMode { // defines our class extending OpMode for iterative execution
    ArrayList<String> lines = new ArrayList<>(); // creates a dynamic list to store song lyrics
    int lineIndex; // tracks which line of the song to display
    double DELAY_SECS = 0.5; // time delay between lines in seconds
    double nextTime; // stores when the next line should be displayed

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        lines.add("Then he waddled away"); // adds line 0 to the list
        lines.add("(Waddle waddle)"); // adds line 1 to the list
        lines.add("Then he waddled away"); // adds line 2 to the list
        lines.add("(Waddle waddle waddle)"); // adds line 3 to the list
        lines.add("Then he waddled away"); // adds line 4 to the list
        lines.add("(Waddle waddle)"); // adds line 5 to the list
        lines.add("'Til the very next day"); // adds line 6 to the list
        lines.add("(Bum bum bum bum bum ba-dum)"); // adds line 7 to the list (last line)
        lineIndex = 0; // starts at the first line of the song
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        if (nextTime < getRuntime()) { // checks if it's time to advance to the next line
            lineIndex++; // moves to the next line
            if (lineIndex >= lines.size()) { // checks if we've gone past the last line (uses size() for ArrayList)
                lineIndex = lines.size() - 1; // stays on the last line (prevents overflow)
            }
            nextTime = getRuntime() + DELAY_SECS; // schedules the next line change
        }
        telemetry.addLine(lines.get(lineIndex)); // displays the current line using get() method for ArrayList
    }
}
