package org.usfirst.frc.team155.robot.commands;

import org.usfirst.frc.team155.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FromSwitchToBoxes extends CommandGroup {
private final double BEYONDSWITCHDISTANCE= 34/12;
    public FromSwitchToBoxes(int position) {
       
    	int angle;
    	boolean firstTurn = false;
    	addSequential(new MoveWrist(0));
    	
    	addSequential(new DriveStraightDistance(BEYONDSWITCHDISTANCE , .5));
    
    	if(position == 2)
    		addSequential(new TurnLeft());
    	else if(position==0)
    		addSequential(new TurnRight());
    	
    	addSequential(new MoveLift(Robot.elevator.FLOORHEIGHT));
    	//adjust lengths for drive distance
    }
}
