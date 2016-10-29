package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Jason Horn on 10/29/2016.
 */
@Autonomous
public class VoltageOpMode extends OpMode {
    DcMotor Right;
    DcMotor Left;

    @Override
    public void init() {
        Right = hardwareMap.dcMotor.get("motor_2");
        Left = hardwareMap.dcMotor.get("motor_1");
        Left.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        Right.setPower(0.75);
        Left.setPower(0.75);
    }
}


