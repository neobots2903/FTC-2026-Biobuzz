package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Main TeleOp", group = "Competition")
public class TeleOpMain extends LinearOpMode {
    // private final Robot robot = new Robot();

    @Override
    public void runOpMode() {
        // robot.init(hardwareMap);

        // telemetry.addData("Status", "Initialized");
        // telemetry.update();

        // waitForStart();

        while (opModeIsActive()) {
            // 1. Drive Control
            // robot.drive.driveCartesian(
            //     -gamepad1.left_stick_y,
            //      gamepad1.left_stick_x,
            //      gamepad1.right_stick_x
            // );

            // 2. Arm Trigger (One button kick-starts the state machine)
            // if (gamepad1.y) {
            //     robot.arm.scoreHigh();
            // } else if (gamepad1.b) {
            //     robot.arm.stow();
            // }

            // 3. Heartbeat: advances all subsystem timers & state machines
            // robot.update();

            // 4. Telemetry
            // telemetry.addData("Arm State", robot.arm.getState());
            // telemetry.update();
        }
    }
}
