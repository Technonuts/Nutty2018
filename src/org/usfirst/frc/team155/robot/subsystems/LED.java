package org.usfirst.frc.team155.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team155.robot.Robot;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LED extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	// arduino control pins


	public DigitalOutput ard_0;
	public DigitalOutput ard_1;
	public DigitalOutput ard_2;
	public DigitalOutput ard_3;

	public LED(	) {
		//robotMap155 robotSystem, Drive155 driveSystem, shooter155 shooterSystem, gear155 gearSystem, climber155 climbSystem, PixyVision155 cameraSystem

		ard_0=new DigitalOutput(Robot.robotmap.ARDUINO_0); 
		ard_1=new DigitalOutput(Robot.robotmap.ARDUINO_1); 
		ard_2=new DigitalOutput(Robot.robotmap.ARDUINO_2);
		ard_3=new DigitalOutput(Robot.robotmap.ARDUINO_3);	 
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}


	public void modeSelect(){ 

		int speed = Robot.robotmap.speedMode;
		int claw = Robot.robotmap.clawMode;

		int total = speed + claw;



		switch (total){ 
		case 0: 
			setColorMode(0); //disabled
			break; 
		case 1: 
			setColorMode(1); //Low Holding
			break; 
		case 2: 
			setColorMode(2); //High Holding
			break; 
		case 3://Low Sucking Open
			setColorMode(3);
			break; 
		case 4: // High Sucking Open
			setColorMode(4);
			break; //
		case 5: //Low Sucking Closed
			setColorMode(5);
			break; // 
		case 6: // High Sucking Closed
			setColorMode(6);
			break; // 
		case 7: // Low spitting
			setColorMode(7); 
			break;
		case 8: // High Spitting
			setColorMode(8); 
			break;
		case 9: //Climbing
			setColorMode(9); 
			break;
		case 10: //Climbing
			setColorMode(9); 
			break;
			//

		}

	}

	public void setColorMode(int colormode){ //System.out.println("colormode =" + (colormode)); 
		switch (colormode){ 
		case 0: //no ball Orange?
			ard_0.set(false); 
			ard_1.set(false); 
			ard_2.set(false);
			ard_3.set(true);//
			//System.out.println("trying 0"); 
			break; 
		case 1: //have ball Blue?
			ard_0.set(true); 
			ard_1.set(false); 
			ard_2.set(false); //
			ard_3.set(true);
			//System.out.println("trying 1"); 
			break; 
		case 2: //shooter not up to speed ---Flashing Blue
			ard_0.set(false); 
			ard_1.set(true); 
			ard_2.set(false); 
			ard_3.set(true);//
			//System.out.println("trying 2"); 
			break; 
		case 3: //shooter up to speed and have ball ---Green
			ard_0.set(true); 
			ard_1.set(true); 
			ard_2.set(false);
			ard_3.set(true);//
			//System.out.println("trying 3"); 
			break; 
		case 4: //shooter up to speed and no ball ---Orange Flashing----Red
			ard_0.set(false); 
			ard_1.set(false); 
			ard_2.set(true);
			ard_3.set(true);//
			System.out.println("trying 4"); 
			break; 
		case 5: //shooter on and no ball  Orange Flashing----Red
			ard_0.set(true); 
			ard_1.set(false); 
			ard_2.set(true);
			ard_3.set(true);//
			//System.out.println("trying 5"); 
			break; 
		case 6: //climb mode-  Party Mode
			ard_0.set(false); 
			ard_1.set(true); 
			ard_2.set(true);
			ard_3.set(true);//
			//System.out.println("trying 6"); 
			break; 
		case 7: //disabled  Knightrider mode
			ard_0.set(true); 
			ard_1.set(true); 
			ard_2.set(true);
			ard_3.set(true);//
			//System.out.println("trying 7"); 
			break;
		case 8: //disabled  Knightrider mode
			ard_0.set(true); 
			ard_1.set(true); 
			ard_2.set(true);
			ard_3.set(true);//
			//System.out.println("trying 7"); 
			break;
		case 9: //disabled  Knightrider mode
			ard_0.set(true); 
			ard_1.set(true); 
			ard_2.set(true);
			ard_3.set(true);//
			//System.out.println("trying 7"); 
			break;
		


		}
	}


}


/**
 *
 */


