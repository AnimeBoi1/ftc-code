package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.util.ArrayList;

@TeleOp(name = "Chapter 13_2", group = "Exercises")
public class Chapter13_2 extends OpMode {
    ArrayList<String> lyrics = new ArrayList<>(); // dynamic list of lyrics

    int lineIndex = 0; // current line index
    double DELAY_SECS = 1.0; // seconds between lines
    double nextTime = 0; // when to advance to next line

    @Override
    public void init() {
        // add lyrics to ArrayList (can grow dynamically unlike arrays)
        lyrics.add("Twinkle, twinkle, little star,");
        lyrics.add("How I wonder what you are!");
        lyrics.add("Up above the world so high,");
        lyrics.add("Like a diamond in the sky.");
        lyrics.add("Twinkle, twinkle, little star,");
        lyrics.add("How I wonder what you are!");

        lineIndex = 0; // start at first line
        telemetry.addData("Status", "Initialized");
        telemetry.addData("Song Lines", lyrics.size()); // show total lines
    }

    @Override
    public void loop() {
        // check if it's time to advance to next line
        if (getRuntime() > nextTime) {
            lineIndex++; // move to next line
            if (lineIndex >= lyrics.size()) { // if past end
                lineIndex = 0; // wrap to beginning
            }
            nextTime = getRuntime() + DELAY_SECS; // set next advance time
        }

        telemetry.addData("Line", lineIndex + 1); // show line number
        telemetry.addLine(lyrics.get(lineIndex)); // get lyric from ArrayList
    }
}
