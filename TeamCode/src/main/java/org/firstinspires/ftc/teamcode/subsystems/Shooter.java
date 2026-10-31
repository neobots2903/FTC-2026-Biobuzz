package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

public class Shooter {
    double vroom = 0.0;
    DcMotorEx shooterMotor;
    Servo shooterServo;
    private DcMotor intakeMotor;
    private CRServo intakeFlywheel;


    public void spin(double power) {
        intakeMotor.setPower(power);
    }


    public Shooter(DcMotorEx sMotor, DcMotor iMotor, Servo sAdjuster, CRServo iServo) {
        shooterMotor = sMotor;
        shooterServo = sAdjuster;
        intakeMotor = iMotor;
        intakeFlywheel = iServo;
    }
    public void shooterSpin(double vroom){
        this.vroom = vroom;
        shooterMotor.setPower(vroom);
        if (getRPM()>2000){
            intakeFlywheel.setPower(1.0);
        }
    };
    public void shooterMove(double move){
        shooterServo.setPosition(move);
    }
    public double getShooterSpeed(){
        return vroom;
    }
    public int getRPM () {
        return (int)(shooterMotor.getVelocity() * 60) / 28;
    }
}
