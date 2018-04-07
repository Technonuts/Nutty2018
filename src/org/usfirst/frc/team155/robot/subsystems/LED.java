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


	private final DigitalOutput ard_0 = Robot.robotmap.LEDard_0;
	private final DigitalOutput ard_1 = Robot.robotmap.LEDard_1;
	private final DigitalOutput ard_2 = Robot.robotmap.LEDard_2;
	private final DigitalOutput ard_3 = Robot.robotmap.LEDard_3;
	
	private int speedstate=0;
	private int clawstate=0;
	private int motorstate=0;
	private int directionstate=0;
	private int hangerstate=0;
	private int disabedstate=0;
	private int ledtotal=0;
	private int holdstate=0;
	

	public LED(	) {
		//robotMap155 robotSystem, Drive155 driveSystem, shooter155 shooterSystem, gear155 gearSystem, climber155 climbSystem, PixyVision155 cameraSystem

		//ard_0=new DigitalOutput(Robot.robotmap.ARDUINO_0); 
		//ard_1=new DigitalOutput(Robot.robotmap.ARDUINO_1); 
		//ard_2=new DigitalOutput(Robot.robotmap.ARDUINO_2);
		//ard_3=new DigitalOutput(Robot.robotmap.ARDUINO_3);	 
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}


	public void LEDdisable(int on) {
		disabedstate=on;
	}
	
	public void LEDHold(int on) {
		holdstate=on;
	}
	
	public void LEDspeed(int on) {
		speedstate=on;
	}
	
	public void LEDclaw(int on) {
		clawstate=on;
	}
	public void LEDmotor(int on) {
		motorstate=on;
	}
	public void LEDdirection(int on) {
		directionstate=on;
	}
	public void LEDhanger(int on) {
		hangerstate=on;
	}
	
	
	public void modeSelect(){ 

		
		ledtotal = disabedstate+speedstate+clawstate*2+motorstate*4;
		if(hangerstate==1)
			ledtotal=9;
		if(motorstate==2) {
			if (speedstate==0)
				ledtotal=7;
			else
				ledtotal=8;
		}
		
		
		if(directionstate==1) {
			if (speedstate==0)
				ledtotal=10;
			else
				ledtotal=11;
		}
		
		if(holdstate==1) {
			if (speedstate==0)
				ledtotal=12;
			else
				ledtotal=13;
		}
		
		switch (ledtotal){ 
		case 0: 
			setColorMode(0); //disabled
			break; 
		case 1: 
			setColorMode(12); //Low Closed off
			break; 
		case 2: 
			setColorMode(13); //High close off
			break; 
		case 3://Low Sucking open
			setColorMode(8);
			break; 
		case 4: // High Sucking open
			setColorMode(7);
			break; //
		case 5: //Low Sucking Closed
			setColorMode(6);
			break; // 
		case 6: // High Sucking Closed
			setColorMode(5);
			break; // 
		case 7: // Low spitting
			setColorMode(2); 
			break;
		case 8: // High Spitting
			setColorMode(1); 
			break;
		case 9: //Climbing
			setColorMode(9); 
			break;
		case 10: //Low Reverse
			setColorMode(10); 
			break;
		case 11: //High Reverse
			setColorMode(11); 
			break;
		case 12: //Low Hold
			setColorMode(4); 
			break;
		case 13: //High Hold
			setColorMode(3); 
			break;	
			
		}
	}

	public void setColorMode(int colormode){ //System.out.println("colormode =" + (colormode)); 
		switch (colormode){ 
		case 0: //Knightrider mode
			ard_0.set(false); 
			ard_1.set(false); 
			ard_2.set(false);
			ard_3.set(false);//
			//System.out.println("trying 0"); 
			break; 
		case 1: //flash red
			ard_0.set(true); 
			ard_1.set(false); 
			ard_2.set(false); //
			ard_3.set(false);
			//System.out.println("trying 1"); 
			break; 
		case 2: //solid red
			ard_0.set(false); 
			ard_1.set(true); 
			ard_2.set(false); 
			ard_3.set(false);//
			//System.out.println("trying 2"); 
			break; 
		case 3: //flash green
			ard_0.set(true); 
			ard_1.set(true); 
			ard_2.set(false);
			ard_3.set(false);//
			//System.out.println("trying 3"); 
			break; 
		case 4: //solid green
			ard_1.set(false); 
			ard_2.set(true);
			ard_3.set(false);//
			System.out.println("trying 4"); 
			break; 
		case 5: //flash Blue
			ard_0.set(true); 
			ard_1.set(false); 
			ard_2.set(true);
			ard_3.set(false);//
			//System.out.println("trying 5"); 
			break; 
		case 6: //Solid Blue
			ard_0.set(false); 
			ard_1.set(true); 
			ard_2.set(true);
			ard_3.set(false);//
			//System.out.println("trying 6"); 
			break; 
		case 7: //flash Orange
			ard_0.set(true); 
			ard_1.set(true); 
			ard_2.set(true);
			ard_3.set(false);//
			//System.out.println("trying 7"); 
			break;
		case 8: //Solid Orange
			ard_0.set(false); 
			ard_1.set(false); 
			ard_2.set(false);
			ard_3.set(true);//
			//System.out.println("trying 7"); 
			break;
		case 9: //Climbing
			ard_0.set(true); 
			ard_1.set(false); 
			ard_2.set(false);
			ard_3.set(true);//
			//System.out.println("trying 7"); 
			break;
		case 10: //Solid Purple
			ard_0.set(false); 
			ard_1.set(true); 
			ard_2.set(false);
			ard_3.set(true);//
			//System.out.println("trying 7"); 
			break;
		case 11: //flash Purple
			ard_0.set(true); 
			ard_1.set(true); 
			ard_2.set(false);
			ard_3.set(true);//
			//System.out.println("trying 7"); 
			break;
		case 12: //solid White
			ard_0.set(false); 
			ard_1.set(false); 
			ard_2.set(true);
			ard_3.set(true);//
			//System.out.println("trying 7"); 
			break;
		case 13: //flash White
			ard_0.set(true); 
			ard_1.set(false); 
			ard_2.set(true);
			ard_3.set(true);//
			//System.out.println("trying 7"); 
			break;
		case 14: //off
			ard_0.set(false); 
			ard_1.set(true); 
			ard_2.set(true);
			ard_3.set(true);//
			//System.out.println("trying 7"); 
			break;
		case 15: //disabled  Knightrider mode
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


