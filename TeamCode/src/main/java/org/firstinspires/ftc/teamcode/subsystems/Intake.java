package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

public class Intake {

    public Servo servo;
    public DcMotorEx motor;

    public double motorPower = 0;

    public Intake(HardwareMap hardwareMap) {
        servo = hardwareMap.servo.get("intakeServo");
        motor = hardwareMap.get(DcMotorEx.class, "intakeMotor");
    }

    public void align() {
        servo.setPosition(0.25);
    }

    public void lower() {
        servo.setPosition(0.1);
        runIntake();
    }

    public void transfer() {
        servo.setPosition(0.25);
    }


    public void runIntake(double power) {
        motorPower = power;
    }

    public void runIntake() {
        runIntake(1);
    }

    public void stopIntake() {
        runIntake(0);
    }

    public void update() {
        if (motor.getCurrent(CurrentUnit.AMPS) > 7) {
            motor.setPower(-0.8);
        } else {
            motor.setPower(motorPower);
        }
    }

}
