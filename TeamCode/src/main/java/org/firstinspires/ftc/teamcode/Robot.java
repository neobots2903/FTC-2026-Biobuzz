package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;

public class Robot {
    // public MecanumDrive drive;
    // public ArmSubsystem arm;

    public void init(HardwareMap hwMap) {
        // 1. Build MecanumDrive
        // drive = new MecanumDrive(
        //     hwMap.get(DcMotor.class, "front_left"),
        //     hwMap.get(DcMotor.class, "back_left"),
        //     hwMap.get(DcMotor.class, "front_right"),
        //     hwMap.get(DcMotor.class, "back_right")
        // );

        // 2. Build ArmSubsystem
        // arm = new ArmSubsystem(
        //     hwMap.get(DcMotor.class, "arm_motor"),
        //     hwMap.get(Servo.class, "claw_servo")
        // );
    }

    // Update all internal state machines in one call
    // public void update() {
    //     drive.update();
    //     arm.update();
    // }
}
