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
@Autonomous(name = "RedBuckets", group = "Autonomous")
public class AutoRedBuckets extends LinearOpMode {
    public void runOpMode() {
        // instantiate your MecanumDrive at a particular pose.
        Pose2d beginPose = new Pose2d(-32.8, -61.4, Math.toRadians(0));
        PinpointDrive drive = new PinpointDrive(hardwareMap, beginPose);
       // ScoringMechanism scoringMechanism = new ScoringMechanism(hardwareMap);
       // scoringMechanism.deposit.closeClaw();
       // scoringMechanism.setPosition(ScoringMechanismPosition.INTAKE_ALIGN);

        drive.actionBuilder(beginPose)
                .setTangent(Math.toRadians(135))
                .splineToLinearHeading(new Pose2d(-59.7, -54,Math.toRadians(45)), Math.toRadians(135))
                .waitSeconds(2)
                .setTangent(Math.toRadians(45))
                .waitSeconds(0.6)
                .splineToLinearHeading(new Pose2d(-50.8, -34.5,Math.toRadians(90)), Math.toRadians(90))
                // .turn(Math.toRadians(45))
                // .strafeTo(new Vector2d(48,46))
                .waitSeconds(2)
                //   .turn(Math.toRadians(-45))
                .setTangent(Math.toRadians(0))
                .splineToLinearHeading(new Pose2d(-59.7, -54.5,Math.toRadians(45)), Math.toRadians(-135))
                .waitSeconds(2)
                .setTangent(Math.toRadians(-90))
                .splineToLinearHeading(new Pose2d(-60.5, -34.5,Math.toRadians(90)), Math.toRadians(-90))
                .waitSeconds(2)
                .setTangent(Math.toRadians(-90))
                .splineToLinearHeading(new Pose2d(-59.7, -54.4,Math.toRadians(45)), Math.toRadians(225))
                .waitSeconds(2)
                //   .splineToLinearHeading(new Pose2d(56,40,Math.toRadians(-45)), -Math.PI/4)
                //     .waitSeconds(1)
                //       .splineToLinearHeading(new Pose2d(56, 54,Math.toRadians(-135)), Math.toRadians(45))
                .waitSeconds(1).setTangent(Math.toRadians(70))
                .splineToLinearHeading(new Pose2d(-34,0,Math.toRadians(0)), Math.toRadians(0))

                .build();
      //  waitForStart();
/*        Actions.runBlocking(


        scoringMechanism.verticalSlide.setTargetPosition(3400);

        while (scoringMechanism.verticalSlide.frontMotor.getCurrentPosition() < 3200) {
            scoringMechanism.update();
        }
        scoringMechanism.deposit.openClaw();
*/
    }
}