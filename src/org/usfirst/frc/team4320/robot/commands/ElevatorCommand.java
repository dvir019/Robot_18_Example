package org.usfirst.frc.team4320.robot.commands;

import org.usfirst.frc.team4320.robot.OI;
import org.usfirst.frc.team4320.robot.Robot;
import org.usfirst.frc.team4320.robot.subsystems.ElevatorSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorCommand extends Command {
	
	private ElevatorSubsystem elevatorSubsystem;

    public ElevatorCommand() {
        elevatorSubsystem = ElevatorSubsystem.getInstance();
    	requires(elevatorSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	elevatorSubsystem.setSpark(OI.getInstance().getXboxRightJoystickY());
    }

	/**
	 * Checks if the switch closed
	 * 
	 * @return true if the command needs to stop to execute, else false
	 */
    protected boolean isFinished() {
        return elevatorSubsystem.stop();
    }

    // Called once after isFinished returns true
    protected void end() {
    	elevatorSubsystem.setSpark(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
