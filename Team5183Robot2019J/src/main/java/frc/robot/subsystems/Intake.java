package frc.robot.subsystems;

import frc.robot.RobotMap;

public class Intake {
    private static final double inSpeed = 0.9, outSpeed = 1.0;

    public static void in() {
        RobotMap.INTAKE_L.set(inSpeed);
        RobotMap.INTAKE_R.set(inSpeed);
    }

    public static void out() {
        RobotMap.INTAKE_L.set(outSpeed);
        RobotMap.INTAKE_R.set(outSpeed);
    }

    public static void stop() {
        RobotMap.INTAKE_L.stopMotor();
        RobotMap.INTAKE_R.stopMotor();
    }
}