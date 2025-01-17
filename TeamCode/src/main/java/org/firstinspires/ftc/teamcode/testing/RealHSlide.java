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
@TeleOp(name="servo position test", group="testing")
public class RealHSlide extends LinearOpMode {

    public static int targetPosition = 1;

    @Override
    public void runOpMode() {
       // Telemetry telemetry = new MultipleTelemetry(this.telemetry, FtcDashboard.getInstance().getTelemetry());

        DcMotorEx Hslide = hardwareMap.get(DcMotorEx.class,"hslide");
        Hslide.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        waitForStart();

        while (opModeIsActive()) {
            Hslide.setTargetPosition(targetPosition);
            telemetry.addData("Slide Position ", Hslide.getCurrentPosition());
            telemetry.update();
        }
    }

}