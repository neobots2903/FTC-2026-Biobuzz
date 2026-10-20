package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Intake {
    private DcMotor intakeMotor;
    public Intake(DcMotor motor) {
        intakeMotor = motor;
    }
    public void spin(double power) {
        intakeMotor.setPower(power);
    }
}
