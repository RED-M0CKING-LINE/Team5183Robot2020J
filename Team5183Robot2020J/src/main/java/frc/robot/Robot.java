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
    RobotMap.MOTORS_L.enableDeadbandElimination(true);
		RobotMap.MOTORS_R.enableDeadbandElimination(true);
		RobotMap.MOTORS_L.setSafetyEnabled(true);
		RobotMap.MOTORS_R.setSafetyEnabled(true);
		RobotMap.MOTORS_L.setExpiration(0.3);
    RobotMap.MOTORS_R.setExpiration(0.3);
    RobotMap.INTAKE_L.setExpiration(0.2);
    RobotMap.INTAKE_R.setExpiration(0.2);
    
    CameraServer.getInstance().startAutomaticCapture();

    DriversStation.initialize();
  }

  @Override
  public void robotPeriodic() {
    RobotMap.MOTORS_L.check();
    RobotMap.MOTORS_R.check();
    RobotMap.INTAKE_L.check();
    RobotMap.INTAKE_R.check();

    DriversStation.update();
  }

  @Override
  public void autonomousInit() {DriveTrain.teleopDrive();} // only to get that extra little bit of movement time :thumbs_up: (20ms ish)

  @Override
  public void autonomousPeriodic() {
    DriveTrain.teleopDrive();
  }

  @Override
  public void teleopInit() {
    DriveTrain.stop();
  }

  @Override
  public void teleopPeriodic() {
    DriveTrain.teleopDrive();
    
    if(ctrl.getAState()) {
      Intake.in();
    } else if (ctrl.getXState()) {
      Intake.out();
    } else {
      Intake.stop();
    }

    DriveTrain.teleopDrive();
  }

  @Override
  public void testPeriodic() {}
}
