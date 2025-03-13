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
            if ((horizontalSlide.getCurrentPosition() < 25 && horizontalSlide.getCurrentPosition() > -30)) { // if hslide position is right
                if (timeSincePositionChange.milliseconds() >= 1500) {
                    intake.stopIntake();
                    this.setPosition(ScoringMechanismPosition.DEPOSIT);
                } else if (timeSincePositionChange.milliseconds() >= 1000) {
                    intake.runIntake();
                    deposit.drive();
                } else if (timeSincePositionChange.milliseconds() >= 500) {
                    deposit.setClawPosition(0.5);
                    intake.openGate();
                } else {
                    deposit.transfer();
                    intake.transfer();
                    deposit.setClawPosition(0.2);
                    horizontalSlide.setTargetPosition(0);
                }
            } else {
                horizontalSlide.setTargetPosition(0);
                intake.transfer();
                deposit.drive();
                deposit.setClawPosition(0.2);
                timeSincePositionChange.reset();
            }
        } else if (position == ScoringMechanismPosition.DEPOSIT) {
            verticalSlide.setTargetPosition(3400);
            intake.transfer();
            deposit.deposit();
        }

        verticalSlide.update();
        intake.update();
    }
}
