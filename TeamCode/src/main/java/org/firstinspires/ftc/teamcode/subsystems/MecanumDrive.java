package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
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

    double autoDriveMath = (28.0 * 12.0)/(3.0 * Math.PI);
    public void inchesToTicks(double inches){
        int autoDrivingTicks = (int) Math.round(autoDriveMath * inches);
        backLeft.setTargetPosition(backLeft.getCurrentPosition() + autoDrivingTicks);
        backRight.setTargetPosition(backRight.getCurrentPosition() + autoDrivingTicks);
        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() + autoDrivingTicks);
        frontRight.setTargetPosition(frontRight.getCurrentPosition() + autoDrivingTicks);
        commonThings();
    }
    public void leftAndRight(double inches){
        int autoDrivingTicks = (int) Math.round(autoDriveMath * inches);
        backLeft.setTargetPosition(backLeft.getCurrentPosition() - autoDrivingTicks);
        backRight.setTargetPosition(backRight.getCurrentPosition() - autoDrivingTicks);
        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() - autoDrivingTicks);
        frontRight.setTargetPosition(frontRight.getCurrentPosition() - autoDrivingTicks);
        commonThings();
    }
    public void commonThings(){
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setPower(0.5);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setPower(0.5);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setPower(0.5);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setPower(0.5);
    }
    public void stop(){
        backLeft.setPower(0.0);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setPower(0.0);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontLeft.setPower(0.0);
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setPower(0.0);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }
    public boolean areWeDone(){
        return backLeft.isBusy() || backRight.isBusy() || frontRight.isBusy() || frontLeft.isBusy();
    }
    public MecanumDrive (DcMotor fR, DcMotor bL, DcMotor fL, DcMotor bR, IMU imu){
        backLeft = bL;
        backRight = bR;
        frontLeft = fL;
        frontRight = fR;
        this.imu = imu;
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.LEFT));
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    public void yawReset(){
        imu.resetYaw();
    };
    public void drive(double leftStickY, double leftStickX, double rightStickX) {
        //Getting angle
        double direction = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
        //rotating the movement counter to the bot rotating
        double rotX = -leftStickX * Math.cos(direction) - leftStickY * Math.sin(direction);
        double rotY = leftStickX * Math.sin(direction) + leftStickY * Math.cos(direction);
        //Math for getting the power for the motors
        double denominator = Math.max(Math.abs(leftStickY) + Math.abs(leftStickX) + Math.abs(rightStickX), 1);
        double frontLeftPower = (rotY + rotX + rightStickX) / denominator;
        double frontRightPower = (rotY - rotX - rightStickX) / denominator;
        double backLeftPower = (rotY - rotX + rightStickX) / denominator;
        double backRightPower = (rotY + rotX - rightStickX) / denominator;
        //Getting power to motors
        backLeft.setPower(backLeftPower);
        backRight.setPower(backRightPower);
        frontLeft.setPower(frontLeftPower);
        frontRight.setPower(frontRightPower);
    }

}
