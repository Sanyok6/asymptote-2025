package org.firstinspires.ftc.teamcode.opmode.auto;

// RR-specific imports

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.roadrunner.PinpointDrive;


@Config
@Autonomous(name = "BLUEBuckets", group = "Autonomous")
public class AutoBlueBuckets extends LinearOpMode {
    public void runOpMode() {
        // instantiate your MecanumDrive at a particular pose.
        Pose2d beginPose = new Pose2d(32.8, 61.4, Math.toRadians(-180));
        PinpointDrive drive = new PinpointDrive(hardwareMap, beginPose);
        waitForStart();
        Actions.runBlocking(
                drive.actionBuilder(beginPose)
                        .setTangent(0)
                        .splineToLinearHeading(new Pose2d(52, 54,Math.toRadians(-135)), Math.toRadians(45))
                        .waitSeconds(0.6)
                        .splineToLinearHeading(new Pose2d(48, 46,Math.toRadians(-90)), Math.toRadians(-90))
                        // .turn(Math.toRadians(45))
                        // .strafeTo(new Vector2d(48,46))
                        .waitSeconds(1)
                        //   .turn(Math.toRadians(-45))
                        .setTangent(0)
                        .setTangent(Math.toRadians(45))
                        .splineToLinearHeading(new Pose2d(52, 54,Math.toRadians(-135)), Math.toRadians(45))
                        .waitSeconds(1)
                        .setTangent(0)
                        .splineToLinearHeading(new Pose2d(57, 46,Math.toRadians(-90)), Math.toRadians(90))
                        .waitSeconds(1)
                        .splineToLinearHeading(new Pose2d(52, 54,Math.toRadians(-135)), Math.toRadians(45))
                        .waitSeconds(1)
                        .splineToLinearHeading(new Pose2d(56,45,Math.toRadians(-45)), -Math.PI/4)
                        .waitSeconds(1)
                        .splineToLinearHeading(new Pose2d(52, 54,Math.toRadians(-135)), Math.toRadians(45))
                        .waitSeconds(1)
                        .setTangent(Math.toRadians(-90))
                        .splineToLinearHeading(new Pose2d(30,0,Math.toRadians(180)), Math.PI)
                        .build());
    }
}