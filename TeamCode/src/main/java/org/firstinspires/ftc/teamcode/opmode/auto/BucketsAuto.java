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

                // PLACE PRELOADED SAMPLE

                .stopAndAdd(() -> scoringMechanism.setPosition(ScoringMechanismPosition.DEPOSIT))

                .setTangent(0)
                .splineToLinearHeading(new Pose2d(60.5, 54, Math.toRadians(-135)), Math.toRadians(45))

                .stopAndAdd(() -> {
                    scoringMechanism.deposit.openClaw();
                    scoringMechanism.update();
                })
                .waitSeconds(0.25)


                // PICKUP FIRST SAMPLE

                .stopAndAdd( () -> {
                    scoringMechanism.horizontalSlide.setTargetPosition(300);
                    scoringMechanism.setPosition(ScoringMechanismPosition.INTAKE_LOWER);
                    scoringMechanism.intake.runIntake();
                    scoringMechanism.update();
                })

                .setTangent(Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(50.8, 45, Math.toRadians(-90)), Math.toRadians(-90))

                .waitSeconds(0.5)
                .stopAndAdd(() -> {
                    scoringMechanism.setPosition(ScoringMechanismPosition.TRANSFER);
                })
                .waitSeconds(3)


                // PLACE FIRST SAMPLE

                .setTangent(Math.toRadians(90))
                .splineToLinearHeading(new Pose2d(60.5, 54.5, Math.toRadians(-135)), Math.toRadians(45))
                .stopAndAdd(() -> {
                    scoringMechanism.deposit.openClaw();
                    scoringMechanism.update();
                })
                .waitSeconds(0.25)


                // PICKUP SECOND SAMPLE

                .stopAndAdd(() -> {
                    scoringMechanism.horizontalSlide.setTargetPosition(250);
                    scoringMechanism.setPosition(ScoringMechanismPosition.INTAKE_LOWER);
                    scoringMechanism.intake.runIntake();
                    scoringMechanism.update();
                })

                .setTangent(Math.toRadians(-90))
                .splineToLinearHeading(new Pose2d(60.5, 43.5, Math.toRadians(-85)), Math.toRadians(-90))

                .waitSeconds(0.5)
                .stopAndAdd(() -> {
                    scoringMechanism.setPosition(ScoringMechanismPosition.TRANSFER);
                })
                .waitSeconds(3)


                // PLACE SECOND SAMPLE

                .setTangent(Math.toRadians(90))
                .splineToLinearHeading(new Pose2d(60.5, 54.5, Math.toRadians(-135)), Math.toRadians(45))
                .stopAndAdd(() -> {
                    scoringMechanism.deposit.openClaw();
                    scoringMechanism.update();
                })
                .waitSeconds(0.25)


                // PICKUP THIRD SAMPLE

                .afterTime(0.25, () -> {
                    scoringMechanism.horizontalSlide.setTargetPosition(150);
                    scoringMechanism.setPosition(ScoringMechanismPosition.INTAKE_LOWER);
                    scoringMechanism.intake.runIntake();
                    scoringMechanism.update();
                })

                .setTangent(Math.toRadians(-90))
                .splineToLinearHeading(new Pose2d(57, 33, Math.toRadians(-40)), -Math.PI/4)

                .waitSeconds(1)
                .stopAndAdd(() -> {
                    scoringMechanism.setPosition(ScoringMechanismPosition.TRANSFER);
                })
                .waitSeconds(3)


                // PLACE THIRD SAMPLE

                .setTangent(Math.toRadians(90))
                .splineToLinearHeading(new Pose2d(60.5, 54.5, Math.toRadians(-135)), Math.toRadians(55))
                .stopAndAdd(() -> {
                    scoringMechanism.deposit.openClaw();
                    scoringMechanism.update();
                })
                .waitSeconds(0.25)


                .waitSeconds(30)


                // PARK

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

