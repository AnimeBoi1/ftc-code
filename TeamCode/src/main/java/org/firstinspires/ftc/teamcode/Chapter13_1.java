package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Chapter 13 Exercise 1:
 * Modify the opMode to send the chorus of a song you know at a fixed rate
 * on telemetry. Once it gets to the end, it should send it again (loop).
 *
 * This demonstrates using arrays and cycling through them.
 */
@TeleOp(name = "Chapter 13_1", group = "Exercises")
@Disabled
public class Chapter13_1 extends OpMode {
    // Array of song lyrics (using "Twinkle Twinkle Little Star" as an example)
    String[] lyrics = {
            "Twinkle, twinkle, little star,",
            "How I wonder what you are!",
            "Up above the world so high,",
            "Like a diamond in the sky.",
            "Twinkle, twinkle, little star,",
            "How I wonder what you are!"
    };

    int lineIndex = 0;
    double DELAY_SECS = 1.0;
    double nextTime = 0;

    @Override
    public void init() {
        lineIndex = 0;
        telemetry.addData("Status", "Initialized");
        telemetry.addData("Song", "Ready to play lyrics");
    }

    @Override
    public void loop() {
        // Check if it's time to advance to the next line
        if (getRuntime() > nextTime) {
            lineIndex++;
            // Wrap around to the beginning when we reach the end
            if (lineIndex >= lyrics.length) {
                lineIndex = 0;
            }
            nextTime = getRuntime() + DELAY_SECS;
        }

        telemetry.addData("Line", lineIndex + 1);
        telemetry.addLine(lyrics[lineIndex]);
    }
}