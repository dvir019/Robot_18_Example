/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4320.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	

	// DrivingSubsystem - PWM
	public static final int TOP_LEFT_TALON = 0;
	public static final int TOP_RIGHT_TALON = 1;
	public static final int BOTTOM_LEFT_TALON = 2;
	public static final int BOTTOM_RIGHT_TALON = 3;
	
	// DrivingSubsystem - Analog
	public static final int GYRO = 0;
	
	
	// ElevatorSubsystem - PWM
	public static final int SPARK_PORT = 4;
	public static final int ELEVATOR_SWITCH_1 = 5;
	public static final int ELEVATOR_SWITCH_2 = 6;
	
	
	// GripperSubsystem - PCM
	public static final int OPEN_SOL = 0;
	public static final int CLOSE_SOL = 1;
	public static final int UP_SOL = 2;
	public static final int DOWN_SOL = 3;
	
	// GripperSubsystem - PWM
	public static final int LEFT_SPARK = 7;
	public static final int RIGHT_SPARK = 8;
	public static final int GRIPPER_SWITCH = 9;
	
	
	// ShifterSubsystem - PCM
	public static final int OPEN_SHIFTER = 4;
	public static final int CLOSE_SHIFTER = 4;
	
	
	// OI - Driver station
	public static final int XBOX_CONTROLLER = 1;
	public static final int JOYSTICK = 2;
}
