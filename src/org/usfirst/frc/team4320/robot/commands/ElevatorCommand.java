package org.usfirst.frc.team4320.robot.commands;

import org.usfirst.frc.team4320.robot.OI;
import org.usfirst.frc.team4320.robot.Robot;
import org.usfirst.frc.team4320.robot.subsystems.ElevatorSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command for controlling the speed of the elevator
 */
public class ElevatorCommand extends Command {
	
	private ElevatorSubsystem elevatorSubsystem;

	/**
	 * The constructor of the class
	 */
    public ElevatorCommand() {
        elevatorSubsystem = ElevatorSubsystem.getInstance();
    	requires(elevatorSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    /**
     * Set the speed of the spark according to the Y coordinate of the right joysick of the Xbox
     */
    protected void execute() {
    	elevatorSubsystem.setSpark(OI.getInstance().getXboxRightJoystickY());
    }

	/**
	 * Checks if the switch is closed
	 * 
	 * @return true if the command needs to stop to execute, else false
	 */
    protected boolean isFinished() {
        return elevatorSubsystem.stop();
    }

    /**
     * Stop the elevator
     */
    protected void end() {
    	elevatorSubsystem.setSpark(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
