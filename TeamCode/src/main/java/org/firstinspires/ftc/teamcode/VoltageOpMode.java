package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Jason Horn on 10/29/2016.
 */
@Autonomous
public class VoltageOpMode extends OpMode {
    DcMotor Right;
    DcMotor Left;
    Servo Arm;

    @Override
    public void init() {
        Right = hardwareMap.dcMotor.get("motor_2");
        Left = hardwareMap.dcMotor.get("motor_1");
        Left.setDirection(DcMotor.Direction.REVERSE);
        Arm = hardwareMap.servo.get("motor_3");

        Arm.setPosition(0.8);



    }

    @Override
    public void loop() {

        Right.setPower(0.2);
        Left.setPower(0.2);
    }
}


