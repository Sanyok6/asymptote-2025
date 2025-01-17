package org.firstinspires.ftc.teamcode.testing;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

@Config
@TeleOp(name="Intake test", group="testing")
public class intakeTest extends LinearOpMode {

    public static double diffyLeftPos = 0.4;
    public static double diffyRightPos = 0.5;
    public static double pivotPos = 0.5;
    public static double clawPos = 0;

    @Override
    public void runOpMode() {
        Telemetry telemetry = new MultipleTelemetry(this.telemetry, FtcDashboard.getInstance().getTelemetry());

        Intake intake = new Intake(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            intake.diffyLeft.setPosition(diffyLeftPos);
            intake.diffyRight.setPosition(diffyRightPos);
            intake.intakePivot.setPosition(pivotPos);
            intake.claw.setPosition(clawPos);

            telemetry.addData("Left diffy servo pos: ", intake.diffyLeft.getPosition());
            telemetry.addData("Right diffy servo pos: ", intake.diffyRight.getPosition());
            telemetry.addData("Pivot servo pos: ", intake.intakePivot.getPosition());
            telemetry.addData("Claw servo pos: ", intake.claw.getPosition());


            telemetry.update();
        }
    }

}