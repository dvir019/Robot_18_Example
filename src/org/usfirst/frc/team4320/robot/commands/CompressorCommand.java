package org.usfirst.frc.team4320.robot.commands;

import org.usfirst.frc.team4320.robot.subsystems.CompressorSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command for starting and stopping the compressor
 */
public class CompressorCommand extends Command {

	// Fields

	private static final int MIN_PRESSURE = 40;
	private static final int MAX_PRESSURE = 120;

	private CompressorSubsystem compressorSubsystem;

	// Constructor

	/**
	 * The constructor of the class
	 */
	public CompressorCommand() {
		compressorSubsystem = CompressorSubsystem.getInstance();
		requires(compressorSubsystem);
	}

	// Methods

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	/**
	 * Turn on and off the compressor: Turn on if pressure below/equal MIN_PRESSURE
	 * and the compressor is closed Turn off if pressure under/equal MAX_PRESSURE
	 * and the compressor is open
	 */
	protected void execute() {
		double pressure = compressorSubsystem.getPressure();
		boolean working = compressorSubsystem.isWorking();
		if (pressure >= MAX_PRESSURE && working)
			compressorSubsystem.stop();
		else if (pressure <= MIN_PRESSURE && !working) {
			compressorSubsystem.start();
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
