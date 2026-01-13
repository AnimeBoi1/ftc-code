package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode

@TeleOp() // marks this class as a TeleOp program visible on the Driver Station
public class Chapter13_1 extends OpMode { // defines our class extending OpMode for iterative execution
    String[] lines = { // declares and initializes an array of song lyrics
            "Then he waddled away", // line 0 of the song
            "(Waddle waddle)", // line 1 of the song
            "Then he waddled away", // line 2 of the song
            "(Waddle waddle waddle)", // line 3 of the song
            "Then he waddled away", // line 4 of the song
            "(Waddle waddle)", // line 5 of the song
            "'Til the very next day", // line 6 of the song
            "(Bum bum bum bum bum ba-dum)"}; // line 7 of the song (last line)

    int lineIndex; // tracks which line of the song to display
    double DELAY_SECS = 0.5; // time delay between lines in seconds

    double nextTime; // stores when the next line should be displayed

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        lineIndex = 0; // starts at the first line of the song
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        if (nextTime < getRuntime()) { // checks if it's time to advance to the next line
            lineIndex++; // moves to the next line
            if (lineIndex >= lines.length) { // checks if we've gone past the last line
                lineIndex = lines.length - 1; // stays on the last line (prevents overflow)
            }
            nextTime = getRuntime() + DELAY_SECS; // schedules the next line change
        }
        telemetry.addLine(lines[lineIndex]); // displays the current line on Driver Station
    }
}
