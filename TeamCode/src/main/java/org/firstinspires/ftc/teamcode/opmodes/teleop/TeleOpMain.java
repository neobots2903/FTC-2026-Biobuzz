package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Robot;

@TeleOp(name = "Main TeleOp", group = "Competition")
public class TeleOpMain extends LinearOpMode {
    private final Robot robot = new Robot();

    @Override
    public void runOpMode() {
         robot.init(hardwareMap);

        // telemetry.addData("Status", "Initialized");
        // telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.options){
                robot.drive.yawReset();
            }

            robot.drive.drive(gamepad1.left_stick_y, gamepad1.left_stick_x, -gamepad1.right_stick_x);
            if (gamepad2.a){
                robot.shooter.spin(1.0);
            }
            if (gamepad2.x){
                robot.shooter.spin(-1.0);
            }
            if (gamepad2.aWasReleased()||gamepad2.xWasReleased()){
                robot.shooter.spin(0.0);
            }
            robot.shooter.shooterSpin(gamepad2.right_trigger);
            if (gamepad2.a){
                robot.shooter.shooterMove(0.25);
                //we gotta find the numbers later
            }
            if (gamepad2.x){
                robot.shooter.shooterMove(0.75);
                // find the numbers later
            }
            // https://gm0.org/en/latest/docs/software/tutorials/gamepad.html
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
            // https://gm0.org/en/latest/docs/software/tutorials/using-telemetry.html
            // telemetry.addData("Arm State", robot.arm.getState());
            // telemetry.update();
            double shooterSpeed = robot.shooter.getShooterSpeed();
            telemetry.addLine(Double.toString(shooterSpeed));
            telemetry.update();
        }
    }
}
