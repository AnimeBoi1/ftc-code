package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DigitalChannel;

@TeleOp()
public class Chapter22_2 extends OpMode {
    ColorSensor colorSensor;
    DigitalChannel greenLed, redLed;

    final int RED_THRESHOLD = 150;
    final int BLUE_THRESHOLD = 150;
    boolean isRedAlliance = true;

    @Override
    public void init() {
        colorSensor = hardwareMap.get(ColorSensor.class, "sensor_color_distance");
        greenLed = hardwareMap.get(DigitalChannel.class, "green_led");
        redLed = hardwareMap.get(DigitalChannel.class, "red_led");

        greenLed.setMode(DigitalChannel.Mode.OUTPUT);
        redLed.setMode(DigitalChannel.Mode.OUTPUT);

        telemetry.addLine("Press X to toggle alliance");
    }

    @Override
    public void loop() {
        if (gamepad1.x) {
            isRedAlliance = !isRedAlliance;
            try { Thread.sleep(200); } catch (InterruptedException e) {}
        }

        int red = colorSensor.red();
        int blue = colorSensor.blue();

        boolean detected = isRedAlliance ?
                (red > RED_THRESHOLD && red > blue) :
                (blue > BLUE_THRESHOLD && blue > red);

        if (detected) {
            redLed.setState(isRedAlliance);
            greenLed.setState(!isRedAlliance);
        } else {
            redLed.setState(false);
            greenLed.setState(false);
        }

        telemetry.addData("Alliance", isRedAlliance ? "RED" : "BLUE");
        telemetry.addData("Red", red);
        telemetry.addData("Blue", blue);
        telemetry.addData("Detected", detected ? "YES!" : "No");
    }
}
