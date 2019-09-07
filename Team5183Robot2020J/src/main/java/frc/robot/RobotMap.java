package frc.robot;

import frc.robot.subsystems.ADIS16448_Sensor;
//import frc.robot.subsystems.Camera;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Compressor;

public class RobotMap {
    // Subsystem Settings
    public static final boolean
    INTAKE_ENABLED = false;
    
    // Servos

    // Motors
    public static Spark
    MOTORS_L = new Spark(0), //Left side drive motors
    MOTORS_R = new Spark(1), //Right side drive motors
    INTAKE_L = new Spark(2), //Left side intake motor
    INTAKE_R = new Spark(3); //Right side intake motor
    
    // Encoders

    // Sensors
    public static ADIS16448_Sensor SENSOR_HAT = new ADIS16448_Sensor(); // This HAT has a many, many sensors on it
    
    // Pneumatics - give them some slack, their just kinda bloated
    public static DoubleSolenoid CLIMB_L = new DoubleSolenoid(0, 1);
    public static DoubleSolenoid CLIMB_R = new DoubleSolenoid(2, 3);
    public static Compressor compressor = new Compressor(1);

    // Camera Settings
    public static final int
    cam0Width = 160,
    cam0Height = 120,
    cam0FPS = 8,
    cam0Compression = 75, // 75% 
    cam0Exposure = 5; // These settings seemed to work best under use of one camera

    // Start Camera Stream Systems
    //public static Camera camera0 = new Camera("Camera0", 0 , cam0Width, cam0Height, cam0FPS, cam0Exposure);
    //TODO get the camera working maybe? XDD

    // Controller Port Numbers
    public static final int CONTROLLER1 = 0;
}
