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

@Config
@TeleOp(name="Old horizontal slide test", group="testing")
public class RealHSlide extends LinearOpMode {

    public static int targetPosition = 1;

    @Override
    public void runOpMode() {
       // Telemetry telemetry = new MultipleTelemetry(this.telemetry, FtcDashboard.getInstance().getTelemetry());

        DcMotorEx hslide = hardwareMap.get(DcMotorEx.class,"hslide");
        hslide.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        hslide.setTargetPosition(200);
        hslide.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        hslide.setPower(0.3);

        while (opModeIsActive()) {
            telemetry.addData("Horizontal Slide Position ", hslide.getCurrentPosition());
            telemetry.update();
        }
    }

}