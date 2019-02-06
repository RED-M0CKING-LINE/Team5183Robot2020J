/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;

import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.cameraserver.CameraServer;

import frc.robot.RobotMap;
import frc.robot.functions.Xbox;
import frc.robot.functions.DriveTrain;

public class Robot extends TimedRobot {
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  private Xbox ctrl;

  //TODO MAKE A CAMERA SWITCHER
  //Thread CameraSwitch = new Thread(() -> {});

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    RobotMap.MOTORS_L.enableDeadbandElimination(true);
		RobotMap.MOTORS_R.enableDeadbandElimination(true);
		RobotMap.MOTORS_L.setSafetyEnabled(true);
		RobotMap.MOTORS_R.setSafetyEnabled(true);
		RobotMap.MOTORS_L.setExpiration(0.1);
		RobotMap.MOTORS_R.setExpiration(0.1);
    RobotMap.MOTORS_L.setInverted(true);
    
		
		m_chooser.setDefaultOption("Default Auton", "AutonDefault");
		m_chooser.addOption("Left Auton", "AutonLeft");
		m_chooser.addOption("Center Auton", "AutonCenter");
    m_chooser.addOption("Right Auton", "AutonRight");
    m_chooser.addOption("No Auton", "AutonNone");
    m_chooser.addOption("Teleop Auton", "Teleop");
    SmartDashboard.putData("Auton Chooser", m_chooser);
    
    this.ctrl = new Xbox(0);

    //RobotMap.camera0.start();
    CameraServer.getInstance().startAutomaticCapture();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auton selected: " + m_autoSelected);
  }

  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) { //TODO WRITE THE AUTONOMOUS
      case "Teleop": // For operator control during the auton period
        while (RobotState.isAutonomous()) {
          DriveTrain.drive(ctrl.R_X_STICK, ctrl.L_Y_STICK, 1);
        }
      case "AutonLeft":
        break;
      case "AutonCenter":
        break;
      case "AutonRight":
        break;
      case "AutonNone": // Robot Does Nothing
        break;
      default:
        break;
    }
    DriveTrain.stop(); // To stop the autonomous movement or teleop movement if it doesnt stop on its own. Prevents a period of uncontrollable movement.
    //TODO FIGURE OUT THE LAG AND SEE HOW MUCH AN ISSUE THE STOP FUNCTION CAUSES AND WHETHER IT IS NEEDED.
  }

  @Override
  public void teleopPeriodic() {
    DriveTrain.drive(ctrl.R_X_STICK, ctrl.L_Y_STICK, 1);
  }

  @Override
  public void testPeriodic() {}
}
