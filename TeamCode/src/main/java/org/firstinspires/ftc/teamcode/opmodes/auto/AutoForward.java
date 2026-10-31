package org.firstinspires.ftc.teamcode.opmodes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name = "Main Auto", group = "Competition")
public class AutoForward extends LinearOpMode {
     private final Robot robot = new Robot();
// blue auto 1 is 80 inches forward
// blue auto 2 is 23 inches forward, and we need to move to the right a little

    @Override
    public void runOpMode() {
        robot.init(hardwareMap);
        robot.drive.stop();
        // telemetry.addData("Status", "Initialized");
        // telemetry.update();

        waitForStart();
        robot.drive.inchesToTicks(80.0);
        }
    }

