package org.usfirst.frc.team155.robot.commands;

import org.usfirst.frc.team155.robot.Robot;
import org.usfirst.frc.team155.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous extends CommandGroup {
	private double autoStart;
	public int clock=0;
	/*
	 * private int leftValue = 0; private int centerValue = 1; private int
	 * rightValue = 2; private int scaleMode = 0; private int switchMode = 1;
	 * private int megaMode = 2; private int twoScaleMode = 3; private int
	 * twoSwitchMode = 4; private int switchScaleMode = 5; private int
	 * scaleSwitchMode = 6;
	 */
	private double autoSpeed = .281;

	// /1 vtick == 18.9in
	// .64 ticks == 12 l
	
	//to switch = 140
	//switch is about 12 feet long and 4 feet wid
	// prev drive multiplier -  .065
private double driveMultiplier = .722;
	///////////////////////////////////////////////////////////// assuming 360
	private final double BEYONDBOX = (120*driveMultiplier); // 120*19.1; // 120 in
	// switch width = 12ft
	private final double SCALEDIST = (270*driveMultiplier);// (270*19.1); //15.3; 270in
	// distance to middle of switch - 18(toposition) - robot(40)
	private final double BETWEENDIST = (220*driveMultiplier);// (210*19.1); //11.1; 210
	// halfway between scale and switch
	private final double BACKTOSWITCH = (18*driveMultiplier);// (12*19.1); // 12 in

	private final double SWITCHDIST = 6.5;//(128*driveMultiplier);// (; //100

	/// 140 to switch - length of robot (40)
	private final double PILEDIST = (48*driveMultiplier); // (48*19.1); // 48 in
	private final double OTHERSWITCH = (86*driveMultiplier); // (108*19.1); //108 in
	// distance from midpoint to midpoint of switch plates

	/////////////////////////////////////////////////////////// asssuming 90
	/*
	 * private final double BEYONDBOX = (120* 4.77); // 120 in //switch width = 12ft
	 * private final double SCALEDIST = (270*4.77); //15.3; 270in //distance to
	 * middle of switch - 18(toposition) - robot(40) private final double
	 * BETWEENDIST = (210*4.77); //11.1; 210 //halfway between scale and switch
	 * private final double BACKTOSWITCH = (12*4.77); // 12 in private final double
	 * SWITCHDIST = (100*; /4.77/100 ///140 to switch - length of robot (40) private
	 * final double PILEDIST = (48*4.77); // 48 in private final double OTHERSWITCH
	 * = (108*4.77); //108 in // distance from midpoint to midpoint of switch plates
	 * 
	 */
	// 324 to senter of scale - 18 inches traveled, - robot length(40)

	// 82 inches distance to switch - distance of toPosition

	// public Autonomous(int mode, int side, double autoDelay, int scaleValue, int
	// switchValue) {
	public Autonomous(int side, double autoDelay, int scaleValue, int switchValue) {
		if (clock == 0) {
		autoStart = Timer.getFPGATimestamp();
		clock=1;
		}



		// System.out.println("Here2");
		// position 0 = left, 1 = center, 2=right
		/*
		if (side == 0) {
			angle = 90;
		}
		if (side == 2) {
			angle = -90;
		}
		if (side == 3) {
			angle = 0;
		}
		*/
		// addSequential(new DriveStraightDistance(3,.4));
		// addSequential(new TurnDriveAngle(180,autoSpeed)); // actual angle = 180
		// addSequential(new DriveStraightDistance(3,.4));

		addSequential(new readForDelay(autoDelay)); // findSpot
		
		addSequential(new RetractWrist());
		
	
		// if the robot is on the left or on the right
		if (side == 0 || side == 2) {
			// System.out.println("Mode=Edge Mode");
			// this checks whether or not the switch is on the same side as our robot
			if (switchValue == side) {
				// System.out.println("Scale Side = our side");
				// run switch comman
				// System.out.println("toposition");
				addSequential(new AutoSwitch(side, 8.5));
				
				if (Timer.getFPGATimestamp() >= autoStart + 10) {
					addParallel(new SpittingCube());
	    			}
				// System.out.println("autoscale");
				// do we want to get another cube
				/*
					addSequential(new FromSwitchToBoxes(side));
					addSequential(new GetCubeDumpSide(side));
					addSequential(new MoveWrist(0));
					addSequential (new MoveLift(RobotMap.FLOORHEIGHT));
					addSequential(new DriveStraightDistance(1, autoSpeed));
			    	addParallel(new CubeAquire());
			    	addSequential(new DriveStraightDistance(-1, autoSpeed));
			    	addSequential(new MoveWrist(angle));
			    	addSequential(new SpittingCube());
				 */
				

			}



			//pall elev to seq ///////////////////////////////////////////////////////////////////////////////////////////////////////


		/*	else if (scaleValue == side) {
				// System.out.println("MSwitch side = our side");
				// run switch command
				////addSequential(new ToPosition());
				// System.out.println("toPosition");
				//addSequential(new AutoScale(side, SCALEDIST));
				/*
				addSequential(new FromScaleToBoxes(side));
				if(switchValue == side) {
				addSequential(new GetCubeDumpSide(side));
				}
				else {
					addSequential(new DriveStraightDistance(1, autoSpeed));
			    	addParallel(new CubeAquire());
			    	addSequential(new DriveStraightDistance(-1, autoSpeed));
			    	addSequential(new TurnDriveAngle(-angle, autoSpeed));
			       	addSequential(new DriveStraightDistance(3.12, autoSpeed));
			       	addSequential (new MoveLift(RobotMap.HIGHSCALEHEIGHT));
			       	addSequential(new TurnDriveAngle(angle, autoSpeed));
			       	addSequential(new SpittingCube());
			       	addSequential(new DriveStraightDistance(-2, autoSpeed));
			     	addSequential (new MoveLift(RobotMap.FLOORHEIGHT));

				}*/
				// System.out.println("autoswitch");

			 {
				 System.out.println("Switch and scale side = not our side, Drive Straight");
				// cross line
				addSequential(new DriveStraightDistance(6.5, autoSpeed));
				
				//addSequential(new TurnDriveAngle(angle, autoSpeed));
				//addSequential(new DriveStraightDistance(BEYONDBOX, autoSpeed));
				//addSequential(new TurnDriveAngle(angle + angle, autoSpeed));
				//addParallel (new MoveLift(RobotMap.FENCEHEIGHT));

				//addSequential(new DriveStraightDistance(BACKTOSWITCH, autoSpeed));
				//addParallel(new ExtendWrist());
				//addSequential(new SpittingCube());
				//addSequential(new RetractWrist());
			}
		}
	

	
	else{

		// System.out.println("Mode=Switch Mode");
		// robot is in the center and switch is on our side
		if (switchValue == 2) {
			// System.out.println("Switch our side");
			// run switch command
			addSequential(new DriveStraightDistance(6, .15));
			//addSequential(new MoveLift(RobotMap.FENCEHEIGHT));
			if (Timer.getFPGATimestamp() >= autoStart + 10) {
				addParallel(new SpittingCube());
    			}
			addSequential(new SpittingCube());
			
			/*
			addSequential(new RetractWrist());
			// get another cube
			 addSequential(new DriveStraightDistance(-.5, autoSpeed)); 
			 addSequential(new TurnDriveAngle(-90, autoSpeed)); 
			 addSequential(new MoveLift(RobotMap.FLOORHEIGHT));
			 addSequential(new DriveStraightDistance(2.06, autoSpeed));
			 addParallel(new CubeAquire());
			 addSequential(new DriveStraightDistance(-2.06, autoSpeed));
			 addSequential(new TurnDriveAngle(0, autoSpeed));
			 addSequential(new DriveStraightDistance(.5, autoSpeed));
			 addSequential(new SpittingCube()); //three
			 */
			/* cube addSequential(new DriveStraightDistance(-1, autoSpeed)); addSequential(new
			 * TurnDriveAngle(-90, autoSpeed)); addSequential(new MoveLift(RobotMap.FLOORHEIGHT));
			 * addSequential(new DriveStraightDistance(PILEDIST, autoSpeed)); addParallel(new
			 * CubeAquire()); addSequential(new DriveStraightDistance(-PILEDIST, autoSpeed));
			 * addSequential(new TurnDriveAngle(0, autoSpeed)); addSequential(new
			 * DriveStraightDistance(1, autoSpeed)); addSequential(new SpittingCube());
			 */

		} else {
			// System.out.println("switch other side");
			// run other switch command
			// addSequential(new ToPosition());
			// add
			addSequential(new DriveStraightDistance(2.5, autoSpeed));
			//addParallel(new MoveLift(RobotMap.FENCEHEIGHT));
			 addSequential(new TurnDriveAngle(-90, .75)); 
			 addSequential(new DriveStraightDistance(5.5, autoSpeed));
			 
			 addSequential(new TurnDriveAngle(0, .75));
			 addSequential(new DriveStraightDistance(( 4), autoSpeed));
			 //addParallel(new MoveLift(RobotMap.FENCEHEIGHT));
			 //addSequential(new ExtendWrist());
			 if (Timer.getFPGATimestamp() >= autoStart + 13) {
					addParallel(new SpittingCube());
	    			}
			 addSequential(new SpittingCube());
			 //addSequential(new RetractWrist());
			//////////////////// or//////////////////////////////////////////////////////////////
			/*
			 * addSequential(new DriveStraightDistance(SWITCHDIST, autoSpeed)); addSequential(new
			 * MoveLift(RobotMap.FENCEHEIGHT)); addSequential(new ExtendWrist());
			 */
			/*
			 * addSequential(new DriveStraightDistance(-1, autoSpeed)); addSequential(new
			 * TurnDriveAngle(90, autoSpeed)); addSequential(new MoveLift(RobotMap.FLOORHEIGHT));
			 * addSequential(new DriveStraightDistance(PILEDIST, autoSpeed)); addParallel(new
			 * CubeAquire()); addSequential(new DriveStraightDistance(-PILEDIST, autoSpeed));
			 * addSequential(new TurnDriveAngle(0, autoSpeed)); addSequential(new
			 * DriveStraightDistance(1, autoSpeed)); addSequential(new SpittingCube());
			 */
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
