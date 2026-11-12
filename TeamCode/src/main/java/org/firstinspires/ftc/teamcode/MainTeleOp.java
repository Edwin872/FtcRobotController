package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


import org.firstinspires.ftc.teamcode.Mechanisms.IntakePerhaps;
import org.firstinspires.ftc.teamcode.Mechanisms.MecanumDrive;
import org.firstinspires.ftc.teamcode.Mechanisms.Outtake;




@TeleOp
public class MainTeleOp extends OpMode {
    MecanumDrive myDrive = new MecanumDrive();
<<<<<<< HEAD
    //Creates an instance of the class we created called MecanumDrive

    DcMotor intake;

=======
    Outtake myOuttake = new Outtake();
    IntakePerhaps myIntake = new IntakePerhaps();
    //Creates instances of the classes we created called: MecanumDrive, Outtake and IntakePerhaps
>>>>>>> c4a6c564ae0aaaaa6bc3b0703b087254f967c295
    double forward, strafe, rotate;


    @Override
    public void init() {
        myDrive.init(hardwareMap);
        myOuttake.init(hardwareMap);
        myIntake.init(hardwareMap);
        // Initialize all the motors & set them up w/ hardware Map


        intake = hardwareMap.get(DcMotor.class, "intake");
        //Hub port 0, expansion hub, DcMotor
    }

    @Override
    public void loop() {
        forward = gamepad1.left_stick_y; // Does it have to be negative? possible bug
        strafe = gamepad1.left_stick_x;
        rotate = gamepad1.right_stick_x;

<<<<<<< HEAD
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
=======
        myDrive.drive(forward,strafe,rotate);
        // Using drive & not field oriented drive because we have no encoders


        // If button a is pressed, activate the flywheel motor
        if (gamepad1.a) {
            myOuttake.driveOuttake(1);
        }


        // If button b is pressed activate the intake
        if (gamepad1.b) {
            myIntake.driveIntake(1);
>>>>>>> c4a6c564ae0aaaaa6bc3b0703b087254f967c295
        }
    }
}
