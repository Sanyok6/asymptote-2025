package org.firstinspires.ftc.teamcode.testing;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Config
@TeleOp(name="servo position test", group="testing")
public class colorSensorTest extends LinearOpMode {

    public static double targetPosition = 0;

    @Override
    public void runOpMode() {
        Telemetry telemetry = new MultipleTelemetry(this.telemetry, FtcDashboard.getInstance().getTelemetry());

        ColorSensor colorSensor = hardwareMap.colorSensor.get("colorSensor");

        waitForStart();

        while (opModeIsActive()) {
            if (colorSensor.red() > colorSensor.green() && colorSensor.red() > colorSensor.blue()) {
                telemetry.addLine("RED");
            } else if (colorSensor.green() > colorSensor.blue()) {
                telemetry.addLine("GREEN");
            } else {
                telemetry.addLine("BLUE");
            }

            telemetry.addData("R", colorSensor.red());
            telemetry.addData("G", colorSensor.green());
            telemetry.addData("B", colorSensor.blue());

            telemetry.update();
        }
    }

}