package frc.robot.functions;

import edu.wpi.first.wpilibj.XboxController;

public class Xbox {
    private XboxController Controller = new XboxController(0);
	
    public double L_X_STICK = Controller.getRawAxis(0); // Left stick horizontal
    public double L_Y_STICK = Controller.getRawAxis(1); // Left stick vertical
    public double L_TRIG = Controller.getRawAxis(2); // Left trigger
    public double R_TRIG = Controller.getRawAxis(3); // Right trigger
    public double R_X_STICK = Controller.getRawAxis(4); // Right stick horizontal
    public double R_Y_STICK = Controller.getRawAxis(5); // Right stick vertical
    
}