package org.usfirst.frc.team4320.robot.commands;

import org.usfirst.frc.team4320.robot.subsystems.GripperSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GripperWheelsCommand extends Command {
	
	private GripperSubsystem gripperSubsystem;

    public GripperWheelsCommand() {
        gripperSubsystem = GripperSubsystem.getInstance();
        requires(gripperSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	gripperSubsystem.setLeftSpark(1);
    	gripperSubsystem.setRightSpark(-1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return gripperSubsystem.getSwitch();
    }

    // Called once after isFinished returns true
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
