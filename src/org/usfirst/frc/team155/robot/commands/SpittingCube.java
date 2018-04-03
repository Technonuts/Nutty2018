package org.usfirst.frc.team155.robot.commands;
 
import org.usfirst.frc.team155.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpittingCube extends Command {

    public SpittingCube() {
     requires(Robot.claw);
     
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.robotmap.clawMode = 1;
    	Robot.claw.closeGripper();
    	Robot.claw.spitCube();
    	
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
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
