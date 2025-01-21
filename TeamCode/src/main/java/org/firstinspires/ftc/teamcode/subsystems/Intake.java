package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Intake {

    public Servo diffyLeft;
    public Servo diffyRight;
    public Servo intakePivot;
    public Servo claw;

    public Intake(HardwareMap hardwareMap) {
        diffyLeft = hardwareMap.servo.get("diffyLeft");
        diffyRight = hardwareMap.servo.get("diffyRight");
        intakePivot = hardwareMap.servo.get("intakePivot");
        claw = hardwareMap.servo.get("intakeClaw");
    }

    public void align() {
        diffyLeft.setPosition(0.7);
        diffyRight.setPosition(0.1);
        intakePivot.setPosition(0.3);
    }

    public void lower() {
        diffyLeft.setPosition(0.8);
        diffyRight.setPosition(0.1);
        intakePivot.setPosition(0.7);
    }

    public void transfer() {
        diffyLeft.setPosition(0);
        diffyRight.setPosition(0.9);
        intakePivot.setPosition(0);
    }

    public void openClaw() {
        claw.setPosition(0);
    }

    public void closeClaw() {
        claw.setPosition(0.3);
    }

}
