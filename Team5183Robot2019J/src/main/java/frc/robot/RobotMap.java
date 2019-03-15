package frc.robot;

//import frc.robot.subsystems.Camera;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid;
//import edu.wpi.first.wpilibj.Compressor;

public class RobotMap {

	// Motors
	public static Spark
	MOTORS_L = new Spark(0), //Left side drive motors
	MOTORS_R = new Spark(1), //Right side drive motors
	INTAKE_L = new Spark(2), //Left side intake motor
	INTAKE_R = new Spark(3); //Right side intake motor
	
	// Encoders
	//TODO ADD GYRO AND THE FUNCTION TO CONTROL IT
	
	// Servos
	
	// Pneumatics - give them some slack, their just kinda bloated
	public static DoubleSolenoid liftL = new DoubleSolenoid(0, 1);
	public static DoubleSolenoid liftR = new DoubleSolenoid(2, 3);
	//public static Compressor compressor = new Compressor(1);

	// Camera Settings
	public static final int
	cam0Width = 320,
	cam0Height = 240,
	cam0FPS = 20,
	cam0Compression = 30, // 30% 
	cam0Exposure = 4; // These settings seemed to work best under use of one camera

	// Start Camera Stream Systems
	//public static Camera camera0 = new Camera("Camera0", 0 , cam0Width, cam0Height, cam0FPS, cam0Exposure);
}