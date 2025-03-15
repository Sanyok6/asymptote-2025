package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

public class Intake {

    public Servo servo;
    public Servo gate;
    public DcMotorEx motor;

    public double motorPower = 0;

    public Intake(HardwareMap hardwareMap) {
        servo = hardwareMap.servo.get("intakeServo");
        gate = hardwareMap.servo.get("intakeGate");
        motor = hardwareMap.get(DcMotorEx.class, "intakeMotor");
    }

    public void align() {
        servo.setPosition(0.35);
        closeGate();
    }

    public void lower() {
        servo.setPosition(0.1);
        closeGate();
    }

    public void transfer() {
        servo.setPosition(0.35);
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

    public void openGate() { gate.setPosition(0); }

    public void closeGate() { gate.setPosition(0.6); }

    public void update() {
        if (motor.getCurrent(CurrentUnit.AMPS) > 7.5) {
            motor.setPower(-0.8);
        } else {
            motor.setPower(motorPower);
        }
    }

}
