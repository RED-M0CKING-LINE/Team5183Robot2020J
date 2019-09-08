package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import frc.robot.RobotMap;
import frc.robot.subsystems.ADIS16448_Sensor;

public class DriveTrain {

    private static Xbox ctrl = new Xbox(RobotMap.CONTROLLER1);

    private static DifferentialDrive DRIVE = new DifferentialDrive(RobotMap.MOTORS_L, RobotMap.MOTORS_R);

    /** This is the drive train's initalization code that should be called at boot in the robotInit() function */
    public static void inititalize() {
        RobotMap.MOTORS_L.enableDeadbandElimination(true);
        RobotMap.MOTORS_R.enableDeadbandElimination(true);
        RobotMap.MOTORS_L.setSafetyEnabled(true);
        RobotMap.MOTORS_R.setSafetyEnabled(true);
        RobotMap.MOTORS_L.setExpiration(0.3);
        RobotMap.MOTORS_R.setExpiration(0.3);
    }

    /** This is the drive train's periodic code that should be called every 20ms-ish in the robotPeriodic() function */
    public static void periodic() {
        RobotMap.MOTORS_L.check();
        RobotMap.MOTORS_R.check();
    }
    
    /** For Exponential Output Control of the Drive Train.
     * @param x Forward/Backward Movement. rawAxis 4 = Right Stick's X-Axis
     * @param z Rotational Movement. rawAxis 1 = Left Stick's Y-Axis
     */
    public static void driveExp(double x, double z) { // cut only allow for values to the hundreth power to be passed to the motors, cut off the rest.
        double base = 2.0, deadzone = 0.02;

        if(x > deadzone) {
            x = -(java.lang.Math.pow(base, x)-1);
        } else if(x < -deadzone) {
            x = (java.lang.Math.pow(base, -x)-1);
        } else {
            x = 0;
        }
        if(z > deadzone) {
            z = java.lang.Math.pow(base, z)-1;
        } else if(z < -deadzone) {
            z = -(java.lang.Math.pow(base, - z)-1);
        } else {
            z = 0;
        }
        DRIVE.arcadeDrive(x, z);
    }

    /** For Normal Output Control of the Drive Train. 
     * This is the control built into the WPILibJ libraries, either Linear, if is false, or a Quadratic curve if squared is true.
     * @param x Forward/Backward Movement. rawAxis 4 = Right Stick's X-Axis
     * @param z Rotational Movement. rawAxis 1 = Left Stick's Y-Axis
     */
    public static void driveBasic(double x, double z, boolean squared) {
        DRIVE.arcadeDrive(x, z, squared);
    }

    /* This is  command used to move the robot on a timer
     * @param left - sets to move the left side motors
     * @param right - sets to move the right side motors
     */
    public static void move(double left, double right) {
        RobotMap.MOTORS_L.set(left);
        RobotMap.MOTORS_R.set(right);
    }
    
    /* This command is for turning of the robot based off gyro measurements
     * @param speed - how fast the robot should move
     * @param degrees - what angle the robot should stop at in degrees
     * @param clock - "c" or "cc". 'c' for clockwise or 'cc' for counter-clockwise (default)
     */
    public static void turn(double speed, double degrees, String clock) {  //TODO TEST IF THIS WORKS
        final char angle = 'Z';  //TODO while turning, start the motors fast but slow them down as they get closer to the desired angle. use a exponetial curve
        stop();
        //TODO add some time to wait here. half a second?
        double angleOffset = ADIS16448_Sensor.getAngle(angle);
        if(clock == "c") {
            while(true) {
                RobotMap.MOTORS_L.set(speed);
                RobotMap.MOTORS_R.set(-speed);
                if((ADIS16448_Sensor.getAngle(angle) - angleOffset) >= degrees) {
                    break;
                }
            }
            stop();
        } else {  // Counter-Clockwise is Default
            while(true) {
                RobotMap.MOTORS_L.set(-speed);
                RobotMap.MOTORS_R.set(speed);
                if((ADIS16448_Sensor.getAngle(angle) - angleOffset) >= degrees) {
                    break;
                }
            }
            stop();
        }
    }
    
    /* This is to stop the robot in its tracks */
    public static void stop() {
        RobotMap.MOTORS_L.stopMotor();
        RobotMap.MOTORS_R.stopMotor();
    }

    public static double getLeftSpeed() {
        return RobotMap.MOTORS_L.get();
    }

    public static double getRightSpeed() {
        return RobotMap.MOTORS_R.get();
    }

    public static void teleopDrive(boolean halfSpeed) {
        if(halfSpeed) { // Drive function to determine half speed or full speed
            DriveTrain.driveExp((ctrl.driveY()/1.5), (ctrl.driveX()/1.65));
        } else {
            DriveTrain.driveExp(ctrl.driveY(), ctrl.driveX());
        }
    }
}