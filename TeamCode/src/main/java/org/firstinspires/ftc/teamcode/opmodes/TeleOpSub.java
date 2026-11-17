package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Robot;

@TeleOp(name = "Vision Testing", group = "Competition")
public class TeleOpSub extends LinearOpMode {
    private final Robot robot = new Robot();
    private int testingRPM = 2000;
    @Override
    public void runOpMode() {
        robot.init(hardwareMap);

        // telemetry.addData("Status", "Initialized");
        // telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            if(gamepad1.right_trigger_pressed){
                robot.shooter.shooterSpin(testingRPM);}
            if(gamepad1.a){
                this.testingRPM = testingRPM + 100;
            }
            if(gamepad1.b){
                this.testingRPM = testingRPM - 100;
            }
            double shooterSpeed = robot.shooter.getRPM();
            telemetry.addLine(String.format("\n==== (Shooter RPM: %d) ", robot.shooter.getRPM()));
            telemetry.addLine(String.format("\n==== (Distance: %d)", robot.Apriltag.getDistanceFromHiveStructure()));
            //robot.Apriltag.telemetryAprilTag(telemetry);
            telemetry.update();
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
        }
    }


