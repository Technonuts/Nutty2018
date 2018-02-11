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

import org.usfirst.frc.team155.robot.RobotMap;
import org.usfirst.frc.team155.robot.commands.AutoScale;
import org.usfirst.frc.team155.robot.commands.AutoSwitch;
import org.usfirst.frc.team155.robot.commands.Autonomous;
import org.usfirst.frc.team155.robot.commands.DriveStraightDistance;
import org.usfirst.frc.team155.robot.commands.FromScaleToBoxes;
import org.usfirst.frc.team155.robot.commands.FromSwitchToBoxes;
import org.usfirst.frc.team155.robot.commands.GetCube;
import org.usfirst.frc.team155.robot.commands.PriorityScale;
import org.usfirst.frc.team155.robot.commands.PriorityScaleSwitch;
import org.usfirst.frc.team155.robot.commands.PrioritySwitch;
import org.usfirst.frc.team155.robot.commands.PrioritySwitchScale;
import org.usfirst.frc.team155.robot.commands.ToOtherSide;
import org.usfirst.frc.team155.robot.commands.ToPosition;
import org.usfirst.frc.team155.robot.commands.readForDelay;
import org.usfirst.frc.team155.robot.subsystems.Claw;
import org.usfirst.frc.team155.robot.subsystems.Drivetrain;
import org.usfirst.frc.team155.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
 
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in 
 * the project.
 */
public class Robot extends TimedRobot {

	//  Command autonomousCommand;
	//SendableChooser<Command> chooser = new SendableChooser<>();
	Command autonomousCommand;
	Command m_autonomousCommand;
	SendableChooser autoChooser;
	SendableChooser sideChooser;
	SendableChooser delayChooser;
	public int side;
	private int switchValue;
	private int scaleValue;
	private int leftValue = 0;
	private int centerValue = 1;
	private int rightValue = 2;
	private int scaleMode = 0;
	private int switchMode = 1;
	private int megaMode = 2;
	private int twoScaleMode = 3;
	private int twoSwitchMode = 4;
	private int switchScaleMode = 5;
	private int scaleSwitchMode = 6;
	private int mode;
	private int position;




	public static OI oi;
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public static Drivetrain drivetrain;
	public static Claw claw;
	public static Elevator elevator;
	public static RobotMap robotmap;
	
	private double autoDelay;

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		robotmap = new RobotMap();
		robotmap.init();
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		drivetrain = new Drivetrain();
		SmartDashboard.putData(drivetrain);
		claw = new Claw();
		elevator = new Elevator();
		SmartDashboard.putData(elevator);
		

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		// OI must be constructed after subsystems. If the OI creates Commands
		//(which it very likely will), subsystems are not guaranteed to be
		// constructed yet. Thus, their requires() statements may grab null
		// pointers. Bad news. Don't move it.
		oi = new OI();

		// Add commands to Autonomous Sendable Chooser
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS


		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS


		autoChooser = new SendableChooser();
		autoChooser.addDefault("Scale", scaleMode);
		autoChooser.addObject("Switch", switchMode);
		autoChooser.addObject("Mega Scale", megaMode);
		autoChooser.addObject("Priority 2 Scales", twoScaleMode);
		autoChooser.addObject("Priority 2 Switches", twoSwitchMode);
		autoChooser.addObject("Priority Switch Scale", switchScaleMode);
		autoChooser.addObject("Priority Scale Switch", scaleSwitchMode);





		sideChooser = new SendableChooser();
		sideChooser.addDefault("Left", leftValue);
		sideChooser.addObject("Center", centerValue);
		sideChooser.addObject("Right", rightValue);
		sideChooser.addObject("Left Wall", 3);
		sideChooser.addObject("Right Wall", 4);
		SmartDashboard.putData("side Chooser", sideChooser);

		delayChooser = new SendableChooser();
		delayChooser.addDefault("No Delay", 0);
		delayChooser.addObject("0.1 Seconds", 0.1);
		delayChooser.addObject("0.25 Seconds", 0.25);
		delayChooser.addObject("0.5 Seconds", 0.5);
		delayChooser.addObject("1 Seconds", 1);
		SmartDashboard.putData("Auto Delay", delayChooser);

		SmartDashboard.putData("Auto mode", autoChooser);
				

	}

	/**
	 * This function is called when the disabled button is hit.
	 * You can use it to reset subsystems before shutting down.
	 */
	@Override
	public void disabledInit(){
		//test
		//making another test
	}

	@Override
	public void disabledPeriodic() {
	//	Scheduler.getInstance().run();
	}


	@Override
	public void autonomousInit() {
		
		Robot.drivetrain.resetGyro();
		
		
		//char ourSwitch, scale, theirSwitch;
		//autonomousCommand = chooser.getSelected();
		side = (int)sideChooser.getSelected();
		mode = (int)autoChooser.getSelected();
		if(side>=4) {
			position = 1;
		}
		else {
			position =0;
		}
		
		autoDelay = (int) delayChooser.getSelected();
		
		// schedule the autonomous command (example)
		//if (autonomousCommand != null) autonomousCommand.start();
		

		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData.length() > 0) {
		if(gameData.charAt(0) == 'L')
		{
			//ourSwitch = 'L';
			//Put left auto code here
			switchValue = leftValue;


			//Our switch left
		} else {
			//Put right auto code here
			//Our switch right
			//ourSwitch = 'R';
			switchValue = rightValue;
		}

		if(gameData.charAt(1) == 'L')
		{
			//Put left auto code here
			//Our scale left
			//scale = 'L';
			scaleValue = leftValue;

		} else {
			//Put right auto code here
			//Our scale right
			//scale = 'R';
			scaleValue = rightValue;

		}
		}
		//SmartDashboard.putString("Switch side", Character.toString(ourSwitch ));
		//SmartDashboard.putString("Scale side", Character.toString(scale ));

		/*	
		if(gameData.charAt(2) == 'L')
		{
			//Put left auto code here
			//Other team switch left
			theirSwitch = 'L';
		} else {
			//Put right auto code here
			//Other team switch right
			theirSwitch = 'R';
		} */
		m_autonomousCommand = (Command) new Autonomous( mode, side, autoDelay, scaleValue, switchValue, position);

		m_autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		//System.out.println("Here1");
		Scheduler.getInstance().run();
		
	}

	@Override
	public void teleopInit() {
		Robot.drivetrain.resetGyro();
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null) autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
        elevator.resetLow();
		SmartDashboard.putNumber("Lift distance", elevator.getLiftEncoder().getDistance());
		SmartDashboard.putNumber("cube distance", claw.cubeDistance);
	}
}
