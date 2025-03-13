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
import org.firstinspires.ftc.teamcode.subsystems.ScoringMechanism;
import org.firstinspires.ftc.teamcode.subsystems.ScoringMechanismPosition;

@Config
@TeleOp(name="transfer test", group="testing")
public class transferTest extends LinearOpMode {

    @Override
    public void runOpMode() {
        ScoringMechanism scoringMechanism = new ScoringMechanism(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            scoringMechanism.setPosition(ScoringMechanismPosition.TRANSFER);
            scoringMechanism.update();
        }
    }

}