package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;

import frc.robot.RobotMap;

public class Climber {
    private boolean state;

    public Climber() {
        this.state = false;
        down();
    }

    public void up() {
        RobotMap.CLIMB_L.set(DoubleSolenoid.Value.kForward);
        RobotMap.CLIMB_R.set(DoubleSolenoid.Value.kForward);
        state = true;
    }

    public void down() {
        RobotMap.CLIMB_L.set(DoubleSolenoid.Value.kReverse);
        RobotMap.CLIMB_R.set(DoubleSolenoid.Value.kReverse);
        state = false;
    }

    public void off() {
        RobotMap.CLIMB_L.set(DoubleSolenoid.Value.kOff);
        RobotMap.CLIMB_R.set(DoubleSolenoid.Value.kOff);
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
