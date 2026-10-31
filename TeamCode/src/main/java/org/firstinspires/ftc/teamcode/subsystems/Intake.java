package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Intake {
    private DcMotor intakeMotor;
    private Servo intakeFlywheel;
    double diameter = 1.0;
    double circumference = diameter * Math.PI;
    public Intake(DcMotor motor, Servo servo) {
        intakeMotor = motor;
        intakeFlywheel = servo;
    }
    public void spin(double power) {
        intakeMotor.setPower(power);
    }
    public int intakeRPM;
}
