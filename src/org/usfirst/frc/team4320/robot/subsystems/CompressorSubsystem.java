package org.usfirst.frc.team4320.robot.subsystems;

import org.usfirst.frc.team4320.robot.RobotMap;
import org.usfirst.frc.team4320.robot.commands.CompressorCommand;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Subsystem for the compressor
 */
public class CompressorSubsystem extends Subsystem {

	// Fields

	private static CompressorSubsystem instance;
	private static final int Vcc = 5;

	private Compressor compressor;
	private AnalogInput pressureSensor;

	// Constructor and SingleTon

	/**
	 * The constructor of the class
	 */
	private CompressorSubsystem() {
		compressor = new Compressor(RobotMap.COMPRESSOR);
		compressor.setClosedLoopControl(false);

		pressureSensor = new AnalogInput(RobotMap.PRESSURE_SENSOR);
	}

	/**
	 * SingleTon for the class
	 * 
	 * @return An instance of the class
	 */
	public static CompressorSubsystem getInstance() {
		if (instance == null)
			instance = new CompressorSubsystem();
		return instance;
	}

	// Methods

	public double getPressure() {
		return 250 * (((double) pressureSensor.getValue()) / Vcc) - 25;
	}

	public void start() {
		compressor.start();
		SmartDashboard.putBoolean("Compressor", true);
	}

	public void stop() {
		compressor.stop();
		SmartDashboard.putBoolean("Compressor", false);
	}

	public boolean isWorking() {
		return compressor.enabled();
	}

	public void initDefaultCommand() {
		setDefaultCommand(new CompressorCommand());
	}
}
