package org.usfirst.frc.team4320.robot.subsystems;

import java.security.PublicKey;

import org.usfirst.frc.team4320.robot.RobotMap;
import org.usfirst.frc.team4320.robot.commands.DrivingCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DrivingSubsystem extends Subsystem {

    private static DrivingSubsystem instance;
    private WPI_TalonSRX topLeftTalon;
    private WPI_TalonSRX topRightTalon;
    private WPI_TalonSRX bottomLeftTalon;
    private WPI_TalonSRX bottomRightTalon;
    private SpeedControllerGroup leftTalons;
    private SpeedControllerGroup rightTalons;
    private DifferentialDrive differentialDrive;
    
    private final double maxSpeed = 1;
    private final double minSpeed = -1;
    
    
    private DrivingSubsystem() {
    	topLeftTalon = new WPI_TalonSRX(RobotMap.TOP_LEFT_TALON);
    	topLeftTalon.setSafetyEnabled(true);
    	topRightTalon = new WPI_TalonSRX(RobotMap.TOP_RIGHT_TALON);
    	topRightTalon.setSafetyEnabled(true);
    	bottomLeftTalon = new WPI_TalonSRX(RobotMap.BOTTOM_LEFT_TALON);
    	bottomLeftTalon.setSafetyEnabled(true);
    	bottomRightTalon= new WPI_TalonSRX(RobotMap.BOTTOM_RIGHT_TALON);
    	bottomRightTalon.setSafetyEnabled(true);
    	
    	leftTalons = new SpeedControllerGroup(topLeftTalon, topRightTalon);
    	rightTalons = new SpeedControllerGroup(bottomLeftTalon, bottomRightTalon);
    	
    	differentialDrive = new DifferentialDrive(leftTalons, rightTalons);
    }
    
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
    }
    
    public static DrivingSubsystem getInstance() {
    	if (instance==null)
    		instance = new DrivingSubsystem();
    	return instance;
    }

    public void initDefaultCommand() {
        setDefaultCommand(new DrivingCommand());
    }
}

