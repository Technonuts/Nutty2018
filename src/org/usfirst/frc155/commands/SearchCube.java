package org.usfirst.frc155.commands;

import org.usfirst.frc155.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SearchCube extends Command {

    public SearchCube() {
    	requires(Robot.claw);
       
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.claw.openGripper();
    	Robot.claw.suckCube();
    		
    			
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (Robot.claw.leftCubeSwitch() && Robot.claw.rightCubeSwitch())
    		return true;
    	else
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
