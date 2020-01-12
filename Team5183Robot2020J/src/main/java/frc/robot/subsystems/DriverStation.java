package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
//import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardComponent;
//import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.networktables.NetworkTableEntry;

import frc.robot.subsystems.DriveTrain;
import frc.robot.Robot;


/** A set of functions to interface with the Drivers Station, using Shuffleboard */
public class DriverStation {
    static NetworkTableEntry BrownoutStatus;

    public DriverStation() {
        initialize();
    }
    
    public static void initialize() {
        BrownoutStatus = Shuffleboard.getTab("ValueTable")
        .add("Browned Out?", false)
        .withWidget("Boolean Box")
        .getEntry();
    }

    public static void update() {
        SmartDashboard.putNumber("Left-side Drive Speed", DriveTrain.getLeftSpeed());
        SmartDashboard.putNumber("Right-side Drive Speed", DriveTrain.getRightSpeed());
        SmartDashboard.putNumber("Primary controller port number", Robot.ctrl.getPort());
        SmartDashboard.putBoolean("Browned Out?", RobotController.isBrownedOut()); // reports if the robot burned out

        BrownoutStatus.setBoolean(RobotController.isBrownedOut());
        Shuffleboard.update();
    }
}
