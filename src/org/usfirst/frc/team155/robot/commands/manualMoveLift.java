package org.usfirst.frc.team155.robot.commands;

import org.usfirst.frc.team155.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class manualMoveLift extends Command {

    public manualMoveLift() {
        // Use requires() here to declare subsystem dependencies
         requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevator.manualLift(Robot.oi.switches);  
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(!Robot.elevator.getHighLimit()&& Robot.oi.switches.getAxis(Joystick.AxisType.kY)>0) {
    		return true;
    	}
    	else if(Robot.elevator.getLowLimit()&& Robot.oi.switches.getAxis(Joystick.AxisType.kY)<0 ) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.holdLift();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.elevator.holdLift();
    }
}
