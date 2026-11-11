package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntakePerhaps {

    private DcMotor intakeMotor;

    public void init(HardwareMap hwMap) {
        intakeMotor = hwMap.get(DcMotor.class, "Whatever the name of motor is");


        intakeMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }


    public void driveIntake(double speed) {
        intakeMotor.setPower(speed);
        // Domain of SetPower is -1 to 1, where negative is the reverse direction
    }



}
