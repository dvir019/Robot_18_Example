package org.usfirst.frc.team4320.robot.commands;

import org.usfirst.frc.team4320.robot.subsystems.ShifterSubsystem;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ShifterInstantCommand extends InstantCommand {
	
	private ShifterSubsystem shifterSubsystem;

    public ShifterInstantCommand() {
        shifterSubsystem = ShifterSubsystem.getinstance();
        requires(shifterSubsystem);
    }

    // Called once when the command executes
    protected void initialize() {
    	shifterSubsystem.swap();
    }

}
