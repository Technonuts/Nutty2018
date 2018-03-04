package org.usfirst.frc.team155.robot.commands;

import org.usfirst.frc.team155.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RetractWrist extends Command {

    public RetractWrist() {
    	
    	
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//if(Robot.claw.getArmPosition() > -5 && Robot.claw.getArmPosition() < 5)
    	Robot.claw.retractWrist();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.claw.retractWrist();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    
    		return true;
    	
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
