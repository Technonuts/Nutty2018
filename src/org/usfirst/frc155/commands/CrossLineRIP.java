package org.usfirst.frc155.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CrossLineRIP extends CommandGroup {
int angle, distance;
    public CrossLineRIP(int side) {
    	if(side==1) {
    		angle =-90;
    	}
    	else {
    		angle=90;
    	}   	
    	
    	addSequential(new TurnDriveAngle(angle,.5));
    	addSequential(new DriveStraightDistance(distance,.5));
    	
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
