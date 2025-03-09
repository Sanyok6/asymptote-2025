package org.firstinspires.ftc.teamcode.opmode.auto;

// RR-specific imports

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.acmerobotics.roadrunner.PoseMap;
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
@Autonomous(name = "BLUEBuckets", group = "Autonomous")
public class AutoBlueBuckets extends LinearOpMode {
    public void runOpMode() {
        // instantiate your MecanumDrive at a particular pose.

        Pose2d beginPose = new Pose2d(32.8, 61, Math.toRadians(-180));
        PinpointDrive drive = new PinpointDrive(hardwareMap, beginPose);
        ScoringMechanism scoringMechanism = new ScoringMechanism(hardwareMap);
        waitForStart();

     //   Action DriveBlueBucket = drive.actionBuilder(beginPose)
        Actions.runBlocking(
                drive.actionBuilder(beginPose)
                        .afterTime(0.5, () -> scoringMechanism.setPosition(ScoringMechanismPosition.DEPOSIT))
                        .setTangent(0)
                        .splineToLinearHeading(new Pose2d(60.5, 54,Math.toRadians(-135)), Math.toRadians(45))
                       // .waitSeconds(1)
                        .stopAndAdd(() -> scoringMechanism.deposit.openClaw())
                        .waitSeconds(0.75)
                        .afterTime(0.5, () -> {
                            scoringMechanism.setPosition(ScoringMechanismPosition.INTAKE_ALIGN);
                            scoringMechanism.horizontalSlide.setTargetPosition(200);})
                        .setTangent(Math.toRadians(180))
                        .splineToLinearHeading(new Pose2d(50.8, 38,Math.toRadians(-90)), Math.toRadians(-90))
                        // .turn(Math.toRadians(45))
                        // .strafeTo(new Vector2d(48,46))
                       // .waitSeconds(1)
                        //   .turn(Math.toRadians(-45))
                        .setTangent(0)
                        .afterTime(0.5, () -> scoringMechanism.setPosition(ScoringMechanismPosition.DEPOSIT))
                        .setTangent(Math.toRadians(90))
                        .splineToLinearHeading(new Pose2d(60.5, 54.5,Math.toRadians(-135)), Math.toRadians(45))
                      //  .waitSeconds(1)
                        .stopAndAdd(() -> scoringMechanism.deposit.openClaw())
                        .waitSeconds(0.75)
                        .afterTime(0.5, () -> {
                        scoringMechanism.setPosition(ScoringMechanismPosition.INTAKE_ALIGN);
                        scoringMechanism.horizontalSlide.setTargetPosition(200);})
                        .setTangent(Math.toRadians(-90))
                        .splineToLinearHeading(new Pose2d(60.5, 38,Math.toRadians(-90)), Math.toRadians(-90))
                      //  .waitSeconds(1)
                        .afterTime(0.5, () -> scoringMechanism.setPosition(ScoringMechanismPosition.DEPOSIT))
                        .setTangent(Math.toRadians(90))
                        .splineToLinearHeading(new Pose2d(60.5, 54.5,Math.toRadians(-135)), Math.toRadians(45))
                       // .waitSeconds(1)
                        .stopAndAdd(() -> scoringMechanism.deposit.openClaw())
                        .waitSeconds(0.75)
                        .afterTime(0.5, () -> {
                            scoringMechanism.setPosition(ScoringMechanismPosition.INTAKE_ALIGN);
                            scoringMechanism.horizontalSlide.setTargetPosition(200);})
                        .setTangent(Math.toRadians(-90))
                        .splineToLinearHeading(new Pose2d(58.5,34,Math.toRadians(-45)), -Math.PI/4)
                       // .waitSeconds(1)
                        .afterTime(0.5, () -> scoringMechanism.setPosition(ScoringMechanismPosition.DEPOSIT))
                        .setTangent(Math.toRadians(90))
                        .splineToLinearHeading(new Pose2d(60.5, 54.5,Math.toRadians(-135)), Math.toRadians(55))
                       // .waitSeconds(1)
                        .stopAndAdd(() -> scoringMechanism.deposit.openClaw())
                        .setTangent(Math.toRadians(225))
                        .splineToLinearHeading(new Pose2d(34,0,Math.toRadians(180)), Math.PI) //park

                        .build());
    }


}

