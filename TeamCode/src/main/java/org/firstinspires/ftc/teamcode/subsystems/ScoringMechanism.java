package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class ScoringMechanism {
    ScoringMechanismPosition position = ScoringMechanismPosition.INTAKE_ALIGN;
    ElapsedTime timeSincePositionChange = new ElapsedTime();

    public Intake intake;
    public Deposit deposit;
    public VerticalSlide verticalSlide;

    public HorizontalSlide horizontalSlide;

    public ScoringMechanism(HardwareMap hardwareMap) {
        intake = new Intake(hardwareMap);
        deposit = new Deposit(hardwareMap);
        verticalSlide = new VerticalSlide(hardwareMap);
        horizontalSlide = new HorizontalSlide(hardwareMap);
    }

    public void setPosition(ScoringMechanismPosition position) {
        if (this.position != position) {
            this.position = position;
            timeSincePositionChange.reset();
        }
    }

    public ScoringMechanismPosition getCurrentPosition() {
        return position;
    }

    public void update() {
        if (position == ScoringMechanismPosition.INTAKE_ALIGN){
            intake.align();
            deposit.drive();
            verticalSlide.setTargetPosition(0);
        } else if (position == ScoringMechanismPosition.INTAKE_LOWER) {
            intake.lower();
            deposit.drive();
        } else if (position == ScoringMechanismPosition.TRANSFER) {
            if (timeSincePositionChange.milliseconds() >= 3000) {
                verticalSlide.setTargetPosition(3400);
            } else if (timeSincePositionChange.milliseconds() >= 2500) {
                intake.runIntake();
            } else if (timeSincePositionChange.milliseconds() >= 2000) {
                deposit.closeClaw();
            } else if (timeSincePositionChange.milliseconds() >= 1000) {
                deposit.transfer();
            } else {
                intake.transfer();
                deposit.drive();
                deposit.openClaw();
            }
        } else if (position == ScoringMechanismPosition.DEPOSIT) {
            intake.transfer();
            deposit.deposit();
        }

        verticalSlide.update();
        intake.update();
    }
}
