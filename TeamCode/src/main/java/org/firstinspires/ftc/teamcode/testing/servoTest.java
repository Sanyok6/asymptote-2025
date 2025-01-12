package org.firstinspires.ftc.teamcode.testing;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Config
@TeleOp(name="arm position test", group="testing")
public class servoTest extends LinearOpMode {

    @Override
    public void runOpMode() {
        Telemetry telemetry = new MultipleTelemetry(this.telemetry, FtcDashboard.getInstance().getTelemetry());

       // DcMotorEx armRotate = hardwareMap.get(DcMotorEx.class, "armRotate");
       // DcMotorEx linearSlide = hardwareMap.get(DcMotorEx.class, "linearSlide");
        Servo one=hardwareMap.get(Servo.class,"rotation");
       // armRotate.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        int targetExtension = 0;

        double predictedExtension = 0;

        while (opModeIsActive()) {
            if(gamepad1.)
            telemetry.addData("Arm rotation: ", one.getPosition());
            telemetry.update();

        }
    }

}