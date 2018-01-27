package org.usfirst.frc155.commands;

import org.usfirst.frc155.Robot;
import org.usfirst.frc155.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class checkForRobot extends Command {

	private static double distance;
	private static double number;
	private static double distTraveledLeft;
	private static double distTraveledRight;
	private static double avgDist;

	public checkForRobot() {
		requires(Robot.drivetrain);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		distance= Robot.drivetrain.getRangeFinder();
		distTraveledLeft = Robot.drivetrain.getLeftEncoder().getDistance();
		distTraveledRight = Robot.drivetrain.getRightEncoder().getDistance();
		
		if(distance == number) {
			avgDist =((distTraveledLeft+distTraveledRight)/2);
		}	
	}
	
	public static double toClose() {
		return distance;
	}
	
	public static double averageDistance() {
		return avgDist;
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
