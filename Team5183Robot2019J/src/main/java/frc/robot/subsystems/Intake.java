package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;

import frc.robot.RobotMap;

public class Intake {
    private static final double speed = 1;
    private static Timer timer = new Timer();

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