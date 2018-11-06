package org.usfirst.frc.team4320.robot.subsystems;

import org.usfirst.frc.team4320.robot.RobotMap;

import Classes.DoubleSol;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GripperSubsystem extends Subsystem {

	private static GripperSubsystem instance = null;
	
    private DoubleSol openCloseSol;
    private DoubleSol upDownSol;
    private Spark leftSpark;
    private Spark rightSpark;
    private DigitalInput switch1;
    
    private GripperSubsystem() {
    	openCloseSol = new DoubleSol(RobotMap.OPEN_SOL, RobotMap.CLOSE_SOL);
    	upDownSol = new DoubleSol(RobotMap.UP_SOL, RobotMap.DOWN_SOL);
    	leftSpark = new Spark(RobotMap.LEFT_SPARK);
    	rightSpark = new Spark(RobotMap.RIGHT_SPARK);
    	switch1 = new DigitalInput(RobotMap.GRIPPER_SWITCH);
    }
    
    public void swapOpenClose() {
    	openCloseSol.swap();
    }
    public void swapUpDown() {
    	upDownSol.swap();
    }

    public void setLeftSpark(double speed) {
    	leftSpark.set(speed);
    }
    
    public void setRightSpark(double speed) {
    	rightSpark.set(speed);
    }
    
    public boolean getSwitch() {
    	return switch1.get();
    }
    
    public static GripperSubsystem getInstance() {
    	if (instance==null)
    		instance = new GripperSubsystem();
    	return instance;
    }
    
    public void initDefaultCommand() {
        
    }
}

