package org.usfirst.frc.team155.robot.commands;

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

    public Autonomous( int mode, int side, double autoDelay, int scaleValue, int switchValue, int position) {
    	System.out.println("Here2");
    //addSequential(new DriveStraightDistance(3,.4));
    	//addSequential(new TurnDriveAngle(180,.5));  // actual angle = 180
    	//addSequential(new DriveStraightDistance(3,.4));
  
 	addSequential(new readForDelay(autoDelay)); //findSpot
		if (mode == scaleMode) {
			System.out.println("Mode=Scale Mode");
			//this is scale code
			if(scaleValue==side) {
				System.out.println("Scale Side = our side");
				//run scale command
				addSequential(new ToPosition());
				System.out.println("toposition");
				addSequential(new AutoScale(side)); 
				System.out.println("autoscale");
			}}
			
	 /*  		else if(switchValue ==side) {
				System.out.println("MSwitch side = our side");
				//run switch command
				addSequential(new ToPosition());
				System.out.println("toPosition");
				addSequential(new AutoSwitch( side));
				System.out.println("autoswitch");
			}
			else {System.out.println("Switch and scale side = not our side");
				//cross line 
				addSequential(new DriveStraightDistance(5,0.5));
			}

		}
		else if (mode == switchMode) {
			System.out.println("Mode=Switch Mode");
			//this is switch only code
			if(switchValue==side) {
				System.out.println("Switch our side");
				//run switch command
				addSequential(new ToPosition());
				addSequential(new AutoSwitch (side));
			}
			else {
				System.out.println("switch other side");
				//run other switch command
				addSequential(new ToPosition());
				addSequential(new ToOtherSide(side, position));
				addSequential(new AutoSwitch (side));


				//	new oppositeSwitch(position, side);
			}

		}
		else if (mode == megaMode) {
			System.out.println("Mode=Smega mode");
			//this is to try and get the sca'e on the opposite side if it's not on our side
			if(scaleValue==side) {
				System.out.println("mega Scale our side ");
				//run scale command
				addSequential(new ToPosition());
				addSequential(new AutoScale(side)); 
			}
			else {
				//go to other side of scale
				System.out.println("mega Scale other side ");
				addSequential(new ToPosition());
				addSequential(new ToOtherSide ( side , position));
				addSequential(new AutoScale(side));

			}
		}

		else if (mode == twoScaleMode) {
			System.out.println("mode = 2 scale ");
			//run 2 scale 
			addSequential(new PriorityScale( side, scaleValue, switchValue, position ));
		}

		   else if (mode == twoSwitchMode) {
			   System.out.println("mode = 2 switch ");
			//run 2 switch 
			   addSequential(new PrioritySwitch( side, scaleValue, switchValue, position ));
		 }

		else if (mode == switchScaleMode) {
			System.out.println("mode = switchscale ");
			//run switch scale
			addSequential(new PrioritySwitchScale(   side, scaleValue, switchValue, position  ));
		}
		else if (mode == scaleSwitchMode) {
			System.out.println("mode = scale switch");
			//run scale switch
			addSequential(new PriorityScaleSwitch(  side, scaleValue, switchValue, position   ));
		}

		else {
			System.out.println("mode = nothing ");
			//do nothing
		}
    	
      */ 
    }
}
