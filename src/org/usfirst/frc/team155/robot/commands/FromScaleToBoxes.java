package org.usfirst.frc.team155.robot.commands;

import org.usfirst.frc.team155.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FromScaleToBoxes extends CommandGroup {

    public FromScaleToBoxes(int position) {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	int angle;
    	boolean firstTurn = false;
    	if(position == 1) {
    		addSequential(new TurnRight());
    		firstTurn = true;
    	}
    	else
    		addSequential(new TurnLeft());
    	
    	addSequential(new DriveStraightDistance(5, .5));
    	
    	if(firstTurn == true)
    		addSequential(new TurnLeft());
    	else
    		addSequential(new TurnRight());
    	
    	addSequential(new MoveLift(Robot.elevator.FLOORHEIGHT));
    	//adjust lengths for drive distance
    }
}
