package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.util.ArrayList;

@TeleOp()
public class Chapter13_2 extends OpMode {
    ArrayList<String> lines = new ArrayList<>();
    int lineIndex;
    double DELAY_SECS = 0.5;
    double nextTime;

    @Override
    public void init() {
        lines.add("Then he waddled away");
        lines.add("(Waddle waddle)");
        lines.add("Then he waddled away");
        lines.add("(Waddle waddle waddle)");
        lines.add("Then he waddled away");
        lines.add("(Waddle waddle)");
        lines.add("'Til the very next day");
        lines.add("(Bum bum bum bum bum ba-dum)");
        lineIndex = 0;
    }

    @Override
    public void loop() {
        if (nextTime < getRuntime()) {
            lineIndex++;
            if (lineIndex >= lines.size()) {
                lineIndex = lines.size() - 1;
            }
            nextTime = getRuntime() + DELAY_SECS;
        }
        telemetry.addLine(lines.get(lineIndex));
    }
}
