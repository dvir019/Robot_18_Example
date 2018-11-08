package org.usfirst.frc.team4320.robot.subsystems;

import org.usfirst.frc.team4320.robot.RobotMap;

import Classes.DoubleSol;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Subsystem for the gripper
 */
public class GripperSubsystem extends Subsystem {

	// Fields
	private static GripperSubsystem instance = null;

	private DoubleSol openCloseSol;
	private DoubleSol upDownSol;
	private Spark leftSpark;
	private Spark rightSpark;
	private DigitalInput switch1;

	private boolean override = false;

	// Constructor and SingleRon

	/**
	 * The constructor of the class
	 */
	private GripperSubsystem() {
		openCloseSol = new DoubleSol(RobotMap.OPEN_SOL, RobotMap.CLOSE_SOL);
		upDownSol = new DoubleSol(RobotMap.UP_SOL, RobotMap.DOWN_SOL);
		leftSpark = new Spark(RobotMap.LEFT_SPARK);
		rightSpark = new Spark(RobotMap.RIGHT_SPARK);
		switch1 = new DigitalInput(RobotMap.GRIPPER_SWITCH);

		SmartDashboard.putBoolean("Override Gripper", override);
	}

	/**
	 * SingleTon for the class
	 * 
	 * @return An instance of the class
	 */
	public static GripperSubsystem getInstance() {
		if (instance == null)
			instance = new GripperSubsystem();
		return instance;
	}

	// Methods

	/**
	 * Swap the state of the openClose doubleSol
	 */
	public void swapOpenClose() {
		openCloseSol.swap();
	}

	/**
	 * Swap the state of the upDown doubleSol
	 */
	public void swapUpDown() {
		upDownSol.swap();
	}

	/**
	 * Set the speed of the left spark
	 * 
	 * @param speed
	 *            - The new speed
	 */
	public void setLeftSpark(double speed) {
		leftSpark.set(speed);
	}

	/**
	 * Set the speed of the right spark
	 * 
	 * @param speed
	 *            - The new speed
	 */
	public void setRightSpark(double speed) {
		rightSpark.set(speed);
	}

	/**
	 * Get the state of the switch
	 * 
	 * @return true if it's close, else false
	 */
	public boolean getSwitch() {
		return switch1.get();
	}

	/**
	 * Change the value of the override field from true to false and vice versa
	 */
	public void swapOverride() {
		if (override)
			override = false;
		else
			override = true;
		SmartDashboard.putBoolean("Override Gripper", override);
	}

	/**
	 * Get the override field
	 * 
	 * @return The override field
	 */
	public boolean getOverride() {
		return override;
	}

	public void initDefaultCommand() {

	}
}
