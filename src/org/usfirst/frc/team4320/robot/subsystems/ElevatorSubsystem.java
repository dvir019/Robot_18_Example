package org.usfirst.frc.team4320.robot.subsystems;

import org.usfirst.frc.team4320.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem for the elevator
 */
public class ElevatorSubsystem extends Subsystem {

	// Fields

	private static ElevatorSubsystem instance = null;

	private Spark spark;
	private DigitalInput switch1;
	private DigitalInput switch2;

	// Constructor and SingleRon

	/**
	 * The constructor of the class
	 */
	private ElevatorSubsystem() {
		spark = new Spark(RobotMap.SPARK_PORT);
		switch1 = new DigitalInput(RobotMap.ELEVATOR_SWITCH_1);
		switch2 = new DigitalInput(RobotMap.ELEVATOR_SWITCH_2);
	}

	/**
	 * SingleTon for the class
	 * 
	 * @return An instance of the class
	 */
	public static ElevatorSubsystem getInstance() {
		if (instance == null)
			instance = new ElevatorSubsystem();
		return instance;
	}

	// Methods

	/**
	 * Set the speed of the spark
	 * 
	 * @param speed
	 *            - The new speed
	 */
	public void setSpark(double speed) {
		if (speed >= -1 && speed <= 1)
			spark.set(speed);
	}

	/**
	 * Check if one of the switches are closed, and the elevator should stop moving
	 * 
	 * @return true if one of them close, else false
	 */
	public boolean stop() {
		return switch1.get() || switch2.get();
	}

	public void initDefaultCommand() {

	}
}
