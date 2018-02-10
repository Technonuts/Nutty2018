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
    	//addSequential(new TurnDriveAngle(-90, 1) );
    	new readForDelay(autoDelay); //findSpot
		if (mode == scaleMode) {
			//this is scale code
			if(scaleValue==side) {
				//run scale command
				addSequential(new ToPosition());
				addSequential(new AutoScale(side)); 
			}
			else if(switchValue ==side) {
				//run switch command
				addSequential(new ToPosition());
				addSequential(new AutoSwitch( side));
			}
			else {
				//cross line 
				addSequential(new DriveStraightDistance(5,0.5));
			}

		}
		else if (mode == switchMode) {
			//this is switch only code
			if(switchValue==side) {
				//run switch command
				addSequential(new ToPosition());
				addSequential(new AutoSwitch (side));
			}
			else {
				//run other switch command
				addSequential(new ToPosition());
				addSequential(new ToOtherSide(side, position));
				addSequential(new AutoSwitch (side));


				//	new oppositeSwitch(position, side);
			}

		}
		else if (mode == megaMode) {
			//this is to try and get the sca'e on the opposite side if it's not on our side
			if(scaleValue==side) {
				//run scale command
				addSequential(new ToPosition());
				addSequential(new AutoScale(side)); 
			}
			else {
				//go to other side of scale
				addSequential(new ToPosition());
				addSequential(new ToOtherSide ( side , position));
				addSequential(new AutoScale(side));

			}
		}

		else if (mode == twoScaleMode) {
			//run 2 scale 
			addSequential(new PriorityScale( side, scaleValue, switchValue, position ));
		}

		   else if (mode == twoSwitchMode) {
			//run 2 switch 
			   addSequential(new PrioritySwitch( side, scaleValue, switchValue, position ));
		 }

		else if (mode == switchScaleMode) {
			//run switch scale
			addSequential(new PrioritySwitchScale(   side, scaleValue, switchValue, position  ));
		}
		else if (mode == scaleSwitchMode) {
			//run scale switch
			addSequential(new PriorityScaleSwitch(  side, scaleValue, switchValue, position   ));
		}

		else {
			//do nothing
		}
    	
       
    }
}
