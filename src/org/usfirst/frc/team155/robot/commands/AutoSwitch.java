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
    	addSequential(new MoveLift(Robot.elevator.FENCEHEIGHT));
    	addSequential(new DriveStraightDistance(firstDistance,.5));
    	addSequential(new ExtendWrist());
    	addSequential(new MoveWrist(angle));
    	//addSequential(new TurnDriveAngle(angle,.5));
    	//addSequential(new DriveStraightDistance(distance,.25));
    	addSequential(new SpittingCube());
    	//addSequential(new DriveStraightDistance(-1,.5));
   
    	System.out.println("at auto switch ");
     
    }}
//