package org.usfirst.frc.team155.robot.commands;

import org.usfirst.frc.team155.robot.Robot;
import org.usfirst.frc.team155.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PlainAutonomous extends CommandGroup {

	/*
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
	 */
	private double angle=0;



	//	/1 vtick == 18.9in
	//	.64 ticks == 12 in


	/////////////////////////////////////////////////////////////assuming 360
	private final double BEYONDBOX = 120*19.1;  // 120 in
	//switch width = 12ft
	private final double SCALEDIST = (270*19.1); //15.3; 270in
	//distance to middle of switch - 18(toposition) - robot(40)
	private final double BETWEENDIST = (210*19.1); //11.1;   210
	//halfway between scale and switch
	private final double BACKTOSWITCH = (12*19.1); // 12 in
	
	private final double SWITCHDIST = (100*19.1);  //100
	
	///140 to switch - length of robot (40) 
	private final double PILEDIST = (48*19.1); // 48 in
	private final double OTHERSWITCH = (108*19.1);  //108 in
	//	distance from midpoint to midpoint of switch plates



	///////////////////////////////////////////////////////////asssuming 90
	/*
	private final double BEYONDBOX = (120* 4.77); // 120 in
	//switch width = 12ft
	private final double SCALEDIST = (270*4.77); //15.3; 270in
	//distance to middle of switch - 18(toposition) - robot(40)
	private final double BETWEENDIST = (210*4.77); //11.1;   210
	//halfway between scale and switch
	private final double BACKTOSWITCH = (12*4.77); // 12 in
	private final double SWITCHDIST = (100*;  /4.77/100
	///140 to switch - length of robot (40) 
	private final double PILEDIST = (48*4.77); // 48 in
	private final double OTHERSWITCH = (108*4.77);  //108 in
//	distance from midpoint to midpoint of switch plates

	 */
	//324 to senter of scale - 18 inches traveled, - robot length(40)

	//82 inches distance to switch - distance of toPosition

	//public Autonomous(int mode, int side, double autoDelay, int scaleValue, int switchValue) {
	public PlainAutonomous() {

		addSequential(new DriveStraightDistance(6.5, 0.5));
		addParallel(new RetractWrist());




	}


}
