# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build Commands

This is a Gradle-based Android project (Gradle 8.9, Android Gradle Plugin 8.7.0).

```bash
./gradlew assembleDebug       # Build debug APK
./gradlew assembleRelease     # Build release APK
./gradlew clean               # Clean build artifacts
```

The debug APK is signed with `libs/ftc.debug.keystore` automatically.

## Project Architecture

**Two-module structure:**
- `FtcRobotController/` - FTC SDK framework and 50+ sample OpModes (don't modify)
- `TeamCode/` - Team-specific robot code (primary development location)

**Build configuration files:**
- `build.common.gradle` - Shared config applied to all modules
- `build.dependencies.gradle` - Centralized FTC SDK dependencies (version 11.0.0)

## TeamCode Development

All team code goes in `TeamCode/src/main/java/org/firstinspires/ftc/teamcode/`.

**OpMode Types:**

1. **LinearOpMode** - Sequential execution:
```java
@TeleOp(name="My TeleOp", group="TeamCode")
public class MyOpMode extends LinearOpMode {
    @Override
    public void runOpMode() {
        waitForStart();
        while (opModeIsActive()) {
            // Robot control loop
        }
    }
}
```

2. **Iterative OpMode** - Event-driven with lifecycle methods (`init()`, `init_loop()`, `start()`, `loop()`, `stop()`).

**Annotations:**
- `@TeleOp(name="...", group="...")` - Driver-controlled OpMode
- `@Autonomous(name="...", group="...")` - Autonomous OpMode
- `@Disabled` - Hide from Driver Station menu

**Hardware Access:**
```java
DcMotor motor = hardwareMap.get(DcMotor.class, "motorName");
```
Hardware names must match the Robot Controller configuration.

## Sample OpModes Reference

Samples are in `FtcRobotController/src/main/java/org/firstinspires/ftc/robotcontroller/external/samples/`. Key patterns:

- `BasicOpMode_Linear.java` / `BasicOpMode_Iterative.java` - Starting templates
- `RobotHardware.java` - Hardware abstraction pattern (recommended for code reuse)
- `ConceptAprilTag*.java` - Vision/AprilTag detection
- `RobotAutoDriveByEncoder_Linear.java` - Encoder-based autonomous driving

To use a sample: copy it to TeamCode, rename class and file, update package to `org.firstinspires.ftc.teamcode`, remove `@Disabled`.

## SDK Target Versions

- Min SDK: 24 (Android 7.0)
- Target SDK: 28 (Android 9.0)
- Java: 1.8

## Learning Resources

This project includes `doc/LearnJavaForFTC_extracted.txt`, the full text of "Learn Java for FTC" by Alan G. Smith. The `Chapter*.java` files in TeamCode are exercises from this book covering:

- Chapters 1-5: Java basics (variables, gamepad input, control flow, classes/methods)
- Chapters 6-11: Hardware (servos, motors, sensors, IMU/gyro)
- Chapters 12-14: State machines, arrays, inheritance
- Chapters 16, 20: Computer vision (AprilTags), mecanum drive