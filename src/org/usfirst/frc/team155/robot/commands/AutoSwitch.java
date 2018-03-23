package org.usfirst.frc.team155.robot.commands;

import org.usfirst.frc.team155.robot.Robot;
import org.usfirst.frc.team155.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoSwitch extends CommandGroup {

private int angle;


    public AutoSwitch( int side, double distance) {

    	//System.out.println("running auto switch ");
    	//
    	if(side==0) 
    		angle =90;
    	
    	if(side==2) 
    		angle=-90;
    	
    	
    	addSequential(new DriveStraightDistance(distance,.15)); 

    
    	//addSequential(new MoveWrist(angle));
    	addSequential(new TurnDriveAngle(angle,.75));
    	//addSequential(new MoveLift(RobotMap.FENCEHEIGHT));
    	addSequential(new DriveStraightDistance(1.5,.25));
    	//addSequential(new ExtendWrist());
    	addSequential(new SpittingCube());
    	addSequential(new RetractWrist());
    	//addSequential(new DriveStraightDistance(-1,.5));
   
    	//System.out.println("at auto switch ");
     
    }}
//