package org.usfirst.frc.team4320.robot.subsystems;

import org.usfirst.frc.team4320.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ElevatorSubsystem extends Subsystem {

    private static ElevatorSubsystem instance = null;
    
    private Spark spark;
    private DigitalInput switch1;
    private DigitalInput switch2;
    
    /**
	 * The constructor of the class
	 */
    private ElevatorSubsystem() {
    	spark = new Spark(RobotMap.SPARK_PORT);
    	switch1 = new DigitalInput(RobotMap.ELEVATOR_SWITCH_1);
    	switch2 = new DigitalInput(RobotMap.ELEVATOR_SWITCH_2);
    }
    
    public void setSpark(double speed) {
		if (speed >= -1 && speed <= 1)
			spark.set(speed);
	}
    
    public boolean stop() {
		return switch1.get() || switch2.get();
	}
    
    /**
	 * SingleTon for the class
	 * 
	 * @return An instance of the class
	 */
    public static ElevatorSubsystem getInstance() {
    	if (instance==null)
    		instance = new ElevatorSubsystem();
    	return instance;
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

