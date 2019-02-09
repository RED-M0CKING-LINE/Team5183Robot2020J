package frc.robot.functions;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class Xbox {
    XboxController ctrl;
    public boolean getAState, getBState, getXState, getYState, getBackState, getStartState, getLBumperState, getRBumperState;

    public Xbox(int port) {
        this.ctrl = new XboxController(port);
        getAState = ctrl.getAButton();
        getBState = ctrl.getBButton();
        getXState = ctrl.getXButton();
        getYState = ctrl.getYButton();
        getBackState = ctrl.getBackButton();
        getStartState = ctrl.getStartButton();
        getLBumperState = ctrl.getBumper(Hand.kLeft);
        getRBumperState = ctrl.getBumper(Hand.kRight);
    }
    
    public int
    L_Y_STICK = 1,
    R_X_STICK = 4;


    /**
    public double 
    L_X_STICK = ctrl.getRawAxis(0), // Left stick horizontal
    L_Y_STICK = ctrl.getRawAxis(1), // Left stick vertical
    L_TRIG = ctrl.getRawAxis(2), // Left trigger
    R_TRIG = ctrl.getRawAxis(3), // Right trigger
    R_X_STICK = ctrl.getRawAxis(4), // Right stick horizontal
    R_Y_STICK = ctrl.getRawAxis(5); // Right stick vertical */

    public double getAxis(int axis) {
        return ctrl.getRawAxis(axis);
    }
    
}