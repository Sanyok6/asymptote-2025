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
        ScoringMechanism scoringMechanism = new ScoringMechanism(hardwareMap);

        scoringMechanism.deposit.closeClaw();
        scoringMechanism.setPosition(ScoringMechanismPosition.INTAKE_ALIGN);

        waitForStart();
        Actions.runBlocking(
                drive.actionBuilder(beginPose)
                        .setTangent(Math.toRadians(135))
                        .splineToLinearHeading(new Pose2d(-53, -45,Math.toRadians(45)), Math.toRadians(135))
                        .waitSeconds(3)
                        .splineToLinearHeading(new Pose2d(-36,0,Math.toRadians(0)), Math.toRadians(0))
                        .build());

        scoringMechanism.verticalSlide.setTargetPosition(3400);

        while (scoringMechanism.verticalSlide.frontMotor.getCurrentPosition() < 3200) {
            scoringMechanism.update();
        }
        scoringMechanism.deposit.openClaw();

    }
}