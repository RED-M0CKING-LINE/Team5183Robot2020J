package frc.robot.subsystems;

import com.analog.adis16448.frc.ADIS16448_IMU;

public class ADIS16448_Sensor {

    /**TODO
        IMU.getBarometricPressure();
        IMU.calibrate();
        IMU.getMagX();
        IMU.getMagY();
        IMU.getMagZ();
        IMU.getRoll();
        IMU.getPitch();
        IMU.getRoll();
        IMU.getYaw();
     */
    private static final ADIS16448_IMU IMU = new ADIS16448_IMU();

    public static double getTemp() {
        return IMU.getTemperature();
    }

    /** Axis is X, Y, or Z
     * @return double of the angle in degrees. Returns 77 if parameter is incorrect. */
    public static double getAngle(char axis) {
        if(axis == 'X') {
            return IMU.getAngleX();
        } else if(axis == 'Y') {
            return IMU.getAngleY();
        } else if(axis == 'Z') {
            return IMU.getAngleZ();
        } else {
            return 77;
        }
    }

    /** Axis is X, Y, or Z
     * @return double for acceleration. Returns 77 if parameter is incorrect. */
    public static double getAcceleration(char axis) {
        if(axis == 'X') {
            return IMU.getAccelX();
        } else if(axis == 'Y') {
            return IMU.getAccelY();
        } else if(axis == 'Z') {
            return IMU.getAccelZ();
        } else {
            return 77;
        }
    }

    
}
