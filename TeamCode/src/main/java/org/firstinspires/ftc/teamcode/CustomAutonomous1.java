package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Hardware;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;

/**
 * Created by Lori on 11/19/2016.
 */

@Autonomous (name=" Pushbot: Custom Autonomus 1 Red", group="Pushbot")
public class CustomAutonomous1 extends LinearOpMode {


    //Declare OpMode members...
    HardwarePushbot robot = new HardwarePushbot(); //Telling the code it's a Pushbot
    private ElapsedTime runtime = new ElapsedTime();

    static final double FORWARD_SPEED = 0.6;
    static final double TURN_SPEED = 0.5;

    //Robot's commands and actions will all start with this (robot.init(hardwareMap);.
    @Override
    public void runOpMode() {

        robot.init(hardwareMap);

        //Telling the robot to standby for autonomous launch.
        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        //Telling the robot to standby for Game Start.
        waitForStart();

        //When Game starts, Steps in this section will run, telling the robot to do certain actions.

        //Step 1: Drive forward for 3 seconds.
        robot.leftMotor.setPower(FORWARD_SPEED);
        robot.rightMotor.setPower(FORWARD_SPEED);
        runtime.reset ();
        while (opModeIsActive() && (runtime.seconds() < 1.5 )) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
            sleep(2000);

        }

        //Step 2: Spin Left for 0.75 seconds.
        robot.leftMotor.setPower(-TURN_SPEED);
        robot.rightMotor.setPower(TURN_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds()< 0.75)) {
            telemetry.addData("Path", "Leg 2: %2.5 S Elapsed", runtime.seconds());
            telemetry.update();
            sleep(2000);

        }
        //Step 3: Drive forward for 0.85 seconds, so that ColorSensor can detect <blank>.
        robot.leftMotor.setPower(FORWARD_SPEED);
        robot.rightMotor.setPower(FORWARD_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds()< 0.85)){
            telemetry.addData("Path", "Leg 3: %2.5 S Elapsed", runtime.seconds());
            telemetry.update();
            sleep(2000);

        }

        //Step 4: Stop the robot.
        robot.leftMotor.setPower(0);
        robot.rightMotor.setPower(0);

        sleep(30000);
    }

}



