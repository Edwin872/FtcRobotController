package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Mechanisms.IntakePerhaps;
import org.firstinspires.ftc.teamcode.Mechanisms.MecanumDrive;
import org.firstinspires.ftc.teamcode.Mechanisms.Outtake;




@TeleOp
public class MainTeleOp extends OpMode {
    MecanumDrive myDrive = new MecanumDrive();
    Outtake myOuttake = new Outtake();
    IntakePerhaps myIntake = new IntakePerhaps();
    //Creates instances of the classes we created called: MecanumDrive, Outtake and IntakePerhaps
    double forward, strafe, rotate;


    @Override
    public void init() {
        myDrive.init(hardwareMap);
        myOuttake.init(hardwareMap);
        myIntake.init(hardwareMap);
        // Initialize all the motors & set them up w/ hardware Map


    }

    @Override
    public void loop() {
        forward = gamepad1.left_stick_y; // Does it have to be negative? possible bug
        strafe = gamepad1.left_stick_x;
        rotate = gamepad1.right_stick_x;

        myDrive.drive(forward,strafe,rotate);
        // Using drive & not field oriented drive because we have no encoders


        // If button a is pressed, activate the flywheel motor
        if (gamepad1.a) {
            myOuttake.driveOuttake(1);
        }


        // If button b is pressed activate the intake
        if (gamepad1.b) {
            myIntake.driveIntake(1);
        }
    }
}
