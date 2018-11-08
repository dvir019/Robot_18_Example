package org.usfirst.frc.team4320.robot.commands;

import org.usfirst.frc.team4320.robot.subsystems.GripperSubsystem;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * Command for switching the state of the gripper's override mode
 */
public class OverrideGripperSubsystem extends InstantCommand {

	// Fields

	private GripperSubsystem gripperSubsystem;

	// Constructor

	/**
	 * The constructor of the class
	 */
	public OverrideGripperSubsystem() {
		gripperSubsystem = GripperSubsystem.getInstance();
		requires(gripperSubsystem);
	}

	// Methods

	// Called once when the command executes
	protected void initialize() {
		gripperSubsystem.swapOverride();
	}

}
