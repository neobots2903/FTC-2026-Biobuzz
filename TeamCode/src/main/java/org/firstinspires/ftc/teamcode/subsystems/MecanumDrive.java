package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class MecanumDrive {
    // TODO: Implement
    // https://gm0.org/en/latest/docs/software/tutorials/mecanum-drive.html
    DcMotor backLeft;
    DcMotor backRight;
    DcMotor frontLeft;
    DcMotor frontRight;
    public IMU imu;


    MecanumDrive (DcMotor fR, DcMotor bL, DcMotor fL, DcMotor bR, IMU imu){
        backLeft = bR;
        backRight = bR;
        frontLeft = fL;
        frontRight = fR;
        imu = imu;
    }
    public void yawReset(){
        imu.resetYaw();
    };
    public void drive(double leftStickY, double leftStickX, double rightStickX) {
        //Getting angle
        double direction = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
        //rotating the movement counter to the bot rotating
        double rotX = leftStickX * Math.cos(-direction) - leftStickY * Math.sin(-direction);
        double rotY = leftStickX * Math.sin(-direction) + leftStickY * Math.cos(-direction);
        //Math for getting the power for the motors
        double denominator = Math.max(Math.abs(leftStickY) + Math.abs(leftStickX) + Math.abs(rightStickX), 1);
        double frontLeftPower = (rotY + rotX + rightStickX) / denominator;
        double frontRightPower = (rotY - rotX - rightStickX) / denominator;
        double backLeftPower = (rotY - rotX + rightStickX) / denominator;
        double backRightPower = (rotY + rotX - rightStickX) / denominator;
        //Getting the motors the values from the math above
        backLeft.setPower(backLeftPower);
        backRight.setPower(backRightPower);
        frontLeft.setPower(frontLeftPower);
        frontRight.setPower(frontRightPower);
    }
}
