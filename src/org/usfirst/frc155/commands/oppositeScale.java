package org.usfirst.frc155.commands;

import org.usfirst.frc155.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class oppositeScale extends CommandGroup {
	private int angle;
	private double distance;
	private double shortDistance = 6;
	private double longDistance = 8;
	private double firstDistance = 10;
	private double secondDistance;
	private double thirdDistance;
	
	public oppositeScale(int position, int side) {
		if(position == 1 )
    		distance = shortDistance;
    	else distance = longDistance;
    	if(side==1) {
    		angle =-90;
    	}
    	else {
    		angle= 90;
    	}
    
		addSequential(new DriveStraightDistance(firstDistance,.25));
		addSequential(new TurnDriveAngle(angle,.5));
		addSequential(new DriveStraightDistance(distance ,.25));
		addSequential(new TurnDriveAngle(-angle,.5));
		
		addParallel(new  MoveLift(Robot.elevator.HIGHSCALEHEIGHT));
		addSequential(new DriveStraightDistance(1,.25));
		addSequential(new TurnDriveAngle(-angle,.5));
		addSequential(new DriveStraightDistance(1,.25));
		//open claw
		addSequential(new DriveStraightDistance(-1,.25));
		//close claw
		
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
	}
}
