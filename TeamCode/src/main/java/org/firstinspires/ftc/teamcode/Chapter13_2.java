package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.util.ArrayList;

/**
 * Chapter 13 Exercise 2:
 * Modify your solution for exercise 1 to use ArrayList<String> instead of arrays.
 *
 * This demonstrates using ArrayList which can grow dynamically.
 */
@TeleOp(name = "Chapter 13_2", group = "Exercises")
@Disabled
public class Chapter13_2 extends OpMode {
    // ArrayList of song lyrics
    ArrayList<String> lyrics = new ArrayList<>();

    int lineIndex = 0;
    double DELAY_SECS = 1.0;
    double nextTime = 0;

    @Override
    public void init() {
        // Add lyrics to the ArrayList
        lyrics.add("Twinkle, twinkle, little star,");
        lyrics.add("How I wonder what you are!");
        lyrics.add("Up above the world so high,");
        lyrics.add("Like a diamond in the sky.");
        lyrics.add("Twinkle, twinkle, little star,");
        lyrics.add("How I wonder what you are!");

        lineIndex = 0;
        telemetry.addData("Status", "Initialized");
        telemetry.addData("Song Lines", lyrics.size());
    }

    @Override
    public void loop() {
        // Check if it's time to advance to the next line
        if (getRuntime() > nextTime) {
            lineIndex++;
            // Wrap around to the beginning when we reach the end
            if (lineIndex >= lyrics.size()) {
                lineIndex = 0;
            }
            nextTime = getRuntime() + DELAY_SECS;
        }

        telemetry.addData("Line", lineIndex + 1);
        telemetry.addLine(lyrics.get(lineIndex));
    }
}