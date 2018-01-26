package org.usfirst.frc155.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class readForDelay extends Command {
	Timer timer = new Timer();
	double startTime;
	boolean done = false;
	double delayLength;
	
    public readForDelay(double tdelayLength) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	delayLength = tdelayLength;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startTime = timer.getFPGATimestamp();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	new StopDrive();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(delayLength<=timer.getFPGATimestamp()-startTime)
    		done = true;
    	return done;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
