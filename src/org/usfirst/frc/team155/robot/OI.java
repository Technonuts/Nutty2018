// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc.team155.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;

import org.usfirst.frc.team155.robot.commands.*;
import org.usfirst.frc.team155.robot.subsystems.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public JoystickButton lowSpeedButton;
	public Joystick leftStick;
	public JoystickButton highSpeedButton;
	public Joystick rightStick;
	public JoystickButton openGripperButton;
	public JoystickButton closeGripperButton;
	public Joystick switches;
	public JoystickButton suckCubeButton;
	public JoystickButton spitCubeButton;
	public JoystickButton searchForCube;
	public JoystickButton wristButton;
	public JoystickButton hangingButton;
	public JoystickButton liftButtonFence;
	public JoystickButton liftButtonFloor;
	public JoystickButton liftButtonLowScale;
	public JoystickButton liftButtonHighScale;
	
	
	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	public OI() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

		switches = new Joystick(2);

		//closeGripperButton = new JoystickButton(switches, 1);
		//closeGripperButton.whenPressed(new CloseGripper());
		//openGripperButton = new JoystickButton(switches, 2);
		//openGripperButton.whenPressed(new OpenGripper());
		rightStick = new Joystick(1);

		highSpeedButton = new JoystickButton(rightStick, 1);
		highSpeedButton.whenPressed(new HighSpeed());
		leftStick = new Joystick(0);


		lowSpeedButton = new JoystickButton(leftStick, 1);
		lowSpeedButton.whenPressed(new LowSpeed());

		/*
		suckCubeButton = new JoystickButton(switches, 5);
		suckCubeButton.whenPressed(new SuckingCube());
		suckCubeButton.whenReleased(new HoldCube());
*/
	suckCubeButton = new JoystickButton(switches, 5);
		suckCubeButton.whenPressed(new CubeAquire());
		
		spitCubeButton = new JoystickButton(switches, 4);
		spitCubeButton.whenPressed(new SpittingCube());
		//spitCubeButton.whenReleased(new DrivingMode());

		/*
		searchForCube = new JoystickButton(switches, 9);
		searchForCube.whenPressed(new SearchCube());
		*/
		
		wristButton = new JoystickButton(switches, 8);
		wristButton.whenPressed(new ExtendWrist());
		wristButton.whenReleased(new RetractWrist());
		
		hangingButton = new JoystickButton(switches, 6);
		hangingButton.whenPressed(new startClimbing());
		hangingButton.whenReleased(new stopClimbing());
		
		liftButtonFence = new JoystickButton(switches, 7);
		liftButtonFence.whenPressed(new MoveLift(Elevator.FENCEHEIGHT));
		
		liftButtonFloor = new JoystickButton(switches, 8);
		liftButtonFloor.whenPressed(new MoveLift(Elevator.FLOORHEIGHT));
		
		liftButtonLowScale = new JoystickButton(switches, 10);
		liftButtonLowScale.whenPressed(new MoveLift(Elevator.LOWSCALEHEIGHT));
		
		liftButtonHighScale = new JoystickButton(switches, 11);
		liftButtonHighScale.whenPressed(new MoveLift(Elevator.HIGHSCALEHEIGHT));
				
									
	//this is for a commit
		// SmartDashboard Buttons
		//SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
		//SmartDashboard.putData("TankDrive", new TankDrive());
		//SmartDashboard.putData("StopDrive", new StopDrive());
		//SmartDashboard.putData("Move Lift: Floor", new MoveLift(Elevator.FLOORHEIGHT));
		/*SmartDashboard.putData("Move Lift: Switch", new MoveLift(Elevator.FENCEHEIGHT));
		SmartDashboard.putData("Move Lift: LowScale", new MoveLift(Elevator.LOWSCALEHEIGHT));
		SmartDashboard.putData("Move Lift: HighScale", new MoveLift(Elevator.HIGHSCALEHEIGHT));
		SmartDashboard.putData("Move Lift: Hang", new MoveLift(Elevator.HANGHEIGHT));
		//SmartDashboard.putData("Open Gripper", new OpenGripper());
		//SmartDashboard.putData("Close Gripper", new CloseGripper());
		SmartDashboard.putData("High Speed", new HighSpeed());
		SmartDashboard.putData("Low Speed", new LowSpeed());
		// SmartDashboard.putData("Drive Straight Distance", new
		// DriveStraightDistance());
	*/
		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
	}

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
	public Joystick getLeftStick() {
		return leftStick;
	}

	public Joystick getRightStick() {
		return rightStick;
	}

	public Joystick getSwitches() {
		return switches;
	}

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}
