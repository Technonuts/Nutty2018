package org.usfirst.frc.team155.robot.commands;

import org.usfirst.frc.team155.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualLift extends Command {

    public ManualLift() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	new MoveLift(Robot.elevator.sliderValue(Robot.oi.switches));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	  return Robot.elevator.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.holdLift();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
