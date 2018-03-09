package org.usfirst.frc.team155.robot.commands;

import org.usfirst.frc.team155.robot.Robot;
import org.usfirst.frc.team155.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CubeAquireClosed extends CommandGroup {

    public CubeAquireClosed() {
    	//addSequential(new SearchCube());
    	addSequential(new SuckingCubeClosed());
    	addSequential(new HoldCube());
    	//addSequential(new MoveLift(RobotMap.FENCEHEIGHT));
    			
    }
}
