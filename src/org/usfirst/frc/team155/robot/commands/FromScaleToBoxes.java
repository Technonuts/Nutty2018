package org.usfirst.frc.team155.robot.commands;

import org.usfirst.frc.team155.robot.Robot;
import org.usfirst.frc.team155.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FromScaleToBoxes extends CommandGroup {
	private final double BEYONDSCALEDISTANCE = 3.12 ; //95.9in
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
    	
    	if(position == 0 ) {
    		addSequential(new TurnRight());
    	angle = -90;
    	}
    	else {
    		addSequential(new TurnLeft());
    	angle = 90;
    	}
    	
    	boolean firstTurn = false;
    //	addSequential(new MoveWrist(0));
    	addSequential(new TurnDriveAngle(angle, .5));
    	addSequential(new MoveLift(RobotMap.FLOORHEIGHT));
   // 	addSequential(new Turn180());
    	addSequential(new DriveStraightDistance(- BEYONDSCALEDISTANCE, .5));
    	
    	
    	
    	//addSequential(new MoveLift(Robot.elevator.FLOORHEIGHT));
    	//adjust lengths for drive distance
    }
}
