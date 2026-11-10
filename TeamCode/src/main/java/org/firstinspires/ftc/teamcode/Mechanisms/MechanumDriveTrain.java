package org.firstinspires.ftc.teamcode.Mechanisms;
// Below are Class imports
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MechanumDriveTrain {
    private DcMotor frontLeftMotor, backLeftmotor, frontRightMotor, backRightMotor;
    //Define motors as a DcMotor "variable type"


    public void init(HardwareMap hwMap) {
        frontLeftMotor = hwMap.get(DcMotor.class, "Name inputted into drive station");
        backLeftmotor = hwMap.get(DcMotor.class, "Name on driver station");
        frontRightMotor = hwMap.get(DcMotor.class, "Name on driver station");
        backRightMotor = hwMap.get(DcMotor.class, "NameDriver Station");



    //This new method initializes the motors since they have no value rn
        //HardwareMap
    }


}
