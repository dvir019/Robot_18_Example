package org.usfirst.frc.team4320.robot.subsystems;

import org.usfirst.frc.team4320.robot.RobotMap;

import Classes.DoubleSol;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShifterSubsystem extends Subsystem {

    private static ShifterSubsystem instance;
    
    private DoubleSol doubleSol;
    
    private ShifterSubsystem() {
    	doubleSol = new DoubleSol(RobotMap.OPEN_SHIFTER, RobotMap.CLOSE_SHIFTER);
    }
    
    public void swap() {
    	doubleSol.swap();
    }
    
    public static ShifterSubsystem getinstance() {
    	if (instance==null)
    		instance = new ShifterSubsystem();
    	return instance;
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

