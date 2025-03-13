package org.firstinspires.ftc.teamcode.testing;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

@Config
@TeleOp(name="deposit servos test", group="testing")
public class depositServosTest extends LinearOpMode {

    public static double rightRotateServoPos = 1;
    public static double pivotServoPos = 0.5;
    public static double clawServoPos = 0;


    @Override
    public void runOpMode() {
        Telemetry telemetry = new MultipleTelemetry(this.telemetry, FtcDashboard.getInstance().getTelemetry());

        Servo rightRotateServo = hardwareMap.servo.get("rightDepositRotate");
        Servo pivotServo = hardwareMap.servo.get("depositPivot");
        Servo clawServo = hardwareMap.servo.get("depositClaw");

        waitForStart();

        while (opModeIsActive()) {
            rightRotateServo.setPosition(rightRotateServoPos);
            pivotServo.setPosition(pivotServoPos);
            clawServo.setPosition(clawServoPos);

            telemetry.update();
        }
    }

}