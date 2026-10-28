package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Shooter {

    DcMotor shooterMotor;
    Servo shooterServo;

    public Shooter(DcMotor sMotor, Servo sAdjuster) {
        shooterMotor = sMotor;
        shooterServo = sAdjuster;
    }
    public void shooterSpin(double vroom){
        shooterMotor.setPower(vroom);
    };
    public void shooterMove(double move){
        shooterServo.setPosition(move);
    }
}
