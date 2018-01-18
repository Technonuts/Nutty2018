package org.usfirst.frc155.commands;

import org.usfirst.frc155.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoScaleLeft extends CommandGroup {
private double distance;
private double shortDistance = 2;
private double longDistance = 3;

    public AutoScaleLeft(int position) {
    	if(position == 1 )
    		distance = shortDistance;
    	else distance = longDistance;
    	addSequential(new DriveStraightDistance(10,.5));
    	addParallel(new MoveLift(Robot.elevator.HIGHSCALEHEIGHT));
    	addSequential(new TurnDriveAngle(90,.5));
    	addSequential(new DriveStraightDistance(distance,.25));
    	//Add sequential "release" code 
    	addSequential(new DriveStraightDistance(-1,.5));
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
