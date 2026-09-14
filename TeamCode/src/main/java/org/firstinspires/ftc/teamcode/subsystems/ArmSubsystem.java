package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class ArmSubsystem {
    // https://gm0.org/en/latest/docs/software/concepts/finite-state-machines.html
    public enum State { STOWED, SCORING, DROPPING }

    private final DcMotor armMotor;
    private final Servo clawServo;
    private final ElapsedTime timer = new ElapsedTime();
    private State state = State.STOWED;

    public ArmSubsystem(DcMotor armMotor, Servo clawServo) {
        this.armMotor = armMotor;
        this.clawServo = clawServo;
    }

    // High-level intent requested by driver or auto
    public void scoreHigh() {
        if (state == State.STOWED) {
            armMotor.setTargetPosition(2000);
            armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            armMotor.setPower(1.0);
            state = State.SCORING;
        }
    }

    public void stow() {
        armMotor.setTargetPosition(0);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(0.8);
        clawServo.setPosition(1.0);
        state = State.STOWED;
    }

    // Runs every single cycle
    public void update() {
        switch (state) {
            case SCORING:
                if (!armMotor.isBusy()) {
                    clawServo.setPosition(0.2); // Open claw
                    timer.reset();
                    state = State.DROPPING;
                }
                break;

            case DROPPING:
                if (timer.seconds() > 0.4) {
                    stow(); // Return to stow automatically
                }
                break;

            case STOWED:
                break;
        }
    }

    public State getState() { return state; }
}
