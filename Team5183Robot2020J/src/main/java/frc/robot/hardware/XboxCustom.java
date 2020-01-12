package frc.robot.hardware;

import edu.wpi.first.wpilibj.XboxController;

public class XboxCustom extends XboxController {

    private final int port;

    public XboxCustom(final int port) {
        super(port);
        this.port = port;
    }

    public int getPort() {return this.port;}


    //TODO remove all of these functions below and fix errors
    public boolean getAState() {return super.getAButton();}
    public boolean getBState() {return super.getBButton();}
    public boolean getXState() {return super.getXButton();}
    public boolean getYState() {return super. getYButton();}
    public boolean getBackState() {return super.getBackButton();}
    public boolean getStartState() {return super.getStartButton();}
    public boolean getLBumperState() {return super.getBumper(Hand.kLeft);} // Left Bumper
    public boolean getRBumperState() {return super.getBumper(Hand.kRight);} // Right Bumper
    public double L_X_STICK() {return super.getRawAxis(0);} // Left stick horizontal
    public double driveY() {return super.getRawAxis(1);} // Left stick vertical
    public double L_TRIG() {return super.getRawAxis(2);} // Left trigger
    public double R_TRIG() {return super.getRawAxis(3);} // Right trigger
    public double driveX() {return super.getRawAxis(4);} // Right stick horizontal
    public double R_Y_STICK() {return super.getRawAxis(5);} // Right stick vertical

}