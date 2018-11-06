package org.usfirst.frc.team4320.robot.commands;

import org.usfirst.frc.team4320.robot.OI;
import org.usfirst.frc.team4320.robot.subsystems.DrivingSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DrivingCommand extends Command {
	
	private DrivingSubsystem drivingSubsystem;

    public DrivingCommand() {
        drivingSubsystem = DrivingSubsystem.getInstance();
        requires(drivingSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivingSubsystem.setTalons(OI.getInstance().getJoystickX(), OI.getInstance().getJoystickY());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	drivingSubsystem.setTalons(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
