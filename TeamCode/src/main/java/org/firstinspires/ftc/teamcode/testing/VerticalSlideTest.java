package org.firstinspires.ftc.teamcode.testing;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.VerticalSlide;

@Config
@TeleOp(name="Vertical slide test", group="testing")
public class VerticalSlideTest extends LinearOpMode {

    public static int targetPosition = 0;

    public static double Kp = 0;
    public static double Ki = 0;
    public static double Kd = 0;

    @Override
    public void runOpMode() {
        Telemetry telemetry = new MultipleTelemetry(this.telemetry, FtcDashboard.getInstance().getTelemetry());

        VerticalSlide verticalSlide = new VerticalSlide(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            verticalSlide.Kp = Kp;
            verticalSlide.Ki = Ki;
            verticalSlide.Kd = Kd;

            verticalSlide.setTargetPosition(targetPosition);

            verticalSlide.update();

            telemetry.addData("Desired Position", verticalSlide.targetPosition);
            telemetry.addData("Current position", verticalSlide.frontMotor.getCurrentPosition());

            telemetry.update();
        }
    }
}