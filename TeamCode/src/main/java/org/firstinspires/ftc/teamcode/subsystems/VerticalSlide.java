package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class VerticalSlide {

    public DcMotor frontMotor;
    public DcMotor backMotor;

    public double Kp = 0.003;
    public double Ki = 0;
    public double Kd = 0;

    //max: 1000
    public double targetPosition = 100;
    double integralSum = 0;
    double lastError = 0;
    ElapsedTime timer = new ElapsedTime();

    public VerticalSlide(HardwareMap hardwareMap) {
        frontMotor = hardwareMap.dcMotor.get("vslideFront");
        backMotor = hardwareMap.dcMotor.get("vslideBack");
    }

    // max: 3400
    public void setTargetPosition(int targetPosition) {
        this.targetPosition = targetPosition;
    }

    public void update() {

        // obtain the encoder position
        double encoderPosition = frontMotor.getCurrentPosition();
        // calculate the error
        double error = targetPosition - encoderPosition;

        // rate of change of the error
        double derivative = (error - lastError) / timer.seconds();

        // sum of all error over time
        integralSum = integralSum + (error * timer.seconds());

        double out = (Kp * error) + (Ki * integralSum) + (Kd * derivative);

        if (out > 0) {
            out = Math.min(out, 1);
        } else {
            out = Math.max(out, -1);
        }

        frontMotor.setPower(out);
        backMotor.setPower(out);

        lastError = error;

        // reset the timer for next time
        timer.reset();
    }
}

