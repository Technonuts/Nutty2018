package org.usfirst.frc.team155.robot.commands;

import org.usfirst.frc.team155.robot.Robot;

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
    	System.out.println("SeachS");
    	Robot.claw.openGripper();
    	//System.out.println("openGripper");
    	Robot.claw.suckCube();
    	//System.out.println("suckCube");	
    			
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.claw.readCubeSensor() <= 24) {
    		Robot.claw.suckCube();
    		//System.out.println("suckCube2");	
    	}
    	else Robot.claw.stopCube();
    	//System.out.println("stopCube");	
    }

    // Make this return true when this Command no longer needs to run execute( )
    protected boolean isFinished(  ) {
    	if (    Robot.claw.readCubeSensor() <= 12) {
    		return true;
    	}
   	else 
        return false;
    	
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("SeachF");
    	//Robot.claw.closeGripper();
    	//new SuckingCube();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
