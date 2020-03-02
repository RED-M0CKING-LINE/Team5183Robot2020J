package frc.robot;

import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;

public class RobotMap {

    // Controller Port Number
    public static final int CONTROLLER1 = 0;
    
    // Servos

    // Motors
    public static final double DRIVE_SPEED_RAMP = 0.01;
    public static int
    driveMotorFrontRightCANID = 2,
    driveMotorFrontLeftCANID = 3,
    driveMotorBackRightCANID = 4,
    driveMotorBackLeftCANID = 5;
    public static SupplyCurrentLimitConfiguration driveCurrentLimit = new SupplyCurrentLimitConfiguration(true, 30, 0 , 0.2);

    // Encoders

    // Pneumatics - give them some slack, their just kinda bloated
//    public static Compressor compressor = new Compressor(1);

    // Sensors


}
