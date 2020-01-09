package frc.robot.hardware;

/**     commented out until new vendor libraries get installed into the new project
#TODO install vendor libraries

import com.analog.adis16448.frc.ADIS16448_IMU;

public class ADIS16448_Sensor {

    private static final ADIS16448_IMU IMU = new ADIS16448_IMU();

    public static double getTemp() {
        return IMU.getTemperature();
    }

    public static double getPressure() {
        return IMU.getBarometricPressure();
    }

    /** Axis is X, Y, or Z
     * @return double of angle off of magnetic north in degrees. Returns 99999 if parameter is incorrect. */ /**
    public static double getMag(char axis) {
        if(axis == 'X') {
            return IMU.getMagX();
        } else if(axis == 'Y') {
            return IMU.getMagY();
        } else if(axis == 'Z') {
            return IMU.getMagZ();
        } else {
            return 99999;
        }
    }

        /** Axis is X, Y, or Z
     * @return double for acceleration. Returns 99999 if parameter is incorrect. */ /**
    public static double getAcceleration(char axis) {
        if(axis == 'X') {
            return IMU.getAccelX();
        } else if(axis == 'Y') {
            return IMU.getAccelY();
        } else if(axis == 'Z') {
            return IMU.getAccelZ();
        } else {
            return 99999;
        }
    }

    public static double getRoll() {
        return IMU.getRoll();
    }

    public static double getPitch() {
        return IMU.getPitch();
    }

    public static double getYaw() {
        return IMU.getYaw();
    }
    /** Axis is X, Y, or Z
     * @return double of the angle in degrees. Returns 99999 if parameter is incorrect. */ /**
    public static double getAngle(char axis) {
        if(axis == 'X') {
            return IMU.getAngleX();
        } else if(axis == 'Y') {
            return IMU.getAngleY();
        } else if(axis == 'Z') {
            return IMU.getAngleZ();
        } else {
            return 99999;
        }
    }

    public static void calibrate() {
        IMU.calibrate();
    }
    
}
*/
