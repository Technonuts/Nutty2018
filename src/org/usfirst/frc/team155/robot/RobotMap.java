// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc.team155.robot;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.*;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * 
 *  
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
   // public static AHRS drivetrainGyro1;
    public static AnalogGyro drivetrainGyro1;
    public static AnalogInput drivetrainRangeFinder;
    //public static AnalogPotentiometer elevatorLiftPot;
    public static AnalogInput clawCubeSensor;
 
   
    public static AnalogInput clawElbowPosition; 
    
    public static Encoder drivetrainLeftEncoder;
    public static Encoder drivetrainRightEncoder;
    public static DoubleSolenoid drivetrainSpeedSolenoid;
    public static Compressor drivetrainCompressor1;
    public static WPI_VictorSPX drivetrainLeftDrive1;
    public static WPI_VictorSPX drivetrainLeftDrive2;
    public static WPI_VictorSPX drivetrainRightDrive1;
    public static WPI_VictorSPX drivetrainRightDrive2;
    public static RobotDrive drivetrainRobotDrive4;

    public static VictorSP clawElbow;
    public static DoubleSolenoid clawWrist; 
    
    public static Encoder elevatorLiftEncoder;

    public static WPI_VictorSPX elevatorLift_1; 
   // public static WPI_VictorSPX elevatorLift_2; 
    
    public static VictorSP elevatorLeftHanger;
    public static VictorSP elevatorRightHanger;

  //  public static WPI_VictorSPX elevatorLift;
   
    public static Spark clawLeftMotor;
    public static Spark clawRightMotor;

    public static DigitalInput leftBoxSwitch;
    public static DigitalInput rightBoxSwitch;
    public static DigitalInput elevatorSwitchHigh;
    public static DigitalInput elevatorSwitchLow;
    
    public static DigitalInput hangingSwitch;
    

    //2 speed controller and 2 pneumatic actuators for gripper
    
    public static DoubleSolenoid gripperPneumatics;
    
    public static double liftDistancePerPulse = 3.75/4553;
 
      public static double driveDistancePerPulse = 18.75/380/12; 
    
    // wheel = 18 3/4"
    // one encoder tick is equal to 12.6 inches
    //assuming 360
	public static final double FLOORHEIGHT = 0;
	public static final double FENCEHEIGHT = 8647.;//2.4;
	public static final double LOWSCALEHEIGHT = 1719;//4.8;
	public static final double HIGHSCALEHEIGHT = 2407;  
			 //6.7;
	public static final double HANGHEIGHT = 2579.62;//7.2;
   
    
