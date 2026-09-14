package org.firstinspires.ftc.teamcode.opmodes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;

@Autonomous(name = "Main Auto", group = "Competition")
public class AutoMain extends LinearOpMode {
    // private final Robot robot = new Robot();

    // Example autonomous routine steps
    // private enum AutoStep {
    //     DRIVE_TO_TARGET,
    //     SCORE_PRELOAD,
    //     WAIT_FOR_ARM,
    //     PARK,
    //     DONE
    // }
    // private AutoStep currentStep = AutoStep.DRIVE_TO_TARGET;

    @Override
    public void runOpMode() {
        // robot.init(hardwareMap);

        // telemetry.addData("Status", "Initialized");
        // telemetry.update();

        // waitForStart();

        while (opModeIsActive()) {
            // Autonomous state machine: sequences steps while keeping robot.update() ticking
            // switch (currentStep) {
            //     case DRIVE_TO_TARGET:
            //         // Fake drive forward
            //         // robot.drive.driveCartesian(0.5, 0, 0);
            //         // if (/* reached target */ false) {
            //         //     robot.drive.driveCartesian(0, 0, 0);
            //         //     robot.arm.scoreHigh(); // Kick off arm state machine
            //         //     currentStep = AutoStep.WAIT_FOR_ARM;
            //         // }
            //         break;
            //
            //     case WAIT_FOR_ARM:
            //         // Subsystem state machine automatically runs in background via robot.update()
            //         // Once arm completes its scoring and stowing routine:
            //         // if (robot.arm.getState() == ArmSubsystem.State.STOWED) {
            //         //     currentStep = AutoStep.PARK;
            //         // }
            //         break;
            //
            //     case PARK:
            //         // Fake park movement
            //         // robot.drive.driveCartesian(0, 0.5, 0);
            //         // currentStep = AutoStep.DONE;
            //         break;
            //
            //     case DONE:
            //         // robot.drive.driveCartesian(0, 0, 0);
            //         break;
            // }

            // Heartbeat: advances subsystem timers & state machines during auto
            // robot.update();

            // telemetry.addData("Auto Step", currentStep);
            // telemetry.addData("Arm State", robot.arm.getState());
            // telemetry.update();
        }
    }
}
