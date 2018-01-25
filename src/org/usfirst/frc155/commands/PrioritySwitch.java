package org.usfirst.frc155.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PrioritySwitch extends CommandGroup {

    public PrioritySwitch(int position, int scaleValue, int switchValue, int travelLength) {
    	
    	if(position==switchValue) {
    		//2 switches
    		
    		addSequential(new DoubleSwitchAuto(position, switchValue, travelLength));
    		
    		
    	}
    	else if(position==scaleValue){
    		//2 scale
    		
    		addSequential(new DoubleScaleAuto(position, scaleValue, travelLength));
    	}
    	else {
    		//2 switches opposite
    		//code to go to other side needed
    		//other side and double scale
    		addSequential(new DoubleScaleAuto(position, scaleValue, travelLength));
    	}
    	
    	
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
    }
}
