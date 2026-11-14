package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

public class Shooter {
    double shooterPowah = 0.0;
    DcMotorEx shooterMotor;
    Servo shooterServo;
    private DcMotor intakeMotor;
    private CRServo intakeFlywheel;
    private boolean pollenNectar = true; //pollen is true, nectar is false
    private final double pollenSpeed = 0.82;
    private final double nectarSpeed = 0.78;


    public void spin(double power) {
        intakeMotor.setPower(power);
    }


    public Shooter(DcMotorEx sMotor, DcMotor iMotor, Servo sAdjuster, CRServo iServo) {
        shooterMotor = sMotor;
        shooterServo = sAdjuster;
        intakeMotor = iMotor;
        intakeFlywheel = iServo;
    }
    public void indexSpin(double indexSpeed){
        intakeFlywheel.setPower(indexSpeed);
    }
    public void shooterSpin(double rightTriggerValue){
        this.shooterPowah = rightTriggerValue;
       if (pollenNectar) {
           shooterMotor.setPower(rightTriggerValue * pollenSpeed);
       }
       else {
           shooterMotor.setPower(rightTriggerValue * nectarSpeed);
       }
        /*if (getRPM()>1000){
            intakeFlywheel.setPower(-1.0);
        } else {
            intakeFlywheel.setPower(0.0);
        }*/

    };
    public void shooterMove(double move){
        shooterServo.setPosition(move);
    }
    public double getShooterSpeed(){
        return shooterPowah;
    }
    public int getRPM () {
        return (int)(shooterMotor.getVelocity() * 60) / 28;
    }

    public void shooterState(){
        this.pollenNectar = !pollenNectar;
    }
}
