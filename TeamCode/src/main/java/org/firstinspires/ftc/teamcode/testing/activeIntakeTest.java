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
import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

@Config
@TeleOp(name="active intake test", group="testing")
public class activeIntakeTest extends LinearOpMode {

    public static double intakeMotorPower = 0;
    public static double servoPosition = 0;

    @Override
    public void runOpMode() {
        Telemetry telemetry = new MultipleTelemetry(this.telemetry, FtcDashboard.getInstance().getTelemetry());

        DcMotorEx motor = hardwareMap.get(DcMotorEx.class,"intake");
        Servo servo = hardwareMap.get(Servo.class,"testServo");

        waitForStart();

        while (opModeIsActive()) {
            if (motor.getCurrent(CurrentUnit.AMPS) > 7) {
                motor.setPower(-0.8);
            } else {
                motor.setPower(intakeMotorPower);
            }

            servo.setPosition(servoPosition);

            telemetry.addData("Servo Position ", servo.getPosition());
            telemetry.addData("Motor current ", motor.getCurrent(CurrentUnit.AMPS));
            telemetry.update();
        }
    }

}