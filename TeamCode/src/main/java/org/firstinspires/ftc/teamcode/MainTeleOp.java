package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


import org.firstinspires.ftc.teamcode.Mechanisms.MecanumDrive;

@TeleOp
public class MainTeleOp extends OpMode {

    MecanumDrive myDrive = new MecanumDrive();
    //Creates an instance of the class we created called MecanumDrive

    DcMotor intake;

    double forward, strafe, rotate;


    @Override
    public void init() {
        myDrive.init(hardwareMap);
        // Initialize myDrive with all the hardware mappings it needs

        intake = hardwareMap.get(DcMotor.class, "intake");
        //Hub port 0, expansion hub, DcMotor
    }

    @Override
    public void loop() {
        forward = gamepad1.left_stick_y; // Does it have to be negative? possible bug
        strafe = gamepad1.left_stick_x;
        rotate = gamepad1.right_stick_x;

        myDrive.driveFieldRelative(forward,strafe,rotate);
        // OR for Robot Oriented:

        //commented for now
//        myDrive.drive(forward,strafe,rotate);

        //Intake
        if (gamepad1.a){
            intake.setPower(1.0);
        } else if (gamepad1.b) {
            intake.setPower(-1.0);
        } else {
            intake.setPower(0.0);
        }
    }
}
