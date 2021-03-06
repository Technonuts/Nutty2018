// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


//retract after get cube

package org.usfirst.frc.team155.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.GenericHID;
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
	public JoystickButton searchCubeButton;
	public JoystickButton openCubeButton;
	public JoystickButton closeCubeButton;
	public JoystickButton spitCubeButton;
	public JoystickButton searchForCube;
	public JoystickButton wristextButton;
	public JoystickButton wristretButton;
	public JoystickButton hangingButton;
	public JoystickButton liftButtonFence;
	public JoystickButton liftButtonFloor;
	public JoystickButton liftButtonLowScale;
	public JoystickButton liftButtonHighScale;
	public JoystickButton climbButton;
	public JoystickButton driveTest;
	public JoystickButton turn90;
	public JoystickButton turnother90;
	public JoystickButton tankDrive;
	public JoystickButton reverseDrive;
	


	public static RobotMap robotmap;


	
	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	public OI() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

		switches = new Joystick(2);
		rightStick = new Joystick(1);
		leftStick = new Joystick(0);
		
		//closeGripperButton = new JoystickButton(switches, 1);
		//closeGripperButton.whenPressed(new CloseGripper());
		//openGripperButton = new JoystickButton(switches, 2);
		//openGripperButton.whenPressed(new OpenGripper())
		
		int direction = switches.getPOV(0);

		if (direction == 90) { // DPAD UP button is pressed
		  //new OLDMoveWrist(90);
		} 
		else if (direction == 45) { // DPAD DOWN button is pressed
		  // do something else
			//  new OLDMoveWrist(45);
		}
		else if (direction == 0) { // DPAD DOWN button is pressed
			  // do something else
			 // new OLDMoveWrist(0);
			  
			}
		else if (direction == 315) { // DPAD DOWN button is pressed
			  // do something else
			 // new OLDMoveWrist(-45);
			}
		else if (direction == 270) { // DPAD DOWN button is pressed
			  // do something else
			 // new OLDMoveWrist(-90);
			}
		

		// You can interpret the D-pad as an axis as well:
		//double dpadYAxisValue = Math.cos(Math.toRadians(direction));
		//double dpadXAxisValue = Math.sin(Math.toRadians(direction));

		

		highSpeedButton = new JoystickButton(leftStick, 1);
		highSpeedButton.whenPressed(new HighSpeed());

		lowSpeedButton = new JoystickButton(rightStick, 1);
		lowSpeedButton.whenPressed(new LowSpeed());
		
		tankDrive  = new JoystickButton(leftStick, 4);  //change number
		tankDrive.whenPressed(new TankDrive());
		
		reverseDrive  = new JoystickButton(leftStick, 5);  //change number
		reverseDrive.whenPressed(new ReverseTankDrive());

		
		closeCubeButton = new JoystickButton(rightStick, 6);
		closeCubeButton.whenPressed(new CloseCube());
		//suckCubeButton.whenReleased(new HoldCube());
		openCubeButton = new JoystickButton(rightStick, 5);
		openCubeButton.whenPressed(new OpenCube());
		
		 
		searchCubeButton = new JoystickButton(rightStick, 4);    //right stick   trigger
		searchCubeButton.whenReleased(new CubeAquire());
		searchCubeButton.whileHeld(new CubeAquireClosed());

		spitCubeButton = new JoystickButton(rightStick, 3);  //button
		spitCubeButton.whenPressed(new SpittingCube());

	/*	turn90 = new JoystickButton(leftStick,5 );
		turn90.whenPressed(new MoveWrist(90));

		turnother90 = new JoystickButton(leftStick,6 );
		turnother90.whenPressed(new MoveWrist(-90));
*/
		//spitCubeButton.whenReleased(new DrivingMode());

		/*
		searchForCube = new JoystickButton(switches, 9);
		searchForCube.whenPressed(new SearchCube());
		 */

		wristextButton = new JoystickButton(switches, 1);
		wristextButton.whenPressed(new ExtendWrist());
		
		wristretButton = new JoystickButton(switches, 2);
		wristretButton.whenPressed(new RetractWrist());

		/*	hangingButton = new JoystickButton(rightStick, 6);
		hangingButton.whenPressed(new startClimbing());
		hangingButton.whenReleased(new stopClimbing());
		 */
		liftButtonFence = new JoystickButton(switches, 3);
		//liftButtonFence.whenPressed(new MoveLift(RobotMap.FENCEHEIGHT));

		//liftButtonFloor = new JoystickButton(switches, 3);
		//liftButtonFloor.whenPressed(new MoveLift(RobotMap.FLOORHEIGHT));

		liftButtonLowScale = new JoystickButton(switches, 4);
		//liftButtonLowScale.whenPressed(new MoveLift(RobotMap.HIGHSCALEHEIGHT));

		liftButtonHighScale = new JoystickButton(switches, 5);
		//liftButtonHighScale.whenPressed(new Hangmode());

		climbButton = new JoystickButton(switches, 6);
		climbButton.whenPressed(new  startClimbing());
		//climbButton.whenPressed(new RetractWrist());
		climbButton.whenReleased(new stopClimbing());
		
		


		//driveTest = new JoystickButton(switches, 9);     //change number
		//driveTest.whenPressed(new TestDrive(distance1, speed1));
		//driveTest.whenReleased(new TestDrive(distance2, speed2));

		//Jake: extend/retract +setpontrs on elevator, climbing
		//Sarah: high low on diffferent switches, suck/spit on right, 

		//this is for a commit
		// SmartDashboard Buttons
		//SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
		//SmartDashboard.putData("TankDrive", new TankDrive());
		//SmartDashboard.putData("StopDrive", new StopDrive());startClimbin
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
