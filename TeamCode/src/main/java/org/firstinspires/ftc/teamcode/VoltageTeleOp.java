package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;




// This TeleOp mode was created by: Ethen Brandenburg on 10/29/16. It has the capability of driving forward and reverse and can
// also move the two servos. It also tells the driver how long the Op mode has been running.

@TeleOp(name="TeleOp_1", group="Linear Opmode")  // @Autonomous(...) is the other common choice

public class VoltageTeleOp extends LinearOpMode {

    /* Declare OpMode members. */
    private ElapsedTime runtime = new ElapsedTime();
    DcMotor motor_1 = null;
    DcMotor motor_2 = null;

    //Declare Servos
    Servo  servo_1 = null;
    Servo  servo_2 =null;

    //Default servo positions
    double servo_1_Max = 0.2;
    double servo_1_Min = 0.8;

    double servo_2_Min = 0.5;
    double servo_2_Max = -0.8;

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        //Initialize Motors
        motor_1  = hardwareMap.dcMotor.get("motor_1");
        motor_2 = hardwareMap.dcMotor.get("motor_2");

        // Initialize Servos
        servo_1 = hardwareMap.servo.get("servo_1");
        servo_2 = hardwareMap.servo.get("servo_2");

        // Set the drive motor directions
        motor_1.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        motor_2.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors

        //Set motor channel modes
        motor_1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor_2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Initialize servo positions to stay in the 18 inch box
        servo_1.setPosition(servo_1_Min);
        servo_2.setPosition(servo_2_Min);


        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();


            // Tank Mode (drive Forward and Reverse with the two thumb sticks)
            motor_1.setPower(-gamepad1.left_stick_y);
            motor_2.setPower(-gamepad1.right_stick_y);

            // Move servo 1 with a and b
            if (gamepad2.a)
            {
                servo_1.setPosition(servo_1_Max);
            }

            else if (gamepad2.b)
            {
                servo_1.setPosition(servo_1_Min);
            }

            // Move servo 2 with left and right bumper
            if (gamepad2.left_bumper)
            {
                servo_2.setPosition(servo_2_Max);
            }

            else if (gamepad2.right_bumper)
            {
                servo_2.setPosition(servo_2_Min);
            }
            idle(); // Always call idle() at the bottom of your while(opModeIsActive()) loop
        }
    }
}
