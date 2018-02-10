package org.usfirst.frc.team155.robot.commands;

import org.usfirst.frc.team155.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoSwitch extends CommandGroup {
private double distance;
private double shortDistance = 2;
private double longDistance = 3;
private int angle;
private double firstDistance;


    public AutoSwitch( int side) {

    	System.out.println("running auto switch ");
    	if(side==1) {
    		angle =90;
    	}
    	else {
    		angle=-90;
    	}
    	addSequential(new DriveStraightDistance(firstDistance,.5));
    	addParallel(new MoveLift(Robot.elevator.HIGHSCALEHEIGHT));
    	addSequential(new TurnDriveAngle(angle,.5));
    	addSequential(new DriveStraightDistance(distance,.25));
    	//Add sequential "release" code 
    	addSequential(new DriveStraightDistance(-1,.5));
   
    	System.out.println("at auto switch ");
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
