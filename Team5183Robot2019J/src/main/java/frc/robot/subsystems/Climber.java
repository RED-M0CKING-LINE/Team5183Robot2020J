package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;

import frc.robot.RobotMap;

public class Climber {
    private boolean state;
    private DoubleSolenoid liftR, liftL;

    public Climber() {
        this.liftR = new DoubleSolenoid(0, 1);
        this.liftL = new DoubleSolenoid(2, 3);
        this.state = false;
    }

    public void up() {
        liftL.set(DoubleSolenoid.Value.kForward);
        liftR.set(DoubleSolenoid.Value.kForward);
        state = true;
    }

    public void down() {
        liftL.set(DoubleSolenoid.Value.kReverse);
        liftR.set(DoubleSolenoid.Value.kReverse);
        state = false;
    }

    public void off() {
        liftL.set(DoubleSolenoid.Value.kOff);
        liftR.set(DoubleSolenoid.Value.kOff);
        state = false;
    }

    /** Returns the state of the robot.
     * 
     * @return boolean. True is up. False is down or off.
     */
    public boolean state() {
        return state;
    }
}
