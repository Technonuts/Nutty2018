package org.usfirst.frc.team155.robot.commands;

import org.usfirst.frc.team155.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Hangmode extends CommandGroup {

    public Hangmode() {
        // Add Commands here:
         addSequential(new MoveLift(RobotMap.HANGHEIGHT));
         addSequential(new HookWait());
         addSequential(new MoveLift(RobotMap.LOWSCALEHEIGHT));
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
