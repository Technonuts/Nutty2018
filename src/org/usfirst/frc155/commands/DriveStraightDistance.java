// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc155.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc155.Robot;

/**
 *
 */
public class DriveStraightDistance extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
   
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
	
	 private double m_distance;
    private double m_driveForwardSpeed;
	private double m_error;
	private static final double kTolerance = 0.1;
	private static final double kP = -1.0 / 5.0;
	
	private static final double kPAng = -1.0 / 5.0;
	
	private double m_heading;
	private double m_drift;
	private double	 maxTurn = .25;
	
	private double m_speed;
	private double m_turnrate;
 

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public DriveStraightDistance(double distance, double maxSpeed) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    	 m_distance = distance;
        m_driveForwardSpeed = maxSpeed;
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
       

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.drivetrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	Robot.drivetrain.getLeftEncoder().reset();
    	Robot.drivetrain.getRightEncoder().reset();
    	m_heading = Robot.drivetrain.getGyro();
		setTimeout(2);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	m_error = m_distance - Robot.drivetrain.getRightEncoder().getDistance();
    
		if (m_driveForwardSpeed * kP * m_error >= m_driveForwardSpeed) {
			m_speed = m_driveForwardSpeed;
		}
				
		else {
			m_speed = m_driveForwardSpeed * kP * m_error;
		}
    	
    	m_drift = m_heading - Robot.drivetrain.getGyro();
    	if (maxTurn * kPAng * m_drift >= maxTurn) {
    		m_turnrate = maxTurn;
    	}
    	    			
    	else {
    		m_turnrate = maxTurn * kPAng * m_drift;		
    	}
    	
    	Robot.drivetrain.arcDrive(m_speed, m_turnrate);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
    	return Math.abs(m_error) <= kTolerance || isTimedOut();
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}