package org.firstinspires.ftc.teamcode.opmode.auto;

// RR-specific imports

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.roadrunner.PinpointDrive;
import org.firstinspires.ftc.teamcode.subsystems.ScoringMechanism;
import org.firstinspires.ftc.teamcode.subsystems.ScoringMechanismPosition;

import androidx.annotation.NonNull;

// RR-specific imports
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;

// Non-RR imports
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.acmerobotics.roadrunner.InstantFunction;

@Config
@Autonomous(name = "ACCURACY", group = "Autonomous")
public class AccuracyTest extends LinearOpMode {
    public void runOpMode() {
        // instantiate your MecanumDrive at a particular pose.
        Pose2d beginPose = new Pose2d(32.8, 61, Math.toRadians(-180));
        PinpointDrive drive = new PinpointDrive(hardwareMap, beginPose);
        ScoringMechanism scoringMechanism = new ScoringMechanism(hardwareMap);
        waitForStart();
        //   Action DriveBlueBucket = drive.actionBuilder(beginPose)
        Actions.runBlocking(
                drive.actionBuilder(beginPose)
                        .setTangent(0)
                        .splineToLinearHeading(new Pose2d(56, 0,Math.toRadians(90)), Math.toRadians(-45))
                        .waitSeconds(0.5)
                        .setTangent(Math.toRadians(-135))
                        .splineToLinearHeading(new Pose2d(32.8, -61.4,Math.toRadians(180)), Math.toRadians(-180))
                        .waitSeconds(0.5)
                        .setTangent(0)
                        .splineToLinearHeading(new Pose2d(56, 0,Math.toRadians(-90)), Math.toRadians(45))
                        .waitSeconds(0.5)
                        .splineToLinearHeading(new Pose2d(32.8, 61.4,Math.toRadians(180)), Math.toRadians(-180))

                        .build());
    }


}

