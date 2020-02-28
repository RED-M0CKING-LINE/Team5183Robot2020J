/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Robot Program Created By Ethan Ashley, AKA RedMockingLine on GitHub
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;

import frc.robot.RobotMap;
import frc.robot.hardware.XboxCustom;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.DriverStation;

/** This is where the main program flow is controled. */
public class Robot extends TimedRobot {
    public static XboxCustom ctrl = new XboxCustom(RobotMap.CONTROLLER1);

    @Override
    public void robotInit() {
        DriveTrain.inititalize();
        DriverStation.initialize();
    }
  
    @Override
    public void robotPeriodic() {
        DriverStation.update();
    }
  
    @Override
    public void autonomousInit() {
        DriveTrain.move(.3, .3);
        Timer.delay(1);
        DriveTrain.stop();
        
    } 

    @Override
    public void autonomousPeriodic() {

    }
  
    @Override
    public void teleopInit() {
        DriveTrain.stop();  // incase the robot crashes while switching, or takes too long, the bot will stop.
    }
  
    @Override
    public void teleopPeriodic() {DriveTrain.teleopDrive(ctrl.getRBumperState());}
  
    @Override
    public void testInit() {}
  
    @Override
    public void testPeriodic() {}

    @Override
    public void simulationInit() {}

    @Override
    public void simulationPeriodic() {}
}
