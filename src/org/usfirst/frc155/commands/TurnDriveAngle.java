package org.usfirst.frc155.commands;

import org.usfirst.frc155.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnDriveAngle extends Command {
	
	
		
		private static final double kTolerance = 2;
		private static final double kP = -1.0 / 5.0;
		
		private static final double kPAng = -1.0 / 5.0;
		
		private double m_heading;
		private double m_drift;
		private double m_angle;
		private double m_turnSpeed;
		
		private double m_turnrate;
    public TurnDriveAngle(double angle, double maxTurn) {
    	m_angle = angle;
    	m_turnSpeed = maxTurn;
    	requires(Robot.drivetrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	m_heading = Robot.drivetrain.getGyro();
    	setTimeout(2);
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	m_drift = m_heading - Robot.drivetrain.getGyro();
    	if (m_turnSpeed * kPAng * m_drift >= m_turnSpeed) {
    		m_turnrate = m_turnSpeed;
    	}
    	    			
    	else {
    		m_turnrate = m_turnSpeed * kPAng * m_drift;		
    	}
    	
    	Robot.drivetrain.arcDrive(0, m_turnrate);
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Math.abs(m_drift) <= kTolerance || isTimedOut();
       
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
