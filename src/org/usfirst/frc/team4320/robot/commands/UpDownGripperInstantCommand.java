package org.usfirst.frc.team4320.robot.commands;

import org.usfirst.frc.team4320.robot.subsystems.GripperSubsystem;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * Command for changing the height of the gripper (up or down)
 */
public class UpDownGripperInstantCommand extends InstantCommand {

	private GripperSubsystem gripperSubsystem;
	
	/**
	 * The constructor of the class
	 */
    public UpDownGripperInstantCommand() {
    	gripperSubsystem = GripperSubsystem.getInstance();
        requires(gripperSubsystem);
    }

    
    /**
     * Switch between the states of the doubleSol
     */
    protected void initialize() {
    	gripperSubsystem.swapUpDown();
    }

}
