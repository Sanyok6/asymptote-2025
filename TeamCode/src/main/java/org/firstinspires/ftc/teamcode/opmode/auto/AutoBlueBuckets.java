package org.firstinspires.ftc.teamcode.opmode.auto;

// RR-specific imports

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.TeleOp.PinpointDrive;


@Config
@Autonomous(name = "BLUEBuckets", group = "Autonomous")
public class AutoBlueBuckets extends LinearOpMode {
    public void runOpMode() {
        // instantiate your MecanumDrive at a particular pose.
        Pose2d beginPose = new Pose2d(12, 56, Math.toRadians(-90));
        PinpointDrive drive = new PinpointDrive(hardwareMap, beginPose);
        waitForStart();
        Actions.runBlocking(
                drive.actionBuilder(beginPose)
                        .setTangent(0)
                        .splineToLinearHeading(new Pose2d(52, 54,Math.toRadians(-135)), Math.toRadians(45))
                        .waitSeconds(0.6)
                        .turn(Math.toRadians(45))
                        .strafeTo(new Vector2d(48,46))
                        .waitSeconds(1)
                        .turn(Math.toRadians(-45))
                        .setTangent(0)
                        .waitSeconds(1)
                        .setTangent(Math.toRadians(90))
                        .splineToLinearHeading(new Pose2d(52, 54,Math.toRadians(-135)), Math.toRadians(45))
                        .waitSeconds(1)
                        .setTangent(0)
                        .splineToLinearHeading(new Pose2d(57, 46,Math.toRadians(-90)), Math.toRadians(90))

                        .strafeTo(new Vector2d(57,46))
                        .waitSeconds(1)
                        .turn(Math.toRadians(-25))
                        .waitSeconds(1)
                        .turn(Math.toRadians(25))
                        .waitSeconds(1)
                        .setTangent(Math.PI/2)

                        .splineToLinearHeading(new Pose2d(56,45,Math.toRadians(-45)), -Math.PI/4)
                        .waitSeconds(1)
                        .turn(Math.toRadians(-70))
                        .waitSeconds(0.7)
                        .setTangent(-Math.PI/2)
                        .splineToLinearHeading(new Pose2d(30,0,Math.toRadians(180)), Math.PI)
                        .waitSeconds(1)
                        .setTangent(0)
                        .splineToLinearHeading(new Pose2d(52,54,Math.toRadians(225)), Math.PI/4)
                        .waitSeconds(1)
                        .setTangent(-Math.PI/2)
                        .splineToLinearHeading(new Pose2d(30,0,Math.toRadians(180)), Math.PI)
                        .waitSeconds(1)
                        .setTangent(0)
                        .splineToLinearHeading(new Pose2d(52,54,Math.toRadians(225)), Math.PI/4)
                        .waitSeconds(1)
                        .setTangent(-Math.PI/2)
                        .splineToLinearHeading(new Pose2d(30,0,Math.toRadians(180)), Math.PI)
                        .build());
    }
}