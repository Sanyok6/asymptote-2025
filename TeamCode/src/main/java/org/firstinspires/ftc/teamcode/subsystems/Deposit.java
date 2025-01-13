package org.firstinspires.ftc.teamcode.subsystems;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Config
public class Deposit {
    // Servo Values Minimum 0, Max 0.8
    private Servo rightRotateServo;
//    private Servo leftRotateServo;

    public Deposit(HardwareMap hardwareMap) {
        rightRotateServo = hardwareMap.servo.get("rightRotateServo");
//        leftRotateServo = hardwareMap.servo.get("leftRotateServo");
    }

    public void transferPos() {
        rightRotateServo.setPosition(0);
    }
    public void depositPos()
    {
        rightRotateServo.setPosition(0.8);
    }

}
