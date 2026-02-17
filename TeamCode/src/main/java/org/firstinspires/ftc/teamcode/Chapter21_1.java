package org.firstinspires.ftc.teamcode; // declares which package this class belongs to

import com.qualcomm.hardware.sparkfun.SparkFunOTOS; // imports SparkFun Optical Tracking Odometry Sensor
import com.qualcomm.robotcore.eventloop.opmode.OpMode; // imports the OpMode base class for iterative programs
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // imports the TeleOp annotation for driver-controlled mode

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName; // imports WebcamName for camera access
import org.firstinspires.ftc.robotcore.external.matrices.VectorF; // imports VectorF for field position vectors
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit; // imports AngleUnit for angle measurement
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit; // imports DistanceUnit for distance measurement
import org.firstinspires.ftc.vision.VisionPortal; // imports VisionPortal for camera pipeline
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection; // imports AprilTagDetection for tag data
import org.firstinspires.ftc.vision.apriltag.AprilTagPoseFtc; // imports AprilTagPoseFtc for pose data
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor; // imports AprilTagProcessor for tag detection

import java.util.List; // imports List for detection results

@TeleOp // marks this class as a TeleOp program
public class Chapter21_1 extends OpMode { // Exercise 21.1: OTOS + AprilTag fusion
    private AprilTagProcessor aprilTagProcessor; // processes camera frames to detect AprilTags
    private VisionPortal visionPortal; // manages the camera and vision processing pipeline
    SparkFunOTOS sparkfunOTOS; // Sparkfun Optical Tracking Odometry Sensor for continuous position tracking

    @Override // indicates we're overriding a method from the parent class
    public void init() { // called once when INIT is pressed on Driver Station
        WebcamName webcamName = hardwareMap.get(WebcamName.class, "Webcam 1"); // gets webcam from hardware map
        sparkfunOTOS = hardwareMap.get(SparkFunOTOS.class, "otos"); // gets OTOS sensor from hardware map
        configureOTOS(); // configures the OTOS sensor settings
        aprilTagProcessor = AprilTagProcessor.easyCreateWithDefaults(); // creates AprilTag processor with default settings
        visionPortal = VisionPortal.easyCreateWithDefaults(webcamName, aprilTagProcessor); // creates vision portal with webcam and processor
    }

    private void configureOTOS() { // configures the Sparkfun OTOS sensor
        sparkfunOTOS.setLinearUnit(DistanceUnit.INCH); // sets distance unit to inches
        sparkfunOTOS.setAngularUnit(AngleUnit.DEGREES); // sets angle unit to degrees
        sparkfunOTOS.setOffset(new SparkFunOTOS.Pose2D(0, 0, 0)); // sets sensor offset from robot center
        sparkfunOTOS.setLinearScalar(1.0); // sets linear scaling factor (adjust for accuracy)
        sparkfunOTOS.setAngularScalar(1.0); // sets angular scaling factor (adjust for accuracy)
        sparkfunOTOS.resetTracking(); // resets the tracking position to zero
        sparkfunOTOS.setPosition(new SparkFunOTOS.Pose2D(0, 0, 0)); // sets initial position
        sparkfunOTOS.calibrateImu(255, false); // calibrates the IMU with 255 samples
    }

    @Override // indicates we're overriding a method from the parent class
    public void loop() { // called repeatedly while the OpMode is running
        List<AprilTagDetection> currentDetections = aprilTagProcessor.getDetections(); // gets all currently detected AprilTags
        StringBuilder idsFound = new StringBuilder(); // builds a string of detected tag IDs

        SparkFunOTOS.Pose2D pose2D = sparkfunOTOS.getPosition(); // gets current OTOS position

        for (AprilTagDetection detection : currentDetections) { // iterates through each detected AprilTag
            sparkfunOTOS.setPosition(convertFromAprilTag( // corrects OTOS position using AprilTag data
                    detection.metadata.fieldPosition, detection.ftcPose, pose2D.h));
            idsFound.append(detection.id); // adds detected tag ID to the string
            idsFound.append(' '); // adds space separator between IDs
        }

        telemetry.addData("April Tags", idsFound); // displays which AprilTags are seen
        SparkFunOTOS.Pose2D pos = sparkfunOTOS.getPosition(); // gets the corrected position
        telemetry.addData("X (inch)", pos.x); // displays X position in inches
        telemetry.addData("Y (inch)", pos.y); // displays Y position in inches
        telemetry.addData("Heading (degrees)", pos.h); // displays heading in degrees
    }

    private SparkFunOTOS.Pose2D convertFromAprilTag(VectorF fieldPosition, // converts AprilTag detection to OTOS position
                                                     AprilTagPoseFtc pose, double heading) {
        SparkFunOTOS.Pose2D pose2D = new SparkFunOTOS.Pose2D(); // creates new pose for the converted position
        pose2D.x = fieldPosition.get(0) + pose.x; // combines field position with camera offset for X
        pose2D.y = fieldPosition.get(1) + pose.y; // combines field position with camera offset for Y
        pose2D.h = heading; // keeps the current heading from OTOS
        // TODO: Convert from Camera position to Robot Center
        // this is different for every robot so you'll have to do this.
        return pose2D; // returns the fused position
    }
}
