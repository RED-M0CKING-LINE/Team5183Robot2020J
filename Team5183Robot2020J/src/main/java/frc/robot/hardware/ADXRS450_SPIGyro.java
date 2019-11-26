package frc.robot.hardware;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;


public class ADXRS450_SPIGyro {

    private static final ADXRS450_Gyro GYRO = new ADXRS450_Gyro();
    
    /** This will only return the measurement for plane coinciding with the Gyro itself (presumably the same as the RoboRIO aswell) */
    public static double getAngle() {
        return GYRO.getAngle();
    }

    public static boolean isConnected() {
        return GYRO.isConnected();
    }

    public static void calibrate() {
        GYRO.calibrate();
    }
}
