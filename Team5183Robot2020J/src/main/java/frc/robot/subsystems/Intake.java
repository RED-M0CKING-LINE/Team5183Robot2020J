package frc.robot.subsystems;

import frc.robot.RobotMap;

public class Intake {
    private static final double speed = 1;

    /** This is the intake's initalization code that should be called at boot in the robotInit() function */
    public static void initialize() {
        RobotMap.INTAKE_L.setExpiration(0.2);
        RobotMap.INTAKE_R.setExpiration(0.2);
    }

    /** This is the intake's periodic code that should be called every 20ms-ish in the robotPeriodic() function */
    public static void periodic() {
        RobotMap.INTAKE_L.check();
        RobotMap.INTAKE_R.check();
    }

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