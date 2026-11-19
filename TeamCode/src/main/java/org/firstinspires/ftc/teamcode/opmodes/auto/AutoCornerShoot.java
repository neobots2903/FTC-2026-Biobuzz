package org.firstinspires.ftc.teamcode.opmodes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name = "AutoCornerShoot", group = "Competition")
public class AutoCornerShoot extends LinearOpMode {
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
        robot.drive.leftAndRight(60.0);
        while (robot.drive.areWeDone()) {
            idle();
            //This is where the shooting would happen
            //This is where shooter idle function would happen
            robot.drive.leftAndRight(-48.0);
            while (robot.drive.areWeDone()) {
                idle();
                robot.drive.inchesToTicks(80.0);
                while (robot.drive.areWeDone()) {
                    idle();
                }
            }
        }

    }
}