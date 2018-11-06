package org.usfirst.frc.team4320.robot.commands;

import org.usfirst.frc.team4320.robot.subsystems.GripperSubsystem;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class UpDownGripperInstantCommand extends InstantCommand {

	private GripperSubsystem gripperSubsystem;
	
    public UpDownGripperInstantCommand() {
    	gripperSubsystem = GripperSubsystem.getInstance();
        requires(gripperSubsystem);
    }

    // Called once when the command executes
    protected void initialize() {
    	gripperSubsystem.swapUpDown();
    }

}
