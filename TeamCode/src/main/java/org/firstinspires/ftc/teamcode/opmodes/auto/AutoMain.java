package org.firstinspires.ftc.teamcode.opmodes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;

@Autonomous(name = "Main Auto", group = "Competition")
public class AutoMain extends LinearOpMode {
     private final Robot robot = new Robot();


    @Override
    public void runOpMode() {
        robot.init(hardwareMap);

        // telemetry.addData("Status", "Initialized");
        // telemetry.update();

        waitForStart();

        }
    }
}
