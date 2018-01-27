// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc155.subsystems;

import org.usfirst.frc155.RobotMap;
import org.usfirst.frc155.commands.MoveLift;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 * 
 */
public class Claw extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS
    public static final double STOW = 0;
    public static final double SWITCH = 20;
    public static final double LOWSCALE = 40;
    public static final double HIGHSCALE = 60;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final AnalogInput cubeSensor = RobotMap.clawCubeSensor;
    private final DoubleSolenoid gripper = RobotMap.clawGripper;
    private final WPI_VictorSPX elbow = RobotMap.clawElbow;
    private final DoubleSolenoid wrist = RobotMap.clawWrist;
    private final Spark clawLeftMotor = RobotMap.clawLeftMotor;
    private final Spark clawRightMotor = RobotMap.clawRightMotor;
    private final AnalogInput clawElbowPosition = RobotMap.clawElbowPosition;

    
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new MoveLift(0));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

