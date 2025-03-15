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


@Config
@Autonomous(name = "NoBucketsAuto", group = "Autonomous")
public class NoBucketsAuto extends LinearOpMode {
    public void runOpMode() {
        // instantiate your MecanumDrive at a particular pose.

        ScoringMechanism scoringMechanism = new ScoringMechanism(hardwareMap);

        Pose2d beginPose = new Pose2d(-8.8, 61.4, Math.toRadians(180));
        PinpointDrive drive = new PinpointDrive(hardwareMap, beginPose);
        waitForStart();

        Actions.runBlocking(
                drive.actionBuilder(beginPose)
                        .setTangent(-Math.PI/2)
                        .splineToLinearHeading(new Pose2d(-9,40,Math.PI/2), -Math.PI/2)
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
                        .setTangent(-Math.PI/2)
                        .splineToLinearHeading(new Pose2d(-66.5,12,Math.PI/2), -Math.PI)
                        .setTangent(Math.PI/2)
                        .lineToY(47)
                        .setTangent(0)

                        .splineToLinearHeading(new Pose2d(-48,51,Math.PI/2), Math.PI/2)
                        .stopAndAdd(() -> scoringMechanism.deposit.specGrab())
                        .waitSeconds(1)
                        .stopAndAdd(() -> scoringMechanism.deposit.closeClaw())
                        .setTangent(Math.toRadians(90))
                        .lineToY(54.5)
                          .waitSeconds(1)
                             .afterTime(0.5, () -> scoringMechanism.deposit.specPlace())
                        .setTangent(Math.toRadians(-45))
                        .splineToConstantHeading(new Vector2d(-8, 36), -Math.PI / 2) //changed to a little higher?
                          .waitSeconds(1)
                        .setTangent(Math.toRadians(135))
                        .splineToLinearHeading(new Pose2d(-48, 51, Math.PI/2), Math.PI/2)
                          .stopAndAdd(() -> scoringMechanism.deposit.specGrab())
                        .setTangent(Math.toRadians(90))
                          .waitSeconds(1)
                        .lineToY(54.5)
                          .waitSeconds(1)
                        .setTangent(Math.toRadians(-45))
                        .splineToConstantHeading(new Vector2d(-8, 36), -Math.PI / 2)
                          .waitSeconds(1)
                        .setTangent(Math.toRadians(135))
                        .splineToLinearHeading(new Pose2d(-48, 51, Math.PI/2), Math.PI/2)
                          .stopAndAdd(() -> scoringMechanism.deposit.specGrab())
                        .setTangent(Math.toRadians(90))
                        .waitSeconds(1)
                        .lineToY(55)
                        .waitSeconds(1)
                        .setTangent(Math.toRadians(-45))
                        .splineToConstantHeading(new Vector2d(-8, 36), -Math.PI / 2)
                        // .waitSeconds(1)
//Parking for no Buckets
                       // .setTangent(Math.PI/2)
                       // .splineToLinearHeading(new Pose2d(-52, 56, -Math.PI/2), Math.PI/2)
                       .build());


             /* Parking submersible
             .setTangent(Math.PI)
                .lineToX(-32)
                .splineToLinearHeading(new Pose2d(-32, 0, Math.PI/2), -Math.PI / 4)
*/

    }
}