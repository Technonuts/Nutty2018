package org.usfirst.frc155.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PrioritySwitchScale extends CommandGroup {

    public PrioritySwitchScale(int position, int scaleValue, int switchValue, int travelLength) {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	if(position==switchValue) {
    		//2 switches
    		
    		addSequential(new ToPosition());
    		addSequential(new DoubleSwitchScale(position, switchValue));
    		
    		
    	}
    	else if(position==scaleValue){
    		//2 scale
    		
    		addSequential(new ToPosition());
    		addSequential(new DoubleScaleAuto(position, scaleValue, travelLength));
    	}
    	else {
    		//2 switches opposite

    		addSequential(new ToOtherSide(scaleValue, position));
    		addSequential(new DoubleSwitchAuto(position, scaleValue, travelLength));
    	}
    	
    	
    	
    }
}
