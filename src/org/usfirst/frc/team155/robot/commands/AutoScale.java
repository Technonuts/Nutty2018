package org.usfirst.frc.team155.robot.commands;

import org.usfirst.frc.team155.robot.Robot;
import org.usfirst.frc.team155.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoScale extends CommandGroup {
private double SCALEDISTANCE = (266)/12;
//324 to senter of scale - 18 inches traveled, - robot length(40)

private int angle;

    public AutoScale( int side) {
    	System.out.println("running autoscale ");
    	if(side==0) {
    		angle = 90;
    	}
    	else if(side==2) {
    		angle= -90;
    	}
    	addSequential(new DriveStraightDistance(SCALEDISTANCE,.5));
    	addSequential(new MoveLift(RobotMap.HIGHSCALEHEIGHT));
    	addSequential(new ExtendWrist());
    	addSequential(new MoveWrist(angle));
    	
    	addSequential(new SpittingCube());
    	//addSequential(new TurnDriveAngle(angle,.5));
    	//addSequential(new DriveStraightDistance(Shortdistance,.5));
    	//addSequential(new SpittingCube()); 
    	//addSequential(new DriveStraightDistance(-1,.5));
    //	System.out.println("at autoscale ");
    
    }
}
