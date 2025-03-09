package org.firstinspires.ftc.teamcode.testing;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

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
                deposit.transfer();
            } else if(gamepad1.b == true) {
                deposit.deposit();
            } else if (gamepad1.x == true) {
                deposit.specGrab();
            } else if (gamepad1.y == true) {
                deposit.specPlace();
            }


        }
    }

}