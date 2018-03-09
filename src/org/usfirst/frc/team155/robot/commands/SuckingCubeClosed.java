package org.usfirst.frc.team155.robot.commands;
  
import org.usfirst.frc.team155.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SuckingCubeClosed extends Command {
	
	private double startTime;

    public SuckingCubeClosed() {
    	requires(Robot.claw);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("SuckS");
    	Robot.claw.suckCube();
    	Robot.claw.closeGripper();
    	startTime = Timer.getFPGATimestamp();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {/*
    	
    	if (Robot.claw.readCubeSensor() < 12) //distance in inches
    		/*
    		if (Timer.getFPGATimestamp() >= startTime + 2) {
    			Robot.claw.closeGripper();
    			startTime = Timer.getFPGATimestamp();
    			}
    		else if (Timer.getFPGATimestamp() >= startTime + 1) {
    			Robot.claw.openGripper();
    			}
    		else {*///Robot.claw.closeGripper();
    			
    		//}
    	/*else if (Robot.claw.readCubeSensor() >= 24) {
    		Robot.claw.stopCube();
    		Robot.claw.openGripper();
    		
    		//System.out.println("suckCube2");	
    	}*/
    	//else { Robot.claw.suckCube();
    	//System.out.println("stopCube");
    	//	Robot.claw.openGripper();
    		//new SearchCube();
    		
    	//}
    	
    	Robot.claw.suckCube();
    	//System.out.println("stopCube");
    		Robot.claw.closeGripper();
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (Robot.claw.leftCubeSwitch() && Robot.claw.rightCubeSwitch()) {
    		Robot.claw.closeGripper();
    		return true;
    	}
    	else
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//System.out.println("SuckF");
    	//new HoldCube();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
