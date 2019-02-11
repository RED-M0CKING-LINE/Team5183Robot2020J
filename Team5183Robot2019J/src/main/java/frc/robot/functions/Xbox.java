package frc.robot.functions;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class Xbox {
    XboxController ctrl;

    public Xbox(int port) {
        this.ctrl = new XboxController(port);
    }
    
    public boolean getAState() {return ctrl.getAButton();}
    public boolean getBState() {return ctrl.getBButton();}
    public boolean getXState() {return ctrl.getXButton();}
    public boolean getYState() {return ctrl.getYButton();}
    public boolean getBackState() {return ctrl.getBackButton();}
    public boolean getStartState() {return ctrl.getStartButton();}
    public boolean getLBumperState() {return ctrl.getBumper(Hand.kLeft);}
    public boolean getRBumperState() {return ctrl.getBumper(Hand.kRight);}
    public double L_X_STICK() {return ctrl.getRawAxis(0);} // Left stick horizontal
    public double L_Y_STICK() {return ctrl.getRawAxis(1);} // Left stick vertical
    public double L_TRIG() {return ctrl.getRawAxis(2);} // Left trigger
    public double R_TRIG() {return ctrl.getRawAxis(3);} // Right trigger
    public double R_X_STICK() {return ctrl.getRawAxis(4);} // Right stick horizontal
    public double R_Y_STICK() {return ctrl.getRawAxis(5);} // Right stick vertical

}