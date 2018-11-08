package org.usfirst.frc.team4320.robot.commands;

import org.usfirst.frc.team4320.robot.subsystems.GripperSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command for setting the gripper's wheels speed
 */
public class GripperWheelsCommand extends Command {

	// Fields

	private GripperSubsystem gripperSubsystem;

	// Constructor

	/**
	 * The constructor of the class
	 */
	public GripperWheelsCommand() {
		gripperSubsystem = GripperSubsystem.getInstance();
		requires(gripperSubsystem);
		setInterruptible(true);
	}

	// Methods

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	/**
	 * Set the gripper's sparks to 1 and -1
	 */
	protected void execute() {
		gripperSubsystem.setLeftSpark(1);
		gripperSubsystem.setRightSpark(-1);
	}

	/**
	 * Check if the wheels should stop spinning If override mode is activated,
	 * always return false If it's not activated, check if the micro-switch is
	 * pressed
	 * 
	 * @return false if override mode is activated, or the micro-switch is closed,
	 *         else true
	 */
	protected boolean isFinished() {
		if (gripperSubsystem.getOverride())
			return false;
		return gripperSubsystem.getSwitch();
	}

	/**
	 * Stop the sparks
	 */
	protected void end() {
		gripperSubsystem.setLeftSpark(0);
		gripperSubsystem.setRightSpark(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
