package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Chapter 13_1", group = "Exercises")
public class Chapter13_1 extends OpMode {
    // array of song lyrics to display
    String[] lyrics = {
            "Twinkle, twinkle, little star,",
            "How I wonder what you are!",
            "Up above the world so high,",
            "Like a diamond in the sky.",
            "Twinkle, twinkle, little star,",
            "How I wonder what you are!"
    };

    int lineIndex = 0; // current line index
    double DELAY_SECS = 1.0; // seconds between lines
    double nextTime = 0; // when to advance to next line

    @Override
    public void init() {
        lineIndex = 0; // start at first line
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loop() {
        // check if it's time to advance to next line
        if (getRuntime() > nextTime) {
            lineIndex++; // move to next line
            if (lineIndex >= lyrics.length) { // if past end
                lineIndex = 0; // wrap to beginning
            }
            nextTime = getRuntime() + DELAY_SECS; // set next advance time
        }

        telemetry.addData("Line", lineIndex + 1); // show line number (1-based)
        telemetry.addLine(lyrics[lineIndex]); // show current lyric
    }
}
