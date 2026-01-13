package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp()
public class Chapter23_2 extends OpMode {
    boolean wasRumbling = false;
    double lastTargetTime = 0;
    final double NO_TARGET_THRESHOLD = 1.0;

    @Override
    public void init() {
        telemetry.addLine("Rumbles when no targets visible");
    }

    @Override
    public void loop() {
        boolean targetVisible = gamepad1.a;

        if (targetVisible) {
            lastTargetTime = getRuntime();
        }

        double timeSinceTarget = getRuntime() - lastTargetTime;
        boolean shouldRumble = timeSinceTarget > NO_TARGET_THRESHOLD;

        if (shouldRumble && !wasRumbling) {
            gamepad1.rumbleBlips(2);
            wasRumbling = true;
        } else if (!shouldRumble && wasRumbling) {
            gamepad1.stopRumble();
            wasRumbling = false;
        } else if (shouldRumble && !gamepad1.isRumbling()) {
            gamepad1.rumbleBlips(2);
        }

        telemetry.addData("Target", targetVisible ? "YES" : "No");
        telemetry.addData("Time Since", "%.1f s", timeSinceTarget);
        telemetry.addData("Rumbling", shouldRumble ? "YES" : "No");
        telemetry.addLine("Hold A to simulate target");
    }
}
