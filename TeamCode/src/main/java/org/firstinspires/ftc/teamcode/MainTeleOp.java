package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Mechanisms.MecanumDrive;

@TeleOp
public class MainTeleOp extends OpMode {

    MecanumDrive myDrive = new MecanumDrive();
    //Creates an instance of the class we created called MecanumDrive

    double forward, strafe, rotate;


    @Override
    public void init() {
        myDrive.init(hardwareMap);
        // Initialize myDrive with all the hardware mappings it needs

    }

    @Override
    public void loop() {
        forward = gamepad1.left_stick_y; // Does it have to be negative? possible bug
        strafe = gamepad1.left_stick_x;
        rotate = gamepad1.right_stick_x;

        myDrive.driveFieldRelative(forward,strafe,rotate);
        // OR for Robot Oriented:
        myDrive.drive(forward,strafe,rotate);

    }
}
