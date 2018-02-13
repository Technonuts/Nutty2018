package org.usfirst.frc.team155.robot.commands;

import org.usfirst.frc.team155.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnDriveAngle extends Command {

	private static final double kTolerance = 5;
	private static final double kP = -1.0 / 5.0;

	private static final double kPAng = -.1; // 5.0;

	private double m_heading;
	private double m_drift;
	private double m_angle;
	private double m_turnSpeed;
	private double sample1;
	private double sample2;
	private double count = 0;

	private double min = 0;
	private double max = 0;
	private double t_max = 0;
	private double t_min = 0;
	private double error = 0;
	private boolean done=false;
	
	private boolean starttime=false;
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
		System.out.println("Hereint");
		m_heading = Robot.drivetrain.getGyro();
		// setTimeout(2);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
    	//System.out.println("Hereext");
    	m_heading = Robot.drivetrain.getGyro();
    	//System.out.println("Sample 1:"  + sample1 );
    	//System.out.println("Sample 2:"  + sample2 );
    	//System.out.println("Heading:"  + m_heading );
    	//System.out.println("Count:"  + count );
    	
     	error = m_angle - m_heading;

    			
    		
    	/*if (count ==0) {
    		sample1 =m_heading;
    		
    	}
    	else if (count ==100){
    		sample2 =m_heading;
    		count = 0;
    	}
    	else if (count == 200)
    		count=-1;
    	count++;
    	*/
    	
    	
    	
    	
    	/*
    	m_drift = m_angle - Robot.drivetrain.getGyro();
    	if (m_turnSpeed * kPAng * m_drift >= m_turnSpeed) {
    		m_turnrate = m_turnSpeed;
    	}
    	    			
    	else {
    		m_turnrate = m_turnSpeed * kPAng * m_drift;		
    	}
    	*/
    	
    	m_drift = m_angle - Robot.drivetrain.getGyro();
		m_turnrate = m_turnSpeed * kPAng * m_drift;	
		
		if ( m_turnrate> m_turnSpeed)
			m_turnrate=m_turnSpeed;
		
		if ( m_turnrate< -m_turnSpeed)
			m_turnrate=-m_turnSpeed;
    	
    	Robot.drivetrain.arcDrive(0, -m_turnrate);
    	
    	if(Math.abs(m_drift) <= kTolerance) {
    		starttime=true;
    	}
    			
    	if (starttime) {
    		 setTimeout(1.5);
    		 starttime=false;
    	}
    }

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		//System.out.println("Here fin");
		
/*
		
		if (error > t_max) {
			t_max = error;
			
		}
		if (error<kTolerance) {
			max = t_max;
		}
			
		if (error < t_min) {
			t_min= error;
			
		}
		if (error>-kTolerance) {
			min = t_min;
		}
		
		System.out.println("error "+ error + "  t_min " + t_min + "  min " + min+ "  t_max " + t_max + "  max " + max);

		if (  max != 0 && min !=0){
			System.out.println("testing...");
			if (Math.abs(max - min) < kTolerance )
				done=true;
			else {
				System.out.println("reseting...");
					//t_min=0;
					//t_max=0;
					//max=0;
					//min=0;
			}
		}
		
		return done;
		*/
/*
		if ((sample1 <= m_angle + kTolerance) && (sample1 >= m_angle - kTolerance) && (sample2 <= m_angle + kTolerance)
				&& (sample2 >= m_angle - kTolerance)) {
			return true;
		} else
			return false;
*/
		 return Math.abs(m_drift) <= kTolerance && isTimedOut();

	}

	// Called once after isFinished returns true
	protected void end() {
		System.out.println("Hereend");
		Robot.drivetrain.resetEncoder();
		Robot.drivetrain.stop();
		Timer.delay(.1);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
