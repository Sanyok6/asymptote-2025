package org.firstinspires.ftc.teamcode.testing;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.HorizontalSlide;

@Config
@TeleOp(name="Horizontal slide test", group="testing")
public class horizontalSlideTest extends LinearOpMode {

    public static int targetPosition = 0;

    @Override
    public void runOpMode() {
        // Telemetry telemetry a= new MultipleTelemetry(this.telemetry, FtcDashboard.getInstance().getTelemetry());

        HorizontalSlide horizontalSlide = new HorizontalSlide(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            horizontalSlide.setTargetPosition(targetPosition);

            telemetry.addData("Horizontal Slide Position ", horizontalSlide.getCurrentPosition());
            telemetry.update();
        }
    }

}