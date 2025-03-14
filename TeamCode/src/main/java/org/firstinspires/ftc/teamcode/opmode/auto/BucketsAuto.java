package org.firstinspires.ftc.teamcode.opmode.auto;

// RR-specific imports

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.roadrunner.PinpointDrive;
import org.firstinspires.ftc.teamcode.subsystems.ScoringMechanism;
import org.firstinspires.ftc.teamcode.subsystems.ScoringMechanismPosition;

// RR-specific imports

// Non-RR imports


@Config
@Autonomous(name = "BucketsAuto", group = "Autonomous")
public class BucketsAuto extends LinearOpMode {
    public void runOpMode() {
        // instantiate your MecanumDrive at a particular pose.

        Pose2d beginPose = new Pose2d(32.8, 61, Math.toRadians(-180));
        PinpointDrive drive = new PinpointDrive(hardwareMap, beginPose);
        ScoringMechanism scoringMechanism = new ScoringMechanism(hardwareMap);

        scoringMechanism.deposit.closeClaw();

        Action traj = drive.actionBuilder(beginPose)

                .stopAndAdd(() -> scoringMechanism.setPosition(ScoringMechanismPosition.DEPOSIT))

                .setTangent(0)
                .splineToLinearHeading(new Pose2d(60.5, 54, Math.toRadians(-135)), Math.toRadians(45))

                .waitSeconds(0.5)
                .stopAndAdd(() -> scoringMechanism.deposit.openClaw())
                .waitSeconds(0.25)
                .afterTime(0.5, () -> {
                    scoringMechanism.setPosition(ScoringMechanismPosition.INTAKE_ALIGN);
//                    scoringMechanism.horizontalSlide.setTargetPosition(200);
                })

//                        .afterTime(0.5, () -> {
//                            scoringMechanism.intake.runIntake(0.5);
//                        })
//                        .afterTime(0.1, () -> {
//                            scoringMechanism.intake.runIntake(0);
//                        })

                .waitSeconds(30)

                .setTangent(Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(50.8, 38, Math.toRadians(-90)), Math.toRadians(-90))

                // .turn(Math.toRadians(45))
                // .strafeTo(new Vector2d(48,46))
                // .waitSeconds(1)
                //   .turn(Math.toRadians(-45))
                // .setTangent(0)
                .afterTime(0.5, () -> scoringMechanism.setPosition(ScoringMechanismPosition.DEPOSIT))
                .waitSeconds(0.75)
                .setTangent(Math.toRadians(90))
                .splineToLinearHeading(new Pose2d(60.5, 54.5, Math.toRadians(-135)), Math.toRadians(45))
//                        .waitSeconds(1)
//                        .stopAndAdd(() -> scoringMechanism.deposit.openClaw())
//                        .waitSeconds(0.75)
//                        .afterTime(0.5, () -> {
//                            scoringMechanism.setPosition(ScoringMechanismPosition.INTAKE_ALIGN);
//                            scoringMechanism.horizontalSlide.setTargetPosition(200);
//                        })

                .waitSeconds(0.75)
                .setTangent(Math.toRadians(-90))
                .splineToLinearHeading(new Pose2d(60.5, 38, Math.toRadians(-90)), Math.toRadians(-90))
                //  .waitSeconds(1)
                // .afterTime(0.5, () -> scoringMechanism.setPosition(ScoringMechanismPosition.DEPOSIT))
                .waitSeconds(0.75)
                .setTangent(Math.toRadians(90))
                .splineToLinearHeading(new Pose2d(60.5, 54.5, Math.toRadians(-135)), Math.toRadians(45))
                // .waitSeconds(1)
                /*
                 .stopAndAdd(() -> scoringMechanism.deposit.openClaw())
                 .waitSeconds(0.75)
                 .afterTime(0.5, () -> {
                     scoringMechanism.setPosition(ScoringMechanismPosition.INTAKE_ALIGN);
                     scoringMechanism.horizontalSlide.setTargetPosition(200);})
                */
                .waitSeconds(0.75)
                .setTangent(Math.toRadians(-90))
                .splineToLinearHeading(new Pose2d(58.5, 34, Math.toRadians(-45)), -Math.PI / 4)
                // .waitSeconds(1)
                // .afterTime(0.5, () -> scoringMechanism.setPosition(ScoringMechanismPosition.DEPOSIT))
                .waitSeconds(0.75)
                .setTangent(Math.toRadians(90))
                .splineToLinearHeading(new Pose2d(60.5, 54.5, Math.toRadians(-135)), Math.toRadians(55))
                // .waitSeconds(1)
                //  .stopAndAdd(() -> scoringMechanism.deposit.openClaw())


                .waitSeconds(0.75)
                .setTangent(Math.toRadians(225))
                .splineToLinearHeading(new Pose2d(34, 0, Math.toRadians(180)), Math.PI) //park

                .build();


        waitForStart();

        Actions.runBlocking(
                new ParallelAction(
                        traj,
                        (t) -> {scoringMechanism.update(); return true;}
                )
        );
    }


}

