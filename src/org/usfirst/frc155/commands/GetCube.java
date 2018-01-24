package org.usfirst.frc155.commands;

import org.usfirst.frc155.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GetCube extends CommandGroup {

	private int angle;
	private int firstStraightDistance;
	private int secondStraightDistance;
	private int driveToCube;
	private int speed;
	private int turnSpeed;

	
	
	
	
	
	
	
	
    public GetCube(int robotPosition) {
    	if(robotPosition==1) {
    		angle = 90;
    	}
    	else {
    		angle = -90;
    		
    	}
    	
    	addSequential(new DriveStraightDistance(firstStraightDistance, speed));
    	addSequential(new TurnDriveAngle(-angle, turnSpeed));
    	addSequential(new DriveStraightDistance(secondStraightDistance, speed));
    	//add open gripper
    	addSequential(new DriveStraightDistance(driveToCube, speed));
    	//add close gripper
    	//speeds have to be adjusted
    	
    
    	
   
    	
    	
    	
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
