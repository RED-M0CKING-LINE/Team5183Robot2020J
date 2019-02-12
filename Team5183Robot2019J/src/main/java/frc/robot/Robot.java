/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
//import edu.wpi.first.cameraserver.CameraServer;

import frc.robot.RobotMap;
import frc.robot.functions.Xbox;
import frc.robot.functions.DriveTrain;

public class Robot extends TimedRobot {
  private Xbox ctrl = new Xbox(0);

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
    RobotMap.MOTORS_L.setInverted(true);
    
    //CameraServer.getInstance().startAutomaticCapture();
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {DriveTrain.driveExp(ctrl.L_Y_STICK(), ctrl.R_X_STICK());} // only to get that extra little bit of movement time :thumbs_up:

  @Override
  public void autonomousPeriodic() {
    DriveTrain.driveExp(ctrl.L_Y_STICK(), ctrl.R_X_STICK());
    //TODO IS A STOP FUNCTION NEEDED?
  }

  @Override
  public void teleopPeriodic() {DriveTrain.driveExp(ctrl.L_Y_STICK(), ctrl.R_X_STICK());}

  @Override
  public void testPeriodic() {}
}
