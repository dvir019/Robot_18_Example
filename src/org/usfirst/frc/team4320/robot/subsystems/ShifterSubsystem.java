package org.usfirst.frc.team4320.robot.subsystems;

import org.usfirst.frc.team4320.robot.RobotMap;

import Classes.DoubleSol;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem for the shifter's switching
 */
public class ShifterSubsystem extends Subsystem {

	// Fields

	private static ShifterSubsystem instance;

	private DoubleSol doubleSol;

	// Constructor and SingleRon

	/**
	 * The constructor of the class
	 */
	private ShifterSubsystem() {
		doubleSol = new DoubleSol(RobotMap.OPEN_SHIFTER, RobotMap.CLOSE_SHIFTER);
	}

	/**
	 * SingleTon for the class
	 * 
	 * @return An instance of the class
	 */
	public static ShifterSubsystem getinstance() {
		if (instance == null)
			instance = new ShifterSubsystem();
		return instance;
	}

	// Methods

	/**
	 * Swap the doubleSol's state
	 */
	public void swap() {
		doubleSol.swap();
	}

	public void initDefaultCommand() {

	}
}