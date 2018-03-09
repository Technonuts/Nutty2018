package org.usfirst.frc.team155.robot.commands;

import org.usfirst.frc.team155.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GetCubeDumpSide extends CommandGroup {

	private int angle;
	private final double BOXDISTANCE = 1;
	//to middle of switch
	private int secondStraightDistance;
	private int driveToCube;
	private int speed;
	private int turnSpeed;

		
    public GetCubeDumpSide(int side) {
    	if(side==0) {
    		angle = 90;
    	}
    	else if(side==2) {
    		angle = -90;
    		
    	}
    	speed = 1;
    	addSequential(new DriveStraightDistance(BOXDISTANCE, speed));
    	addParallel(new CubeAquire());
    	addSequential(new OLDMoveWrist(angle));
    	addSequential(new SpittingCube());
    	//addSequential(new TurnDriveAngle(-angle, turnSpeed));
    	//addSequential(new DriveStraightDistance(secondStraightDistance, speed));
    	//add open gripper
    	//addSequential(new DriveStraightDistance(driveToCube, speed));
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
