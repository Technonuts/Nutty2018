package org.usfirst.frc.team155.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ToPosition extends CommandGroup {

	public double dist =1.5;
	
	
    public ToPosition() {
    	 	
    	System.out.println("ENter to position");
      	addSequential(new DriveStraightDistance(dist,.25));
      	System.out.println("out of toposition ");
      
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
