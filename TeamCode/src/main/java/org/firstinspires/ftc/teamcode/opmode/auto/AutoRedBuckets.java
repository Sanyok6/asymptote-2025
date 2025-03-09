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
@Autonomous(name = "RedBUCKETS", group = "Autonomous")
public class AutoRedBuckets extends LinearOpMode {
    public void runOpMode() {
        // instantiate your MecanumDrive at a particular pose.
        Pose2d beginPose = new Pose2d(-32.8, -61.4, Math.toRadians(0));
        PinpointDrive drive = new PinpointDrive(hardwareMap, beginPose);

        ScoringMechanism scoringMechanism = new ScoringMechanism(hardwareMap);
        drive.actionBuilder(beginPose)
                .afterTime(0.5, () -> scoringMechanism.setPosition(ScoringMechanismPosition.DEPOSIT))
                .setTangent(Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(-59.7, -54,Math.toRadians(45)), Math.toRadians(135))
                .stopAndAdd(() -> scoringMechanism.deposit.openClaw())
                .waitSeconds(0.75)
                .afterTime(0.5, () -> {
                    scoringMechanism.setPosition(ScoringMechanismPosition.INTAKE_ALIGN);
                    scoringMechanism.horizontalSlide.setTargetPosition(200);})
                .setTangent(Math.toRadians(45))
                .splineToLinearHeading(new Pose2d(-50.8, -34.5,Math.toRadians(90)), Math.toRadians(90))
                .afterTime(0.5, () -> scoringMechanism.setPosition(ScoringMechanismPosition.DEPOSIT))
                .setTangent(Math.toRadians(-90))
                .splineToLinearHeading(new Pose2d(-59.7, -54.5,Math.toRadians(45)), Math.toRadians(-135))
                .stopAndAdd(() -> scoringMechanism.deposit.openClaw())
                .waitSeconds(0.75)
                .afterTime(0.5, () -> {
                    scoringMechanism.setPosition(ScoringMechanismPosition.INTAKE_ALIGN);
                    scoringMechanism.horizontalSlide.setTargetPosition(200);})
                .setTangent(Math.toRadians(-90))
                .splineToLinearHeading(new Pose2d(-60.5, -34.5,Math.toRadians(90)), Math.toRadians(-90))
                .afterTime(0.5, () -> scoringMechanism.setPosition(ScoringMechanismPosition.DEPOSIT))
                .waitSeconds(2)
                .setTangent(Math.toRadians(-90))
                .splineToLinearHeading(new Pose2d(-59.7, -54.4,Math.toRadians(45)), Math.toRadians(225))
                .stopAndAdd(() -> scoringMechanism.deposit.openClaw())
                .waitSeconds(0.75)
                .afterTime(0.5, () -> {
                    scoringMechanism.setPosition(ScoringMechanismPosition.INTAKE_ALIGN);
                    scoringMechanism.horizontalSlide.setTargetPosition(200);})
                .waitSeconds(2)
                .setTangent(Math.toRadians(45))
                .splineToLinearHeading(new Pose2d(-58.5, -34,Math.toRadians(135)), Math.toRadians(135))
                .waitSeconds(1)
                .afterTime(0.5, () -> scoringMechanism.setPosition(ScoringMechanismPosition.DEPOSIT))
                .setTangent(Math.toRadians(-45))
                .splineToLinearHeading(new Pose2d(-59.7, -54.4,Math.toRadians(45)), Math.toRadians(225))
                .stopAndAdd(() -> scoringMechanism.deposit.openClaw())
                .waitSeconds(1)
                .setTangent(Math.toRadians(70))
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