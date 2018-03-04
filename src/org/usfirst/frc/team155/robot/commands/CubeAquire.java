package org.usfirst.frc.team155.robot.commands;

import org.usfirst.frc.team155.robot.Robot;
import org.usfirst.frc.team155.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CubeAquire extends CommandGroup {

    public CubeAquire() {
    	//addSequential(new SearchCube());
    	addSequential(new SuckingCube());
    	addSequential(new HoldCube());
    	//addSequential(new MoveLift(RobotMap.FENCEHEIGHT));
    			
    }
}
