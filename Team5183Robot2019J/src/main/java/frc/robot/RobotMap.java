package frc.robot;

import frc.robot.functions.Camera;
import frc.robot.functions.DriveTrain;
import frc.robot.functions.Xbox;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
//import edu.wpi.first.wpilibj.Compressor;

public class RobotMap {
	
	// Function Declarations
	public static DriveTrain M = new DriveTrain();
	public static Xbox ctrl = new Xbox();
	
	// Motors
	public static Spark
	MOTORS_L = new Spark(0), //Left side drive motors on channel 0
	MOTORS_R = new Spark(1); //Right side drive motors on channel 1
	
	// Encoders
	public static ADXRS450_Gyro gyro = new ADXRS450_Gyro(); //USE SPI GYRO
	
	// Servos
	
	// Pneumatics - give them some slack, their just kinda bloated
	//public static Compressor compressor = new Compressor(1);

	// Camera Settings
	public static final int 
	cam0Width = 720,
	cam0Height = 480,
	cam0FPS = 15,
	cam0Exposure = 4;

	// Start Camera Stream Systems
	public static Camera camera0 = new Camera("Camera0", 0 , cam0Width, cam0Height, cam0FPS, cam0Exposure);
}