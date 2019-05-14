package frc.robot.subsystems;

import com.analog.adis16448.frc.ADIS16448_IMU;

public class ADIS16448_Sensor {

    private static final ADIS16448_IMU IMU = new ADIS16448_IMU();

    public static double getTemp() {
        return IMU.getTemperature();
    }
}
