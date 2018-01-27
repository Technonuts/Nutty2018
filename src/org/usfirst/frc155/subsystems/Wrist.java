package org.usfirst.frc155.subsystems;

import org.usfirst.frc155.RobotMap;

import org.usfirst.frc155.commands.*;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.AnalogPotentiometer;

/**
 *
 */
public class Wrist extends PIDSubsystem {

		public static final double LEFT = 0;
	    public static final double CENTER= 24;
	    public static final double RIGHT = 53;
	    
	    private final AnalogPotentiometer wristPot = RobotMap.wristPot;
	    private final AnalogInput wrist = RobotMap.clawElbowPosition;
    // Initialize your subsystem here
    public void Wrist() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return 0.0;
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
