package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import frc.robot.RobotMap;

public class DriveTrain {

	private static DifferentialDrive DRIVE = new DifferentialDrive(RobotMap.MOTORS_L, RobotMap.MOTORS_R);
	
	/** For Exponential Output Control of the Drive Train.
	 * @param x Forward/Backward Movement. rawAxis 4 = Right Stick's X-Axis
	 * @param z Rotational Movement. rawAxis 1 = Left Stick's Y-Axis
	 */
	public static void driveExp(double x, double z) { // cut only allow for values to the hundreth power to be passed to the motors, cut off the rest.
		final double base = 2.0;
		final double deadzone = 0.05;
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
	public static void driveNormal(double x, double z, boolean squared) {
		DRIVE.arcadeDrive(x, z, squared);
	}

	/* This is  command used to move the robot on a timer
	 * @param left - sets to move the left side motors
	 * @param right - sets to move the right side motors
	 * @param time - sets amount of wait time in seconds
	 */
	public static void move(double left, double right) {
		RobotMap.MOTORS_L.set(left);
		RobotMap.MOTORS_R.set(right);
	}
	
	//TODO SETUP THE GYRO FUNCTION
	/* This command is for turning of the robot based off gyro measurements
	 * @param speed - how fast the robot should move
	 * @param angle - what angle the robot should stop at
	 * @param clock - "c" or "cc". 'c' for clockwise or 'cc' for counter-clockwise
	 */
	public static void turn(double speed, double angle, String clock) {
		stop();
		if(clock == "c") {
			RobotMap.MOTORS_L.set(speed);
			RobotMap.MOTORS_R.set(speed);
		}else if(clock == "cc") {
			RobotMap.MOTORS_L.set(-speed);
			RobotMap.MOTORS_R.set(-speed);
		}else { //DEFAULT COUNTER-CLOCKWISE
			RobotMap.MOTORS_L.set(-speed);
			RobotMap.MOTORS_R.set(-speed);
		}
	}
	
	/* This is to stop the robot in its tracks */
	public static void stop() {
		RobotMap.MOTORS_L.set(0);
		RobotMap.MOTORS_R.set(0);
	}
}