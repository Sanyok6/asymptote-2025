package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class HorizontalSlide {

    DcMotorEx motor;
    int targetPosition = 0;


    public HorizontalSlide(HardwareMap hardwareMap) {
        motor = hardwareMap.get(DcMotorEx.class, "hslide");
        motor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void setTargetPosition(int targetPosition) {
        if (this.targetPosition != targetPosition) {
            this.targetPosition = targetPosition;

            motor.setTargetPosition(this.targetPosition);
            motor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            motor.setPower(1);
        }
    }

    public int getCurrentPosition() {
        return motor.getCurrentPosition();
    }
}