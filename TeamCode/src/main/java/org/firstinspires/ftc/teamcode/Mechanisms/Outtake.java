package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Outtake {
    private DcMotor flywheelMotor;



    public void init(HardwareMap hwMap) {
        flywheelMotor = hwMap.get(DcMotor.class, "Whatever the name of motor is");

        flywheelMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }




    public void driveOuttake(double speed) {
        flywheelMotor.setPower(speed);
        // Domain of SetPower is -1 to 1, where negative is the reverse direction
    }



}
