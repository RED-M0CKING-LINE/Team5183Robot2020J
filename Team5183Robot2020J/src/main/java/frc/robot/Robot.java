/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Robot Program Created By Ethan Ashley, AKA RedMockingLine on GitHub
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.cameraserver.CameraServer;

import frc.robot.RobotMap;
import frc.robot.hardware.XboxCustom;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.DriverStation;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Climber;

/** This is where the main program flow is controled. */
public class Robot extends TimedRobot {
    public static XboxCustom ctrl = new XboxCustom(RobotMap.CONTROLLER1);

    private static Climber Climber = new Climber();

    @Override
    public void robotInit() {
        DriveTrain.inititalize();
        Intake.initialize();
        DriverStation.initialize();
        CameraServer.getInstance().startAutomaticCapture();
    }
  
    @Override
    public void robotPeriodic() {
        DriveTrain.periodic();
        Intake.periodic();
        DriverStation.update();
    }
  
    @Override
    public void autonomousInit() {operatorDrive();} // only to get that extra little bit of movement time :thumbs_up: (20ms ish)
  
    @Override
    public void autonomousPeriodic() {operatorDrive();}
  
    @Override
    public void teleopInit() {
        DriveTrain.stop();  // incase the robot crashes while switching, or takes too long, the bot will stop.
    }
  
    @Override
    public void teleopPeriodic() {operatorDrive();}
  
    @Override
    public void testInit() {}
  
    @Override
    public void testPeriodic() {}
  
    /** This is the method that enables full bot operation.
     * This exists to avoid duplicate code in teleopPeriodic and autonomousPeriodic
     * because the 2019 season allowed manual control during the autonomous period */
    private static void operatorDrive() {
        DriveTrain.teleopDrive(ctrl.getRBumperState());

        if(RobotMap.INTAKE_ENABLED) {
            if(ctrl.getAState()) {
                Intake.in();
                DriveTrain.teleopDrive(ctrl.getRBumperState());
            } else if (ctrl.getXState()) {
                Intake.out();
                DriveTrain.teleopDrive(ctrl.getRBumperState());
            } else {
                Intake.stop();
                DriveTrain.teleopDrive(ctrl.getRBumperState());
            }
        }

        DriveTrain.teleopDrive(ctrl.getRBumperState());
        
        if(RobotMap.CLIMBER_ENABLED) {
            if(ctrl.getStartState()) {
                Climber.up();
                DriveTrain.teleopDrive(ctrl.getRBumperState());
            } else if(ctrl.getBackState()) {
                Climber.down();
                DriveTrain.teleopDrive(ctrl.getRBumperState());
            } else {
                DriveTrain.teleopDrive(ctrl.getRBumperState());
            }
        }
        
    }
}
