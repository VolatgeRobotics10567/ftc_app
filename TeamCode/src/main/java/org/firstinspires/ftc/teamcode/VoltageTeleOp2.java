package org.firstinspires.ftc.teamcode;



        import android.app.Activity;
        import android.view.View;

        import com.google.blocks.ftcrobotcontroller.runtime.BlocksOpMode;
        import com.qualcomm.robotcore.eventloop.opmode.AnnotatedOpModeRegistrar;
        import com.qualcomm.robotcore.eventloop.opmode.OpMode;
        import com.qualcomm.robotcore.eventloop.opmode.OpModeManager;
        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
        import com.qualcomm.robotcore.hardware.DcMotor;
        import com.qualcomm.robotcore.hardware.DcMotorSimple;
        import com.qualcomm.robotcore.hardware.HardwareDevice;
        import com.qualcomm.robotcore.hardware.HardwareMap;
        import com.qualcomm.robotcore.hardware.Servo;
        import com .qualcomm.robotcore.hardware.ColorSensor;
        import com.qualcomm.robotcore.eventloop.opmode.OpModeRegister;


/**
 * Created by Andrew on 10/29/2016.
 */

@TeleOp(name = "VoltageTeleOp2", group = "VoltageTeleOp2")

public class VoltageTeleOp2 extends OpMode {


    DcMotor Right;
    DcMotor Left;
    Servo Arm1;
    Servo Arm2;
    ColorSensor colorSensor;





    public void init ()  {
        Right = hardwareMap.dcMotor.get("motor_2");
        Left = hardwareMap.dcMotor.get("motor_1");
        Left.setDirection(DcMotor.Direction.REVERSE);
        Arm1 = hardwareMap.servo.get("servo_1");
        Arm2 = hardwareMap.servo.get("servo_2");
        colorSensor = hardwareMap.colorSensor.get("sensor_1");


    }

    public void loop() {

        double threshold = 0.1;

        telemetry.addData("Joystick_1","Y_1:" + Double.toString(gamepad1.left_stick_y));
        telemetry.addData("Joystick_2","Y_2:"+ Double.toString(gamepad2.right_stick_y));
        //Left side

        if (Math.abs(gamepad1.left_stick_y)>threshold)
        {
            Left.setPower(gamepad1.left_stick_y);
        }
        else
        {
            Left.setPower(0.0);
        }



        //Right side

        if (Math.abs(gamepad2.right_stick_y)>threshold)
        {
            Right.setPower(gamepad2.right_stick_y);
        }
        else
        {
            Right.setPower(0.0);
        }





        Right.setPower(0.75);
        Left.setPower(0.75);
        Arm1.scaleRange(0.2,0.8);
        Arm2.scaleRange(0.2,0.8);
        colorSensor.argb();



    }













}