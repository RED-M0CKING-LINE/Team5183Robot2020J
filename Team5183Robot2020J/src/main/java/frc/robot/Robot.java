/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Spark;
/**
 * Add your docs here.
 */
public class Robot extends TimedRobot {
    XboxController xbox = new XboxController(0);
    Spark motor_l = new Spark(2);
    Spark motor_r = new Spark(1);
    Spark motor_il = new Spark(4);
    Spark motor_ir = new Spark(5);
    public void drive() {
        double x = xbox.getX();
        double y = xbox.getY();
        motor_l.set(y);
        motor_r.set(y);
        motor_ir.set(y);
        motor_il.set(y);
    }
    @Override
    public void robotInit() {
        motor_l.enableDeadbandElimination(true);
        motor_r.enableDeadbandElimination(true);
        motor_l.setSafetyEnabled(true);
        motor_r.setSafetyEnabled(true);
    }
    @Override
    public void robotPeriodic() {

    }
    @Override
    public void autonomousInit() {

    }
    @Override
    public void autonomousPeriodic() {

    }
    @Override 
    public void teleopInit() {

    }
    @Override
    public void teleopPeriodic() {

    }
    public void testPeriodic() {

    }
    @Override
    public void startCompetition() {

    }

    @Override
    public void endCompetition() {

    }
}
