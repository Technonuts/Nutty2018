package org.usfirst.frc.team155.robot.commands;

import org.usfirst.frc.team155.robot.Robot;
import org.usfirst.frc.team155.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous extends CommandGroup {

	private int leftValue = 0;
	private int centerValue = 1;
	private int rightValue = 2;
	private int scaleMode = 0;
	private int switchMode = 1;
	private int megaMode = 2;
	private int twoScaleMode = 3;
	private int twoSwitchMode = 4;
	private int switchScaleMode = 5;
	private int scaleSwitchMode = 6;
	private double angle=0;
	
	
	
	//	/1 vtick == 18.9in
		//	.64 ticks == 12 in
	private final double BEYONDBOX = 6.4;  // 120 in
	//switch width = 12ft
	private final double SCALEDIST = 14.3; //270in
	//distance to middle of switch - 18(toposition) - robot(40)
	private final double BETWEENDIST = 11.1;   //210
	//halfway between scale and switch
	private final double BACKTOSWITCH = .64; // 12 in
	private final double SWITCHDIST = 5.31;  //100
	///140 to switch - length of robot (40) 
	private final double PILEDIST = 2.25; // 48 in
	private final double OTHERSWITCH = 5.7;  //108 in
//	distance from midpoint to midpoint of switch plates
	
	public Autonomous(int mode, int side, double autoDelay, int scaleValue, int switchValue) {
		// System.out.println("Here2");
		// position 0 = left, 1 = center, 2=right
		if (side == 0) {
			angle = 90;
		}
		if (side == 2) {
			angle = -90;
		}
		// addSequential(new DriveStraightDistance(3,.4));
		// addSequential(new TurnDriveAngle(180,.5)); // actual angle = 180
		// addSequential(new DriveStraightDistance(3,.4));

		addSequential(new readForDelay(autoDelay)); // findSpot
		// if the robot is on the left or on the right
		if (side == 0 || side == 2) {
			// System.out.println("Mode=Edge Mode");
			// this checks whether or not the switch is on the same side as our robot
			if (switchValue == side) {
				// System.out.println("Scale Side = our side");
				// run switch command
				addSequential(new ToPosition());
				// System.out.println("toposition");
				addSequential(new AutoSwitch(side));
				// System.out.println("autoscale");
				// do we want to get another cube
				if (mode == 1) {
					addSequential(new FromSwitchToBoxes(side));
					addSequential(new GetCubeDumpSide(side));

				}
			}

			
			
			//pall elev to seq ///////////////////////////////////////////////////////////////////////////////////////////////////////
			
			
			else if (scaleValue == side) {
				// System.out.println("MSwitch side = our side");
				// run switch command
				addSequential(new ToPosition());
				// System.out.println("toPosition");
				addSequential(new AutoScale(side));
				// System.out.println("autoswitch");
			} else {
				// System.out.println("Switch and scale side = not our side");
				// cross line
				addSequential(new DriveStraightDistance(BETWEENDIST, 0.5));
				addSequential(new TurnDriveAngle(angle, .5));
				addSequential(new DriveStraightDistance(BEYONDBOX, 0.5));
				addSequential (new MoveLift(RobotMap.FENCEHEIGHT));
				addSequential(new TurnDriveAngle(angle + angle, .5));
				addSequential(new DriveStraightDistance(BACKTOSWITCH, 0.5));
				addParallel(new ExtendWrist());
				addSequential(new SpittingCube());

			}

		} else {
			//System.out.println("Mode=Switch Mode");
			// robot is in the center and switch is on our side
			if (switchValue == side) {
				//System.out.println("Switch our side");
				// run switch command
				addSequential(new DriveStraightDistance(SWITCHDIST, .5));
				addSequential(new MoveLift(RobotMap.FENCEHEIGHT));
				addSequential(new ExtendWrist());
				addSequential(new SpittingCube());
// get another cube
				if (mode == 1) {
					addSequential(new DriveStraightDistance(-1, .5));
					addSequential(new TurnDriveAngle(-90, .5));
					addSequential(new DriveStraightDistance(PILEDIST, .5));
					addParallel(new CubeAquire());
					addSequential(new DriveStraightDistance(-PILEDIST, .5));
					addSequential(new TurnDriveAngle(0, .5));
					addSequential(new DriveStraightDistance(1, .5));
					addSequential(new SpittingCube());

				}

			} else {
				//System.out.println("switch other side");
				// run other switch command
				addSequential(new ToPosition());
				addSequential(new TurnDriveAngle(-90, .5));
				addSequential(new DriveStraightDistance(OTHERSWITCH, .5));
				addSequential(new MoveLift(RobotMap.FENCEHEIGHT));
				addSequential(new TurnDriveAngle(0, .5));
				addSequential(new DriveStraightDistance((SWITCHDIST - 1.5), .5));
				
				addSequential(new ExtendWrist());
				addSequential(new SpittingCube());

				// new oppositeSwitch(position, side);
			}

		}
		/*
		 * else if (mode == megaMode) { System.out.println("Mode=mega mode"); //this is
		 * to try and get the sca'e on the opposite side if it's not on our side
		 * if(scaleValue==side) { System.out.println("mega Scale our side "); //run
		 * scale command addSequential(new ToPosition()); addSequential(new
		 * AutoScale(side)); } else { //go to other side of scale
		 * System.out.println("mega Scale other side "); addSequential(new
		 * ToPosition()); addSequential(new ToOtherSide ( side , position));
		 * addSequential(new AutoScale(side));
		 * 
		 * } }
		 * 
		 * else if (mode == twoScaleMode) { System.out.println("mode = 2 scale "); //run
		 * 2 scale addSequential(new PriorityScale( side, scaleValue, switchValue,
		 * position )); }
		 * 
		 * else if (mode == twoSwitchMode) { System.out.println("mode = 2 switch ");
		 * //run 2 switch addSequential(new PrioritySwitch( side, scaleValue,
		 * switchValue, position )); }
		 * 
		 * else if (mode == switchScaleMode) {
		 * System.out.println("mode = switchscale "); //run switch scale
		 * addSequential(new PrioritySwitchScale( side, scaleValue, switchValue,
		 * position )); } else if (mode == scaleSwitchMode) {
		 * System.out.println("mode = scale switch"); //run scale switch
		 * addSequential(new PriorityScaleSwitch( side, scaleValue, switchValue,
		 * position )); }
		 * 
		 * else { System.out.println("mode = nothing "); //do nothing }
		 */
	}

}
