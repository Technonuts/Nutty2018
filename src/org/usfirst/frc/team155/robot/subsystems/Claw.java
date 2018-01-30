// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc.team155.robot.subsystems;

import org.usfirst.frc.team155.robot.RobotMap;
import org.usfirst.frc.team155.robot.commands.MoveLift;
import org.usfirst.frc.team155.robot.commands.MoveWrist;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 * 
 */
public class Claw extends PIDSubsystem {

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS
	public static final double STOW = 0;
	public static final double SWITCH = 20;
	public static final double LOWSCALE = 40;
	public static final double HIGHSCALE = 60;

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS
	public static final double LEFT = 0;
    public static final double CENTER= 24;
    public static final double RIGHT = 53;
    

  
	public static final double SPITSPEED = 1;
	public static final double SUCKSPEED = -1;
	public double cubeDistance;
	public double Scale = 1;
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	private final AnalogInput cubeSensor = RobotMap.clawCubeSensor;
	private final DoubleSolenoid gripper = RobotMap.clawGripper;
	private final WPI_VictorSPX elbow = RobotMap.clawElbow;
	private final DoubleSolenoid wrist = RobotMap.clawWrist;
	private final Spark clawLeftMotor = RobotMap.clawLeftMotor;
	private final Spark clawRightMotor = RobotMap.clawRightMotor;
	private final AnalogInput clawElbowPosition = RobotMap.clawElbowPosition;
	private final DigitalInput rightBoxSwitch = RobotMap.rightBoxSwitch;
	private final DigitalInput leftBoxSwitch = RobotMap.leftBoxSwitch;

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
public Claw() {
	 // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
    super("Claw", 1.0, 0.0, 0.0);
    setAbsoluteTolerance(0.2);
    getPIDController().setContinuous(false);
    LiveWindow.addActuator("Claw", "PIDSubsystem Controller", getPIDController());

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID

    // Use these to get going:
    // setSetpoint() -  Sets where the PID controller should move the system
    //                  to
    // enable() - Enables the PID controller.
	
}
	@Override
	public void initDefaultCommand() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		
		setDefaultCommand(new MoveWrist(0));
		

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	 protected double returnPIDInput() {
	        // Return your input value for the PID loop
	        // e.g. a sensor, like a potentiometer:
	        // yourPot.getAverageVoltage() / kYourMaxVoltage;

	        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
	        return clawElbowPosition.getVoltage();

	    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
	    }

	    @Override
	    protected void usePIDOutput(double output) {
	        // Use output to drive your system, like a motor
	        // e.g. yourMotor.set(output);

	        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
	    	elbow.pidWrite(output);

	    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
	    }

	@Override
	public void periodic() {
		// Put code here to be run every loop

	}

	public void openGripper() {
		gripper.set(DoubleSolenoid.Value.kForward);
	}
  public void closeGripper() {
		gripper.set(DoubleSolenoid.Value.kReverse);
		
	}
	

	public boolean extendWrist() {
		gripper.set(DoubleSolenoid.Value.kForward);
		return true;
	}

	public boolean retractWrist() {
		gripper.set(DoubleSolenoid.Value.kReverse);
		return true;
	}

	public void spitCube() {
		clawLeftMotor.set(SPITSPEED);
		clawRightMotor.set(SPITSPEED);
	}

	public void suckCube() {
		clawLeftMotor.set(SUCKSPEED);
		clawRightMotor.set(SUCKSPEED);
	}

	public void stopCube() {
		clawLeftMotor.set(0);
		clawRightMotor.set(0);
	}

	public double readCubeSensor() {
		cubeDistance = cubeSensor.getVoltage() * Scale;
		return (cubeDistance);
	}

	public boolean leftCubeSwitch() {
		return (leftBoxSwitch.get());
	}

	public boolean rightCubeSwitch() {
		return (rightBoxSwitch.get());
	}
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

}