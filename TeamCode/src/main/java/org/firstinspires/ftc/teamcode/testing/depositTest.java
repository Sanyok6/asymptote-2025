package org.firstinspires.ftc.teamcode.testing;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.Deposit;
@Config
@TeleOp(name="depositTest", group="testing")
public class depositTest extends LinearOpMode {

    @Override
    public void runOpMode() {
        Deposit deposit =new Deposit(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            if(gamepad1.a == true)
            {
                deposit.transferPos();
            } else if(gamepad1.b == true) {
                deposit.depositPos();
            }


        }
    }

}