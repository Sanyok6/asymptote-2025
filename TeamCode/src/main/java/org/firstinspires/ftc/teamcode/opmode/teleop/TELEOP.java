package org.firstinspires.ftc.teamcode.opmode.teleop;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.roadrunner.MecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.ScoringMechanism;
import org.firstinspires.ftc.teamcode.subsystems.ScoringMechanismPosition;

@Config
@TeleOp(name="TELEOP", group="opmode")
public class TELEOP extends LinearOpMode {

    @Override
    public void runOpMode() {

        ScoringMechanism scoringMechanism = new ScoringMechanism(hardwareMap);

        int targetHslidePos = 0;
        int targeVslidePos = 0;

        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0,0,0));

        waitForStart();


        while (opModeIsActive()) {

            double x = -gamepad1.left_stick_y; // Remember, Y stick value is reversed
            double y = -gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = -gamepad1.right_stick_x;

//            // Denominator is the largest motor power (absolute value) or 1
//            // This ensures all the powers maintain the same ratio,
//            // but only if at least one is out of the range [-1, 1]
//            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
//            double frontLeftPower = (y + x + rx) / denominator;
//            double backLeftPower = (y - x + rx) / denominator;
//            double frontRightPower = (y - x - rx) / denominator;
//            double backRightPower = (y + x - rx) / denominator;

            drive.setDrivePowers(
                    new PoseVelocity2d(
                            new Vector2d(x, y),
                            rx
                    )
            );


            if (targetHslidePos < 400 && gamepad1.dpad_up) {
                targetHslidePos += 2;
                scoringMechanism.horizontalSlide.setTargetPosition(targetHslidePos);
            } else if (targetHslidePos > 0 && gamepad1.dpad_down) {
                targetHslidePos -= 2;
                scoringMechanism.horizontalSlide.setTargetPosition(targetHslidePos);
            }

            if (gamepad1.a) {
                if (scoringMechanism.horizontalSlide.getCurrentPosition() > 100) {
                    scoringMechanism.setPosition(ScoringMechanismPosition.INTAKE_LOWER);
                }
            } else if (gamepad1.b) {
                scoringMechanism.setPosition(ScoringMechanismPosition.INTAKE_ALIGN);
            } else if (gamepad1.x) {
                scoringMechanism.setPosition(ScoringMechanismPosition.TRANSFER);
            } else if (gamepad1.y) {
                scoringMechanism.setPosition(ScoringMechanismPosition.DEPOSIT);
            } else if (gamepad1.right_trigger > 0.5) {
//                if (scoringMechanism.getCurrentPosition() == ScoringMechanismPosition.INTAKE_LOWER) {
//                    scoringMechanism.intake.runIntake();
//                } else
//                    if (scoringMechanism.getCurrentPosition() == ScoringMechanismPosition.DEPOSIT) {
//                        scoringMechanism.deposit.openClaw();
//                    }
                scoringMechanism.deposit.openClaw();
            } else {
                if (scoringMechanism.getCurrentPosition() == ScoringMechanismPosition.INTAKE_LOWER) {
                    scoringMechanism.intake.runIntake();
                }
                scoringMechanism.intake.stopIntake();
            }

            scoringMechanism.update();

            telemetry.update();
        }
    }

}