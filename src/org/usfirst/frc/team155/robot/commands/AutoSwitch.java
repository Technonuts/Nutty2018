package org.usfirst.frc.team155.robot.commands;

import org.usfirst.frc.team155.robot.Robot;
import org.usfirst.frc.team155.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoSwitch extends CommandGroup {

private int angle;
private final double  SWITCHDISTANCE = 4.34; //82 inches distance to switch - distance of toPosition
//wall to middle of switch is 168. Robot length  = 40. to position  = 18


    public AutoSwitch( int side) {

    	//System.out.println("running auto switch ");
    	//
    	if(side==0) 
    		angle =90;
    	
    	if(side==2) 
    		angle=-90;
    	
    	addSequential(new MoveLift(RobotMap.FENCEHEIGHT));
    	addSequential(new DriveStraightDistance(SWITCHDISTANCE,.5)); 

    	addSequential(new ExtendWrist());
    	addSequential(new MoveWrist(angle));
    	//addSequential(new TurnDriveAngle(angle,.5));
    	//addSequential(new DriveStraightDistance(distance,.25));
    	addSequential(new SpittingCube());
    	//addSequential(new DriveStraightDistance(-1,.5));
   
    	//System.out.println("at auto switch ");
     
    }}
//