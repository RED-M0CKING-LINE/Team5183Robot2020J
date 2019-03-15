package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;

import frc.robot.RobotMap;

public class Climber {
    private boolean state;

    public Climber() {
        this.state = false;
    }

    public void up() {
        RobotMap.liftL.set(DoubleSolenoid.Value.kForward);
        RobotMap.liftR.set(DoubleSolenoid.Value.kForward);
        state = true;
    }

    public void down() {
        RobotMap.liftL.set(DoubleSolenoid.Value.kReverse);
        RobotMap.liftR.set(DoubleSolenoid.Value.kReverse);
        state = false;
    }

    public void off() {
        RobotMap.liftL.set(DoubleSolenoid.Value.kOff);
        RobotMap.liftR.set(DoubleSolenoid.Value.kOff);
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
