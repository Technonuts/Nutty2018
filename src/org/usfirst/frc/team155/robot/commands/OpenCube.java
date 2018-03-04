package org.usfirst.frc.team155.robot.commands;

import org.usfirst.frc.team155.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OpenCube extends Command {

	private double startTime;
	
    public OpenCube() {
      requires(Robot.claw);
    } 

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("HoldS");
    	Robot.claw.openGripper();
    	Robot.claw.stopCube();
    	startTime = Timer.getFPGATimestamp();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (Timer.getFPGATimestamp() >= startTime + 0.5)
    		return true;
    	else
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("HoldF");
    	//new MoveLift(Robot.elevator.FENCEHEIGHT);
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
