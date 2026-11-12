package org.firstinspires.ftc.teamcode.Mechanisms;
// Below are Class imports (or interfaces)
// Classes are like blueprints while interfaces are it's rulebook.
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class MecanumDrive {
    private DcMotor frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor;
    private IMU imu;
    //Declare motors as a DcMotor "variable type", & imu as IMU type



    public void init(HardwareMap hwMap) {
<<<<<<< HEAD
        frontLeftMotor = hwMap.get(DcMotor.class, "frontLeft");
        backLeftMotor = hwMap.get(DcMotor.class, "backLeft");
        frontRightMotor = hwMap.get(DcMotor.class, "frontRight");
        backRightMotor = hwMap.get(DcMotor.class, "backRight");
=======
        //This method "init" initializes the motors since they have no value rn
        frontLeftMotor = hwMap.get(DcMotor.class, "Name inputted into drive station");
        backLeftMotor = hwMap.get(DcMotor.class, "Name on driver station");
        frontRightMotor = hwMap.get(DcMotor.class, "Name on driver station");
        backRightMotor = hwMap.get(DcMotor.class, "Name on Driver Station");
>>>>>>> c4a6c564ae0aaaaa6bc3b0703b087254f967c295

        // Mecanum drive lowk weird, like the right side is set forward and
        // the left side is reversed in direction so it can move forward & stuff
        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotor.Direction.REVERSE);

        // So they run on "encoder mode" (Optional)
        // Could also use RUN_TO_POSITION or some other mode
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Robot Orientated Drive Vs. Field Orientated Drive (for FOD use code below)
        // For FOD use built in IMU on REV hub
        imu = hwMap.get(IMU.class, "imu (should be imu on hub)");

        RevHubOrientationOnRobot RevOrientation = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD);
                // IMU knows its orientation relative to the direction of a logo & usb above the logo
        imu.initialize(new IMU.Parameters(RevOrientation));


        //HardwareMap is...
    }




    //Now make a new method for Robot Oriented Drive, then another for Field Oriented Drive
    public void drive(double forward, double strafe, double rotate) {
        //Random maths that make the mecanum drive work, arguments above are power
        double frontLeftPower = forward + strafe + rotate;
        double backLeftPower = forward - strafe + rotate;
        double frontRightPower = forward - strafe - rotate;
        double backRightPower = forward + strafe - rotate;

        //Constraints
        double maxPower = 1.0; // So that pushing all 3 parameters of joysticks don't add up to 3

        // Checks if maxPower is reached so we can scale the stuff so that it works & adds to one
        maxPower = Math.max(maxPower, Math.abs(frontLeftPower));
        maxPower = Math.max(maxPower, Math.abs(backLeftPower));
        maxPower = Math.max(maxPower, Math.abs(frontRightPower));
        maxPower = Math.max(maxPower, Math.abs(backRightPower));

        frontLeftMotor.setPower(frontLeftPower/maxPower);
        backLeftMotor.setPower(backLeftPower/maxPower);
        frontRightMotor.setPower(frontRightPower/maxPower);
        backRightMotor.setPower(backRightPower/maxPower);
    }


    // Field Oriented Drive method
    public void driveFieldRelative(double forward, double strafe, double rotate) {
        // Uses trig & polar coords to find where it is on the field (r, theta)->(r*cos(theta),r*sin(theta))
        //atan2(y,x) return angle between pos x axis & the ray of origin to (x,y)
        double theta = Math.atan2(forward, strafe);
        double r = Math.hypot(strafe, forward);

        theta = AngleUnit.normalizeRadians(theta - imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS));
        // Gets current angle and rotate theta based on where the robot is actually facing

        //Convert polar coords into cartesian coords
        double newForward = r * Math.sin(theta);
        double newStrafe = r * Math.cos(theta);


        this.drive(newForward, newStrafe, rotate);
        // Calls on the method we defined above this one, which is doable
    }
}
