package org.firstinspires.ftc.teamcode.opmode.auto;

// RR-specific imports

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.roadrunner.PinpointDrive;
import org.firstinspires.ftc.teamcode.subsystems.ScoringMechanism;
import org.firstinspires.ftc.teamcode.subsystems.ScoringMechanismPosition;


@Config
@Autonomous(name = "NoBucketsAuto", group = "Autonomous")
public class NoBuckets2Piece extends LinearOpMode {
    public void runOpMode() {
        // instantiate your MecanumDrive at a particular pose.

        ScoringMechanism scoringMechanism = new ScoringMechanism(hardwareMap);

        Pose2d beginPose = new Pose2d(-8.8, 61.4, Math.toRadians(180));
        PinpointDrive drive = new PinpointDrive(hardwareMap, beginPose);

        scoringMechanism.deposit.closeClaw();

        waitForStart();

        Actions.runBlocking(
                drive.actionBuilder(beginPose)
                        .setTangent(-Math.PI/2)
                        // MOVE FOR FIRST SPECIMEN

                        .stopAndAdd(() -> scoringMechanism.setPosition(ScoringMechanismPosition.SPEC_ALIGN))
                        .waitSeconds(1)

                        .splineToLinearHeading(new Pose2d(-9,40,Math.PI/2), -Math.PI/2)
                        .setTangent(Math.toRadians(-90))
                        .lineToY(34)
                        .waitSeconds(0.5)
                        .setTangent(Math.toRadians(180))

                        // CODE TO PLACE FIRST SPECIMEN

                        .stopAndAdd(() -> scoringMechanism.setPosition(ScoringMechanismPosition.SPEC_PLACE))
                        .waitSeconds(1)

                        // MOVING TO PICKUP SECOND SPECIMEN

                        .stopAndAdd(() -> scoringMechanism.setPosition(ScoringMechanismPosition.SPEC_GRAB))
                        .waitSeconds(1)

                        .splineToLinearHeading(new Pose2d(-48,51,Math.PI/2), Math.PI/2)
                        .waitSeconds(0.5)
                        .setTangent(Math.toRadians(-90))

                        .stopAndAdd(() -> scoringMechanism.setPosition(ScoringMechanismPosition.SPEC_ALIGN))
                        .waitSeconds(1)

                        // MOVE TO PLACE SECOND SPECIMEN

                        .splineToLinearHeading(new Pose2d(-9,40,Math.PI/2), 0)
                        .setTangent(Math.toRadians(-90))
                        .lineToY(34)


                        // CODE TO PLACE SECOND SPECIMEN

                        .stopAndAdd(() -> scoringMechanism.setPosition(ScoringMechanismPosition.SPEC_PLACE))
                        .waitSeconds(1)


                        // PUSHING 2 PIECES
                        .waitSeconds(0.5)
                        .setTangent(Math.toRadians(180))
                        .splineToLinearHeading(new Pose2d(-36,30,Math.PI/2), -Math.PI/2)
                        .setTangent(Math.toRadians(-90))
                        .splineToLinearHeading(new Pose2d(-48,16,Math.PI/2), Math.PI)
                        .setTangent(Math.PI/2)
                        .lineToY(47)
                        .setTangent(-Math.PI/2)
                        .splineToLinearHeading(new Pose2d(-62,12,Math.PI/2), -Math.PI)
                        .setTangent(Math.PI/2)
                        .lineToY(47)

                        // END OF PUSHING PIECES

                        // MOVING TO PICKUP THIRD SPECIMEN
                        .stopAndAdd(() -> scoringMechanism.setPosition(ScoringMechanismPosition.SPEC_GRAB))
                        .waitSeconds(1)

                        .splineToLinearHeading(new Pose2d(-48,51,Math.PI/2), Math.PI/2)
                        .setTangent(Math.toRadians(-45))

                        .stopAndAdd(() -> scoringMechanism.setPosition(ScoringMechanismPosition.SPEC_ALIGN))
                        .waitSeconds(1)

                        //MOVE TO PLACE THIRD SPECIMEN

                        .splineToConstantHeading(new Vector2d(-8, 36), -Math.PI / 2) //changed to a little higher?
                        .setTangent(Math.toRadians(-90))
                        .lineToY(34)
                        .waitSeconds(0.5)

                        // CODE FOR PLACING THIRD SPECIMEN

                        .stopAndAdd(() -> scoringMechanism.setPosition(ScoringMechanismPosition.SPEC_PLACE))
                        .waitSeconds(1)

                        // MOVING TO PICKUP FOURTH SPECIMEN

                        .stopAndAdd(() -> scoringMechanism.setPosition(ScoringMechanismPosition.SPEC_GRAB))
                        .waitSeconds(1)

                        .setTangent(Math.toRadians(135))
                        .splineToLinearHeading(new Pose2d(-48, 51, Math.PI/2), Math.PI/2)
                        .setTangent(Math.toRadians(-45))

                        .stopAndAdd(() -> scoringMechanism.setPosition(ScoringMechanismPosition.SPEC_ALIGN))
                        .waitSeconds(1)

                        // MOVE TO PLACE FOURTH SPECIMEN
                        .splineToConstantHeading(new Vector2d(-8, 36), -Math.PI / 2) //changed to a little higher?
                        .setTangent(Math.toRadians(-90))
                        .lineToY(34)

                        // CODE TO PLACE FOURTH SPECIMEN

                        .stopAndAdd(() -> scoringMechanism.setPosition(ScoringMechanismPosition.SPEC_PLACE))
                        .waitSeconds(1)


                        // PARK

                        .waitSeconds(0.5)
                        .setTangent(Math.toRadians(135))
                        .splineToLinearHeading(new Pose2d(-48, 51, Math.PI/2), Math.PI/2)

                        //    .setTangent(-Math.PI/2)
                        .build());



             /* Parking submersible
             .setTangent(Math.PI)
                .lineToX(-32)
                .splineToLinearHeading(new Pose2d(-32, 0, Math.PI/2), -Math.PI / 4)
*/

    }
}