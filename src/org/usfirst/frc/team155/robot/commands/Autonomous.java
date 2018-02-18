package org.usfirst.frc.team155.robot.commands;

import org.usfirst.frc.team155.robot.Robot;

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
	private final double BEYONDBOX = (120)/12;
	//12 foot switch lenght = 2ft
	private final double SCALEDIST = (270)/12;
	//distance to middle of switch - 18(toposition) - robot(40)
	private final double BETWEENDIST = (210 )/12;
	//halfway between scale and switch
	private final double BACKTOSWITCH = 1;
	private final double SWITCHDIST = (100)/12;
	///140 to switch - length of robot (40) 
	private final double PILEDIST = 4;
	private final double OTHERSWITCH = 108/12;
//	distance from mindpoint to midpoint of switch plates
	
	public Autonomous(int mode, int side, double autoDelay, int scaleValue, int switchValue, int position) {
		// System.out.println("Here2");
		// position 0 = left, 1 = center, 2=right
		if (position == 0) {
			angle = 90;
		}
		if (position == 2) {
			angle = -90;
		}
		// addSequential(new DriveStraightDistance(3,.4));
		// addSequential(new TurnDriveAngle(180,.5)); // actual angle = 180
		// addSequential(new DriveStraightDistance(3,.4));

		addSequential(new readForDelay(autoDelay)); // findSpot
		// if the robot is on the left or on the right
		if (position == 0 || position == 2) {
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
					addSequential(new FromSwitchToBoxes(position));
					addSequential(new GetCubeDumpSide(position));

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
				addSequential (new MoveLift(Robot.elevator.FENCEHEIGHT));
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
				addSequential(new MoveLift(Robot.elevator.FENCEHEIGHT));
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
				addSequential(new MoveLift(Robot.elevator.FENCEHEIGHT));
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
