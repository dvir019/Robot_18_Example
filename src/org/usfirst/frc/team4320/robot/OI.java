/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4320.robot;

import javax.management.relation.RelationService;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.usfirst.frc.team4320.robot.commands.ElevatorCommand;
import org.usfirst.frc.team4320.robot.commands.GripperWheelsCommand;
import org.usfirst.frc.team4320.robot.commands.OpenCloseGripperInstantCommand;
import org.usfirst.frc.team4320.robot.commands.OverrideGripperSubsystem;
import org.usfirst.frc.team4320.robot.commands.ShifterInstantCommand;
import org.usfirst.frc.team4320.robot.commands.UpDownGripperInstantCommand;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private static OI instance = null;

	private XboxController xbox;
	private Joystick joystick;
	private JoystickButton openCloseGripper;
	private JoystickButton upDownGripper;
	private JoystickButton rotateGripperWheels;
	private JoystickButton shifterButton;
	private JoystickButton gripperOverride;

	private OI() {
		xbox = new XboxController(RobotMap.XBOX_CONTROLLER);
		joystick = new Joystick(RobotMap.JOYSTICK);

		openCloseGripper = new JoystickButton(xbox, 1); // A
		openCloseGripper.whenPressed(new OpenCloseGripperInstantCommand());

		upDownGripper = new JoystickButton(xbox, 2); // B
		upDownGripper.whenPressed(new UpDownGripperInstantCommand());

		rotateGripperWheels = new JoystickButton(xbox, 3); // X
		rotateGripperWheels.whileHeld(new GripperWheelsCommand());

		gripperOverride = new JoystickButton(xbox, 6); // KB
		gripperOverride.whenPressed(new OverrideGripperSubsystem());

		shifterButton = new JoystickButton(joystick, 1);
		shifterButton.whenPressed(new ShifterInstantCommand());
	}

	public double getXboxRightJoystickY() {
		return xbox.getY(GenericHID.Hand.kRight);
	}

	public double getJoystickX() {
		return joystick.getX();
	}

	public double getJoystickY() {
		return joystick.getY();
	}

	public static OI getInstance() {
		if (instance == null)
			instance = new OI();
		return instance;
	}
}
