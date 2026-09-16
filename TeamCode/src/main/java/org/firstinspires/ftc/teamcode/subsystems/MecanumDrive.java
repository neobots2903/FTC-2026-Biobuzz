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
    public void drive(){}
}
