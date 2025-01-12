package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp
public class VerticalSlide extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        double Kp = 0;
        double Ki = 0;
        double Kd = 0;

        double reference = 100;

        double integralSum = 0;

        double lastError = 0;

        DcMotor frontMotor = hardwareMap.dcMotor.get("Arm Motor");
        DcMotor backMotor = hardwareMap.dcMotor.get("Arm Motor");

        // Elapsed timer class from SDK, please use it, it's epic
        ElapsedTime timer = new ElapsedTime();

        while (true) {

            // obtain the encoder position
            double encoderPosition =frontMotor.getCurrentPosition();
            // calculate the error
            double error = reference - encoderPosition;

            // rate of change of the error
            double derivative = (error - lastError) / timer.seconds();

            // sum of all error over time
            integralSum = integralSum + (error * timer.seconds());

            double out = (Kp * error) + (Ki * integralSum) + (Kd * derivative);

//                frontMotor.setPower(out);
//                backMotor.setPower(out);

            lastError = error;

            // reset the timer for next time
            timer.reset();


            // Show the target position of the armMotor on telemetry
            telemetry.addData("Desired Position", reference);
            telemetry.addData("Current position", frontMotor.getCurrentPosition());

            telemetry.update();
        }

    }
}

