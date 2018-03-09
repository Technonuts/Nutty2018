package org.usfirst.frc.team155.robot.commands;

import org.usfirst.frc.team155.robot.Robot;
import org.usfirst.frc.team155.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FromSwitchToBoxes extends CommandGroup {
private final double BEYONDSWITCHDISTANCE= 68/12;
//mid switch to edge switch = 28. robot length = 40
    public FromSwitchToBoxes(int side) {
       
    	int angle;
    	boolean firstTurn = false;
    	
    	addSequential(new OLDMoveWrist(0));
    	
    	addSequential(new DriveStraightDistance(BEYONDSWITCHDISTANCE , .5));
    
    	if(side == 2)
    		addSequential(new TurnLeft());
    	else if(side==0)
    		addSequential(new TurnRight());
    	
    	addSequential(new MoveLift(RobotMap.FLOORHEIGHT));
    	//adjust lengths for drive distance
    }
}
