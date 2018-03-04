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

import org.usfirst.frc.team155.robot.Robot;
import org.usfirst.frc.team155.robot.RobotMap;
import org.usfirst.frc.team155.robot.commands.MoveLift;
import org.usfirst.frc.team155.robot.commands.MoveWrist;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 * 
 */
public class Claw extends PIDSubsystem {

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS


	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS
	public static final double LEFT = 0;
	public static final double CENTER = 24;
	public static final double RIGHT = 53;
	public static final double armScale = 1; //3600 / 5;
	public static final double intercept = 2.43;//.15;

	public static final double SPITSPEED = -1;
	public static final double SUCKSPEED = .7;
	public double cubeDistance;
	public double Scale = 104;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public final AnalogInput cubeSensor = RobotMap.clawCubeSensor;
	private final DoubleSolenoid gripperSolenoid = RobotMap.gripperPneumatics;
	private final VictorSP elbow = RobotMap.clawElbow;
	private final DoubleSolenoid wrist = RobotMap.clawWrist;
	private final Spark clawLeftMotor = RobotMap.clawLeftMotor;
	private final Spark clawRightMotor = RobotMap.clawRightMotor;
	public final AnalogInput clawElbowPosition = RobotMap.clawElbowPosition;
	private final DigitalInput rightBoxSwitch = RobotMap.rightBoxSwitch;
	private final DigitalInput leftBoxSwitch = RobotMap.leftBoxSwitch;

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public Claw() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
		super("Claw", 1.0, 0.0, 0.0);
		setAbsoluteTolerance(0.2);
		getPIDController().setContinuous(false);
		LiveWindow.addActuator("Claw", "PIDSubsystem Controller", getPIDController());
		LiveWindow.addSensor("Claw", "cubeSensor", cubeSensor);
		LiveWindow.addActuator("Claw", "elbow", elbow);
		LiveWindow.addActuator("Claw", "clawElbowPosition", clawElbowPosition);

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID

		// Use these to get going:
		// setSetpoint( ) - Sets where the PID controller should move the system to
		// enable( ) - Enables the PID controller.

	}

	@Override
	public void initDefaultCommand() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
		//setDefaultCommand(new MoveWrist(0));
		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// Set the default command for a subsystem here.
		// setDefaultCommand( new MySpecialCommand( ));
	}

	protected double returnPIDInput() {
		// Return your input value for the PID loop
		// e.g. a sensor, like a potentiometer:
		// yourPot.getAverageVoltage( ) / kYourMaxVoltage;

		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
		return clawElbowPosition.getVoltage();

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
	}

	@Override
	protected void usePIDOutput(double output) {
		// Use output to drive your system, like a motor
		// e.g. yourMotor.set( output);

		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
		elbow.pidWrite(output);

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
	}

	@Override
	public void periodic() {
		// Put code here to be run every loop

	}

	public void openGripper() {
		gripperSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void closeGripper() {
		gripperSolenoid.set(DoubleSolenoid.Value.kReverse);

	}

	public boolean extendWrist() {
		// we want to make sure that the wrist only extends when the height is equal or
		// below fence height
		//if (Robot.elevator.getHeight() <= RobotMap.FENCEHEIGHT)
			wrist.set(DoubleSolenoid.Value.kReverse);

		return true;

	}

	public boolean retractWrist() {
		wrist.set(DoubleSolenoid.Value.kForward);
		return true;
	}

	public void spitCube() {
		clawLeftMotor.set(-SPITSPEED);
		clawRightMotor.set(SPITSPEED);
	}

	public void suckCube() {
		clawLeftMotor.set(-SUCKSPEED);
		clawRightMotor.set(SUCKSPEED);
	}

	public void stopCube() {
		clawLeftMotor.set(0);
		clawRightMotor.set(0);
	}

	public double readCubeSensor() {
		cubeDistance = cubeSensor.getVoltage() * Scale;
		// System.out.println( "cubeDistance"+cubeDistance);
		// System.out.println( "Voltage"+cubeSensor.getVoltage( ));
		// System.out.println( "averageVoltage"+cubeSensor.getAverageVoltage( ));

		return cubeDistance;
	}

	public boolean leftCubeSwitch() {
		return (leftBoxSwitch.get());
	}

	public boolean rightCubeSwitch() {
		return (rightBoxSwitch.get());
	}

	public double getArmPosition() {
		double armPosition = (armScale * clawElbowPosition.getAverageVoltage()) + intercept;
		return armPosition;
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

}
