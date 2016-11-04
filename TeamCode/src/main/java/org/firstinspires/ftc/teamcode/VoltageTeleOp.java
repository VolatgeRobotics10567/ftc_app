package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp(name = "VoltageTeleOp",group = "VoltageTeleOp")

public class VoltageTeleOp extends OpMode {

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
        double threshold = 0.1;
        telemetry.addData("Joystick_1","Y_1:"+Double.toString(gamepad1.left_stick_y));
        telemetry.addData("Joystick_2","Y_2:"+Double.toString(gamepad1.right_stick_y));
        if(Math.abs(gamepad1.left_stick_y)>threshold)
        {
            Left.setPower(gamepad1.left_stick_y);
        }
        else {
            Left.setPower(0.0);
        }

        if(Math.abs(gamepad1.right_stick_y)>threshold)
        {
            Right.setPower(gamepad1.right_stick_y);
        }
        else {
            Right.setPower(0.0);
        }

    }


}
