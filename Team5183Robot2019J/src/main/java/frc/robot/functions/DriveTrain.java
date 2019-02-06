package frc.robot.functions;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import frc.robot.RobotMap;

public class DriveTrain {

	private static DifferentialDrive DRIVE = new DifferentialDrive(RobotMap.MOTORS_L, RobotMap.MOTORS_R);
	
	/** For using the drive train.
	 * @param x is rawAxis 4, the Right Stick's X-Axis controller input
	 * @param z is rawAxis 1, the Left Stick's Y-Axis controller input
	 * @param mode int that determines the mode of the drive train movement. 1=Exponential 2=Squared 3=Linear
	 */
	public static void drive(double x, double z, int mode) {
		double base = 2.0; // Determinate for the aggression of the drive curve in the condition where mode == 1
		double max = 1; // This Determines the max output value in the condition where mode == 1
		
		if(mode == 1) { // Provides exponential movement for the drive train
			DRIVE.arcadeDrive(-1*((java.lang.Math.pow(base, x)-(1.0 + (1 - max)))), java.lang.Math.pow(base, z)-(1.0 + (1 - max)));
		} else if(mode == 2) { // Provides Squared Input movement for the drive train
			DRIVE.arcadeDrive(x, z, true);
		} else if(mode == 3) { // Provides Linear Movement of the drive train
			DRIVE.arcadeDrive(x, z); 
		}
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