//>>>>>>> branch 'master' of https://github.com/Technonuts/Nutty2018.git

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init  () {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    	
       drivetrainRangeFinder =  new AnalogInput   (4);
        LiveWindow.addSensor    ("Drivetrain", "Range Finder", drivetrainRangeFinder);

    	drivetrainGyro1 = new AnalogGyro(1);
       //drivetrainGyro1 = new AHRS drivetrainGyro1;
        //drivetrainGyro1 = new AHRS   (SPI.Port.kMXP);        
        LiveWindow.addSensor        ("Drivetrain", "Gyro 1", drivetrainGyro1);
        //drivetrainGyro1.setSensitivity           0.007);
        

        clawCubeSensor = new AnalogInput    (2);
        LiveWindow.addSensor     ("Claw", "Cube Sensor", clawCubeSensor);
        
       // elevatorLiftPot = new AnalogPotentiometer           3, 1.0, 0.0);
        //LiveWindow.addSensor           "Elevator", "Lift Pot", elevatorLiftPot);
        
        clawElbowPosition =	 new AnalogInput   (0);
        LiveWindow.addSensor         ("Claw", "Claw Elbow Position", clawElbowPosition);
          
        
        
        
        elevatorLiftEncoder = new Encoder        (4, 5, false, EncodingType.k4X);
        LiveWindow.addSensor       ("Elevator", "Lift Encoder", elevatorLiftEncoder);
        elevatorLiftEncoder.setReverseDirection        (true);
        elevatorLiftEncoder.setDistancePerPulse       (liftDistancePerPulse);
        elevatorLiftEncoder.setPIDSourceType       (PIDSourceType.kDisplacement);
        
        
        drivetrainLeftEncoder = new Encoder       (0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor        ("Drivetrain", "Left Encoder", drivetrainLeftEncoder);
        
        drivetrainLeftEncoder.setDistancePerPulse   (driveDistancePerPulse);
        drivetrainLeftEncoder.setPIDSourceType      (PIDSourceType.kDisplacement);
        
        drivetrainRightEncoder = new Encoder        (2, 3, false, EncodingType.k4X);
        LiveWindow.addSensor         ("Drivetrain", "Right Encoder", drivetrainRightEncoder);
        drivetrainRightEncoder.setDistancePerPulse    (driveDistancePerPulse);
        drivetrainRightEncoder.setPIDSourceType    (PIDSourceType.kDisplacement);
        
        
        
        
        leftBoxSwitch = new DigitalInput     (7);
        LiveWindow.addSensor         ("Claw", "Left Box Switch", leftBoxSwitch);
        
        rightBoxSwitch = new DigitalInput      (8);
        LiveWindow.addSensor        ("Claw", "Right Box Switch", rightBoxSwitch);
        
        elevatorSwitchHigh = new DigitalInput      (6);
        LiveWindow.addSensor      ("Elevator", "Elevator Switch High", elevatorSwitchHigh);
        
        elevatorSwitchLow = new DigitalInput      (9);
        LiveWindow.addSensor       ("Elevator", "Elevator Switch Low", elevatorSwitchLow);
        hangingSwitch = new DigitalInput     (10);
        LiveWindow.addSensor("Elevator", "Hanging Switch", hangingSwitch);
        
       
        
            
        drivetrainCompressor1 = new Compressor    (1);
        LiveWindow.addActuator        ("Drivetrain", "Compressor 1", drivetrainCompressor1);
        
        
        
               
        drivetrainLeftDrive1 = new WPI_VictorSPX       (4);
        drivetrainLeftDrive1.setSafetyEnabled        (false);
        drivetrainLeftDrive1.setInverted       (true);
        
        
        drivetrainLeftDrive2 = new WPI_VictorSPX   (5);
        drivetrainLeftDrive2.setSafetyEnabled     (false);
        drivetrainLeftDrive2.setInverted          (true);
        
        drivetrainRightDrive1 = new WPI_VictorSPX    (2);
        drivetrainRightDrive1.setSafetyEnabled       (false);
        drivetrainRightDrive1.setInverted        (true);
        
        drivetrainRightDrive2 = new WPI_VictorSPX      (3);
        drivetrainRightDrive2.setSafetyEnabled     (false);
        drivetrainRightDrive2.setInverted         (true);
        
        elevatorLift_1 = new WPI_VictorSPX    (6);
       // elevatorLift_2 = new WPI_VictorSPX       (5);    //change number *********
        
        
        
        
        clawElbow = new VictorSP       (7);
        
       LiveWindow.addActuator          ("Claw", "Elbow", clawElbow);
        drivetrainRobotDrive4 = new RobotDrive    (drivetrainRightDrive1, drivetrainRightDrive2, drivetrainLeftDrive1, drivetrainLeftDrive2);
        
        elevatorLeftHanger = new VictorSP         (8);
        
        elevatorRightHanger = new VictorSP        (9);
        
        
 
     
        clawLeftMotor = new Spark    (6);
        LiveWindow.addActuator       ("Claw", "Left Motor", clawLeftMotor);
        
        clawRightMotor = new Spark       (5);
        LiveWindow.addActuator       ("Claw", "Right Motor", clawRightMotor);

        
        
        
        drivetrainRobotDrive4.setSafetyEnabled      (true);
        drivetrainRobotDrive4.setExpiration       (0.1);
        drivetrainRobotDrive4.setSensitivity       (0.5);
        drivetrainRobotDrive4.setMaxOutput         (1.0);

        
        
        
        
        clawWrist = new DoubleSolenoid      (1, 2, 3);
        LiveWindow.addActuator         ("Claw", "Wrist", clawWrist);
        
        drivetrainSpeedSolenoid = new DoubleSolenoid     (1, 6, 7);
        LiveWindow.addActuator          ("Drivetrain", "Speed Solenoid", drivetrainSpeedSolenoid);
        
        gripperPneumatics = new DoubleSolenoid   (1, 0, 1);
        LiveWindow.addActuator     ("Claw", "Gripper Solenoid", gripperPneumatics);
        
        
        LiveWindow.addActuator        ("Elevator", "Left Hanger", elevatorLeftHanger);
        LiveWindow.addActuator        ("Elevator", "Right Hanger",elevatorRightHanger  );
    
     
        
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
    }
}
