package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;

public class Robot {
    // https://gm0.org/en/latest/docs/software/getting-started/common-hardware-components.html
    public MecanumDrive drive;
    // public ArmSubsystem arm;
    public Intake intake;

    public Shooter shooter;

    public void init(HardwareMap hwMap) {

        drive = new MecanumDrive(

             hwMap.get(DcMotor.class, "frontRight"),
             hwMap.get(DcMotor.class, "backLeft"),
             hwMap.get(DcMotor.class, "frontLeft"),
             hwMap.get(DcMotor.class, "backRight"),
             hwMap.get(IMU.class, "imu")
         );
        //Build in teleop later `
        intake = new Intake(

                hwMap.get(DcMotor.class, "intakeMotor")
                );

        shooter = new Shooter(

            hwMap.get(DcMotor.class, "shooterMotor"),
            hwMap.get(Servo.class, "shooterServo")
        );

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
