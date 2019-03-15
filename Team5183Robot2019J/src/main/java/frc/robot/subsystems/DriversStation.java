package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.subsystems.DriveTrain;


/** A set of functions to interface with the Drivers Station, primarilly using Shuffleboard
 */

public class DriversStation {
    //TODO make this the shuffleboard interface for the Drivers Station

    public static void update() {
        SmartDashboard.putNumber("Left-side Drive Speed", DriveTrain.getLeftSpeed());
        SmartDashboard.putNumber("Right-side Drive Speed", DriveTrain.getRightSpeed());
    }
}
