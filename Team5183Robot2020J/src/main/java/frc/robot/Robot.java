/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Robot Program Created By Ethan Ashley, AKA RedMockingLine on GitHub
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.cameraserver.CameraServer;

import frc.robot.RobotMap;
import frc.robot.subsystems.Xbox;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.DriversStation;
import frc.robot.subsystems.Intake;

/** This is where the main program flow is controled. */
public class Robot extends TimedRobot {
  private static Xbox ctrl = new Xbox(RobotMap.CONTROLLER1);

  //TODO MAKE A CAMERA SWITCHER
  //Thread CameraSwitch = new Thread(() -> {});

  @Override
  public void robotInit() {
    DriveTrain.inititalize();
    Intake.initialize();
    DriversStation.initialize();
    CameraServer.getInstance().startAutomaticCapture();
  }

  @Override
  public void robotPeriodic() {
    DriveTrain.periodic();
    Intake.periodic();
    DriversStation.update();
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
    DriveTrain.teleopDrive();
    
    if(ctrl.getAState()) {
      Intake.in();
      DriveTrain.teleopDrive();
    } else if (ctrl.getXState()) {
      Intake.out();
      DriveTrain.teleopDrive();
    } else {
      Intake.stop();
      DriveTrain.teleopDrive();
    }
  }
}
