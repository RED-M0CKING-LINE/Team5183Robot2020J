package frc.robot.subsystems;

import frc.robot.RobotMap;

public class Intake {
    private static final double speed = 1;

    public static void in() {
        RobotMap.INTAKE_L.set(0.4);
        RobotMap.INTAKE_R.set(0.4);
    }

    public static void out() {
        RobotMap.INTAKE_L.set(-speed);
        RobotMap.INTAKE_R.set(-speed);
    }

    public static void stop() {
        RobotMap.INTAKE_L.stopMotor();
        RobotMap.INTAKE_R.stopMotor();
    }
}