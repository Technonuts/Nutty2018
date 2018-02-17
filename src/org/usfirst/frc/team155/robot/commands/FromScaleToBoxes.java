package org.usfirst.frc.team155.robot.commands;

import org.usfirst.frc.team155.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FromScaleToBoxes extends CommandGroup {
	private final double BEYONDSCALEDISTANCE = 95.5/12 ;
    public FromScaleToBoxes(int position) {
    
    	
        // Add Commands here:private final
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
    	addSequential(new MoveWrist(0));
    	addSequential(new MoveLift(Robot.elevator.FLOORHEIGHT));
   // 	addSequential(new Turn180());
    	addSequential(new DriveStraightDistance(- BEYONDSCALEDISTANCE, .5));
    	
    	if(position == 0 )
    		addSequential(new TurnRight());
    	else
    		addSequential(new TurnLeft());
    	
    	//addSequential(new MoveLift(Robot.elevator.FLOORHEIGHT));
    	//adjust lengths for drive distance
    }
}
