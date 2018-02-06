package org.usfirst.frc.team155.robot.commands;

import org.usfirst.frc.team155.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CubeAquire extends CommandGroup {

    public CubeAquire() {
    	addSequential(new SearchCube());
    	addSequential(new SuckingCube());
    	addSequential(new HoldCube());
    	addParallel(new MoveLift(Robot.elevator.FENCEHEIGHT));
    			
    }
}
