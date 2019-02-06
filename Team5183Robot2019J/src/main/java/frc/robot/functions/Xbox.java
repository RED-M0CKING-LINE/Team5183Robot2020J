package frc.robot.functions;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class Xbox {
    private static XboxController ctrl = new XboxController(0);
	
    public static double 
    L_X_STICK = ctrl.getRawAxis(0), // Left stick horizontal
    L_Y_STICK = ctrl.getRawAxis(1), // Left stick vertical
    L_TRIG = ctrl.getRawAxis(2), // Left trigger
    R_TRIG = ctrl.getRawAxis(3), // Right trigger
    R_X_STICK = ctrl.getRawAxis(4), // Right stick horizontal
    R_Y_STICK = ctrl.getRawAxis(5); // Right stick vertical

    public static boolean 
    getAState = ctrl.getAButton(),
    getBState = ctrl.getBButton(),
    getXState = ctrl.getXButton(),
    getYState = ctrl.getYButton(),
    getBackState = ctrl.getBackButton(),
    getStartState = ctrl.getStartButton(),
    getLBumperState = ctrl.getBumper(Hand.kLeft),
    getRBumperState = ctrl.getBumper(Hand.kRight);
    
}