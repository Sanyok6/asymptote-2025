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
@Autonomous(name = "BLUENoBuckets", group = "Autonomous")
public class AutoBlueNoBuckets extends LinearOpMode {
    public void runOpMode() {
        // instantiate your MecanumDrive at a particular pose.
        Pose2d beginPose = new Pose2d(-8.8, 59, Math.toRadians(0));
        PinpointDrive drive = new PinpointDrive(hardwareMap, beginPose);
        waitForStart();
        Actions.runBlocking(
                drive.actionBuilder(beginPose)
                        .setTangent(Math.toRadians(-90))
                        .splineToLinearHeading(new Pose2d(-9,40,Math.PI/2), -Math.PI/2)
                     //   .strafeTo(new Vector2d(-9,38))
                       // .waitSeconds(1)
                        .setTangent(Math.PI)
                        //    .splineToConstantHeading(new Vector2d(-36, 12), -0.2*Math.PI)
                        .lineToX(-36)
                        .setTangent(Math.PI/2)
                        .lineToY(9)

                        .setTangent(Math.PI)
                        .lineToX(-47)
                        .setTangent(Math.PI/2)
                        .lineToY(42)
                        .setTangent(-Math.PI/2)
                        .splineToLinearHeading(new Pose2d(-60,10,Math.PI/2), -Math.PI)
                        .setTangent(Math.PI/2)
                        .lineToY(42)
                        .setTangent(-Math.PI/2)
                        .splineToLinearHeading(new Pose2d(-68,10,Math.PI/2), -Math.PI)
                        .setTangent(Math.PI/2)
                        .lineToY(42)
                        .setTangent(Math.PI/2)
                        .splineToLinearHeading(new Pose2d(-48,53,Math.PI/2), 0)
                        .waitSeconds(1)
                        .setTangent(Math.toRadians(0))
                        .splineToConstantHeading(new Vector2d(-8, 36), -Math.PI / 2) //changed to a little higher?
                        .waitSeconds(1)
                        .splineToConstantHeading(new Vector2d(-48, 53), Math.PI)
                        .waitSeconds(1)
                        .setTangent(Math.toRadians(0))
                        .splineToConstantHeading(new Vector2d(-8, 36), -Math.PI / 2)
                        .waitSeconds(1)
                        .splineToConstantHeading(new Vector2d(-48, 53), Math.PI)
                        .waitSeconds(1)
                        .setTangent(Math.toRadians(0))
                        .splineToConstantHeading(new Vector2d(-8, 36), -Math.PI / 2)
                        .waitSeconds(1)
//Parking for no Buckets
                        .splineToLinearHeading(new Pose2d(-52, 56, Math.PI/2), -3*Math.PI /2 )
                        .build());
             /* Parking submersible
             .setTangent(Math.PI)
                .lineToX(-32)
                .splineToLinearHeading(new Pose2d(-32, 0, Math.PI/2), -Math.PI / 4)
*/

    }
}