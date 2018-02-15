package org.usfirst.frc.team155.robot.commands;

import org.usfirst.frc.team155.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoScale extends CommandGroup {
private double Longdistance = 3;
private double Shortdistance =1;

private int angle;

    public AutoScale( int side) {
    	System.out.println("running autoscale ");
    	if(side==1) {
    		angle =90;
    	}
    	else {
    		angle=-90;
    	}
    	addSequential(new DriveStraightDistance(Longdistance,.5));
    	addParallel(new MoveLift(Robot.elevator.HIGHSCALEHEIGHT));
    	addSequential(new ExtendWrist());
    	addSequential(new MoveWrist(angle));
    	
    	addSequential(new SpittingCube());
    	//addSequential(new TurnDriveAngle(angle,.5));
    	//addSequential(new DriveStraightDistance(Shortdistance,.5));
    	//addSequential(new SpittingCube()); 
    	//addSequential(new DriveStraightDistance(-1,.5));
    	System.out.println("at autoscale ");
    
    }
}
