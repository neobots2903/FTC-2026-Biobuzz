package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.util.LUT;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.arcrobotics.ftclib.util.InterpLUT;
public class Shooter {
    double shooterPowah = 0.0;
    DcMotorEx shooterMotor;
    Servo shooterServo;
    private DcMotor intakeMotor;
    private CRServo intakeFlywheel;
    private boolean pollenNectar = true; //pollen is true, nectar is false
    private final double pollenSpeed = 0.82;
    private final double nectarSpeed = 0.78;
    double shooterVelocitySetPoint = 0;
    double shooterMotorTicks = 28;
    private final InterpLUT distanceTable =new InterpLUT();
///Shooter motor has 28 encoder ticks and no gear reduction, shooter flywheel diameter is 3.5 inches
    public void spin(double power) {
        intakeMotor.setPower(power);
    }


    public Shooter(DcMotorEx sMotor, DcMotor iMotor, Servo sAdjuster, CRServo iServo) {
        shooterMotor = sMotor;
        shooterServo = sAdjuster;
        intakeMotor = iMotor;
        intakeFlywheel = iServo;
        distanceTable.add(65.5,2500.0);
        distanceTable.add(10.0,1500.0);
        distanceTable.add(15.0,2000.0);
        distanceTable.createLUT();
    }
    public void indexSpin(double indexSpeed){
        intakeFlywheel.setPower(indexSpeed);
    }
    public void shooterSpin(double rightTriggerValue){
        this.shooterPowah = rightTriggerValue;
        shooterMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
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
    //Checks if shooter is at correct RPM
    public boolean readyToShoot () {
        if ((shooterVelocitySetPoint + 200) > getRPM() && getRPM() > (shooterVelocitySetPoint - 200)) {
            return true;
        } else {
            return false;
        }
    }
    public void shooterState(){
        this.pollenNectar = !pollenNectar;
    }
    /*Function below calculates shooter ticks per second by dividing RPM by 60 seconds and
    multiplies that result by 28, aka the shooter motor ticks per revolution*/
    public void setShooterRPM(int RPM){
        shooterVelocitySetPoint = RPM;
        shooterMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        double shooterVelocity = (RPM / 60.0) * shooterMotorTicks;
        shooterMotor.setVelocity(shooterVelocity);
    }
    public double distanceToRPM(double distance){
        return distanceTable.get(distance);

    }
    public double getSetPoint(){
        return shooterVelocitySetPoint;
    }
}
