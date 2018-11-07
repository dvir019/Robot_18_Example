package org.usfirst.frc.team4320.robot.commands;

import org.usfirst.frc.team4320.robot.subsystems.ShifterSubsystem;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * Command for switching between the states of the shifter
 */
public class ShifterInstantCommand extends InstantCommand {
	
	private ShifterSubsystem shifterSubsystem;

	/**
	 * The constructor of the class
	 */
    public ShifterInstantCommand() {
        shifterSubsystem = ShifterSubsystem.getinstance();
        requires(shifterSubsystem);
    }

    /**
     * Switch between the states of the doubleSol
     */
    protected void initialize() {
    	shifterSubsystem.swap();
    }

}
