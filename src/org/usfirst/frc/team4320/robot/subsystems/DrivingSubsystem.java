package org.usfirst.frc.team4320.robot.subsystems;

import java.security.PublicKey;

import org.usfirst.frc.team4320.robot.RobotMap;
import org.usfirst.frc.team4320.robot.commands.DrivingCommand;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Subsystem for driving the robot
 */
public class DrivingSubsystem extends Subsystem {
	
	// Fields

    private static DrivingSubsystem instance;
    private WPI_TalonSRX topLeftTalon;
    private WPI_TalonSRX topRightTalon;
    private WPI_TalonSRX bottomLeftTalon;
    private WPI_TalonSRX bottomRightTalon;
    private SpeedControllerGroup leftTalons;
    private SpeedControllerGroup rightTalons;
    private DifferentialDrive differentialDrive;
    private AnalogGyro gyro;
    
    private final double maxSpeed = 1;
    private final double minSpeed = -1;
    
    
	// Constructor and SingleRon

	/**
	 * The constructor of the class
	 */
    private DrivingSubsystem() {
    	topLeftTalon = new WPI_TalonSRX(RobotMap.TOP_LEFT_TALON);
    	topLeftTalon.setSafetyEnabled(true);
    	topLeftTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    	topRightTalon = new WPI_TalonSRX(RobotMap.TOP_RIGHT_TALON);
    	topRightTalon.setSafetyEnabled(true);
    	topRightTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    	bottomLeftTalon = new WPI_TalonSRX(RobotMap.BOTTOM_LEFT_TALON);
    	bottomLeftTalon.setSafetyEnabled(true);
    	bottomLeftTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    	bottomRightTalon= new WPI_TalonSRX(RobotMap.BOTTOM_RIGHT_TALON);
    	bottomRightTalon.setSafetyEnabled(true);
    	bottomRightTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    	
    	leftTalons = new SpeedControllerGroup(topLeftTalon, topRightTalon);
    	rightTalons = new SpeedControllerGroup(bottomLeftTalon, bottomRightTalon);
    	
    	differentialDrive = new DifferentialDrive(leftTalons, rightTalons);
    	
    	gyro = new AnalogGyro(RobotMap.GYRO);
    	
    	// SmartDashboard
    	SmartDashboard.putNumber("Top Left Encoder", (double)topLeftTalon.getSelectedSensorPosition(0));
    	SmartDashboard.putNumber("Top Right Encoder", (double)topRightTalon.getSelectedSensorPosition(0));
    	SmartDashboard.putNumber("Bottom Left Encoder", (double)bottomLeftTalon.getSelectedSensorPosition(0));
    	SmartDashboard.putNumber("Bottom Right Encoder", (double)bottomRightTalon.getSelectedSensorPosition(arg0));
    	SmartDashboard.putNumber("Gyro", gyro.getAngle());
    }
    
    /**
	 * SingleTon for the class
	 * 
	 * @return An instance of the class
	 */
    public static DrivingSubsystem getInstance() {
    	if (instance==null)
    		instance = new DrivingSubsystem();
    	return instance;
    }
    
    
	// Methods
        
    /**
     * Set the speed of the talons
     * In addition, update the SmartDashboard's information about the encoders
     * 
     * @param leftSpeed - The new speed of the left talons
     * @param rightSpeed - The new speed of the right talons
     */
    public void setTalons(double leftSpeed, double rightSpeed) {
    	if (leftSpeed > maxSpeed)
			leftSpeed = maxSpeed;
		else if (leftSpeed < minSpeed)
			leftSpeed = minSpeed;
		if (rightSpeed > maxSpeed)
			rightSpeed = maxSpeed;
		else if (rightSpeed < minSpeed)
			rightSpeed = minSpeed;
		differentialDrive.tankDrive(leftSpeed, rightSpeed);
		
		// SmartDashboard
    	SmartDashboard.putNumber("Top Left Encoder", (double)topLeftTalon.getSelectedSensorPosition(0));
    	SmartDashboard.putNumber("Top Right Encoder", (double)topRightTalon.getSelectedSensorPosition(0));
    	SmartDashboard.putNumber("Bottom Left Encoder", (double)bottomLeftTalon.getSelectedSensorPosition(0));
    	SmartDashboard.putNumber("Bottom Right Encoder", (double)bottomRightTalon.getSelectedSensorPosition(0));
    	SmartDashboard.putNumber("Gyro", gyro.getAngle());
    }
    

    /**
     * Set a default command for the subsystem
     */
    public void initDefaultCommand() {
        setDefaultCommand(new DrivingCommand());
    }
}

