package org.usfirst.frc.team155.robot.commands;

import org.usfirst.frc.team155.robot.Robot;
import org.usfirst.frc.team155.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class startClimbing extends Command {

	public startClimbing() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.elevator);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.robotmap.clawMode = 9;
		RobotMap.elevatorLeftHanger.setSpeed(-1);
		RobotMap.elevatorRightHanger.setSpeed(-1);
		Robot.led.LEDhanger(1);

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
			return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		RobotMap.elevatorLeftHanger.setSpeed(0);
		RobotMap.elevatorRightHanger.setSpeed(0);
		Robot.led.LEDhanger(1);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		RobotMap.elevatorLeftHanger.setSpeed(0);
		RobotMap.elevatorRightHanger.setSpeed(0);
		Robot.led.LEDhanger(1);
	}
}
