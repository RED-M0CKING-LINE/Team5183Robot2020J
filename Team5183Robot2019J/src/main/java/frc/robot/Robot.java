/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.cameraserver.CameraServer;

import frc.robot.RobotMap;
import frc.robot.subsystems.Xbox;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;

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
    RobotMap.INTAKE_L.setExpiration(0.2);
    RobotMap.INTAKE_R.setExpiration(0.2);
    
    CameraServer.getInstance().startAutomaticCapture();
  }

  @Override
  public void robotPeriodic() {
    RobotMap.MOTORS_L.check();
    RobotMap.MOTORS_R.check();
    RobotMap.INTAKE_L.check();
    RobotMap.INTAKE_R.check();
  }

  @Override
  public void autonomousInit() {DriveTrain.driveExp(ctrl.L_Y_STICK(), ctrl.R_X_STICK());} // only to get that extra little bit of movement time :thumbs_up:

  @Override
  public void autonomousPeriodic() {
    DriveTrain.driveExp(ctrl.L_Y_STICK(), ctrl.R_X_STICK());
    //TODO IS A STOP FUNCTION NEEDED?
  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    DriveTrain.driveExp(ctrl.L_Y_STICK(), ctrl.R_X_STICK());
    if(ctrl.getAState()) {
      Intake.in();
    } else if (ctrl.getXState()) {
      Intake.out();
    } else {
      Intake.stop();
    }
  }

  @Override
  public void testPeriodic() {}
}
