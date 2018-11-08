package org.usfirst.frc.team4320.robot.commands;

import org.usfirst.frc.team4320.robot.subsystems.GripperSubsystem;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * Command for changing the height of the gripper (up or down)
 */
public class UpDownGripperInstantCommand extends InstantCommand {

	// Fields

	private GripperSubsystem gripperSubsystem;

	// Constructor

	/**
	 * The constructor of the class
	 */
	public UpDownGripperInstantCommand() {
		gripperSubsystem = GripperSubsystem.getInstance();
		requires(gripperSubsystem);
	}

	// Methods

	/**
	 * Switch between the states of the doubleSol
	 */
	protected void initialize() {
		gripperSubsystem.swapUpDown();
	}

}
