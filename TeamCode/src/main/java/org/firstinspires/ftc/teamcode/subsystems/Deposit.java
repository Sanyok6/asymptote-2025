package org.firstinspires.ftc.teamcode.subsystems;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Config
public class Deposit {
    // Servo Values Minimum 0, Max 0.8
    private Servo rightRotateServo;
//    private Servo leftRotateServo;
    private Servo pivotServo;
    private Servo clawServo;

    public Deposit(HardwareMap hardwareMap) {
        rightRotateServo = hardwareMap.servo.get("rightDepositRotate");
//        leftRotateServo = hardwareMap.servo.get("leftDepositRotate");
        pivotServo = hardwareMap.servo.get("depositPivot");
        clawServo = hardwareMap.servo.get("depositClaw");
    }

    public void transfer() {
        rightRotateServo.setPosition(0.35);
        pivotServo.setPosition(0.9);
    }
    public void drive() {
        rightRotateServo.setPosition(0.5);
        pivotServo.setPosition(0.9);
    }
    public void deposit()
    {
        rightRotateServo.setPosition(1);
        pivotServo.setPosition(0.1);
    }

    public void setClawPosition(double pos) {clawServo.setPosition(pos);}
    public void openClaw() {
        setClawPosition(0);
    }
    public void closeClaw() {
        setClawPosition(0.55);
    }

    public void specGrab() {
        rightRotateServo.setPosition(0.5);
        pivotServo.setPosition(0.5);
        openClaw();
    }
    public void specPlace() {
        rightRotateServo.setPosition(1);
        pivotServo.setPosition(0.1);
    }
}
