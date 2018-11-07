package org.usfirst.frc.team4320.robot.commands;

import org.usfirst.frc.team4320.robot.subsystems.GripperSubsystem;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * Command for opening and closing the gripper
 */
public class OpenCloseGripperInstantCommand extends InstantCommand {
	
	private GripperSubsystem gripperSubsystem;

	/**
	 * The constructor of the class
	 */
	public OpenCloseGripperInstantCommand() {
        gripperSubsystem = GripperSubsystem.getInstance();
        requires(gripperSubsystem);
    }

    /**
     * Switch between the states of the doubleSol
     */
    protected void initialize() {
    	gripperSubsystem.swapOpenClose();
    }
}
