package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

public class MecanumDrive {
    // TODO: Implement
    // https://gm0.org/en/latest/docs/software/tutorials/mecanum-drive.html
    DcMotor backLeft;
    DcMotor backRight;
    DcMotor frontLeft;
    DcMotor frontRight;

    MecanumDrive (DcMotor fR, DcMotor bL, DcMotor fL, DcMotor bR){
        backLeft = bR;
        backRight = bR;
        frontLeft = fL;
        frontRight = fR;
    }
    public void drive(double leftStickY, double leftStickX, double rightStickX) {
        //Math for getting the power for the motors
        double denominator = Math.max(Math.abs(leftStickY) + Math.abs(leftStickX) + Math.abs(rightStickX), 1);
        double frontLeftPower = (leftStickY + leftStickX + rightStickX) / denominator;
        double frontRightPower = (leftStickY - leftStickX - rightStickX) / denominator;
        double backLeftPower = (leftStickY - leftStickX + rightStickX) / denominator;
        double backRightPower = (leftStickY + leftStickX - rightStickX) / denominator;
        //Getting the motors the values from the math above
        backLeft.setPower(backLeftPower);
        backRight.setPower(backRightPower);
        frontLeft.setPower(frontLeftPower);
        frontRight.setPower(frontRightPower);
    }
}
