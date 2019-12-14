/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import frc.robot.RobotMap;

import frc.robot.commands.driving.*;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem implements PIDOutput {

    private WPI_TalonSRX _flTalon, _frTalon, _blTalon, _brTalon;
    private SpeedControllerGroup _leftSpeedController, _rightSpeedController;
    private DifferentialDrive _differentialDrive;

    // private PIDController _pidController;
    // private AHRS _ahrs;

    // static final double kP = 0.05;
    // static final double kI = 0;
    // static final double kD = 0;
    // static final double kF = 0;

    public DriveTrain() {

        /**
         * Epic motors
         */

        _flTalon = new WPI_TalonSRX(RobotMap.DT_FL_TALON);
        _flTalon.setInverted(true);
        _blTalon = new WPI_TalonSRX(RobotMap.DT_BL_TALON);
        _leftSpeedController = new SpeedControllerGroup(_flTalon, _blTalon);

        _frTalon = new WPI_TalonSRX(RobotMap.DT_FR_TALON);
        _frTalon.setInverted(true);
        _brTalon = new WPI_TalonSRX(RobotMap.DT_BR_TALON);
        _brTalon.setInverted(true);
        _rightSpeedController = new SpeedControllerGroup(_frTalon, _brTalon);

        _differentialDrive = new DifferentialDrive(_leftSpeedController, _rightSpeedController);

        /**
         * Epic PIDs (so epic)
         */

        // _ahrs = new AHRS(SPI.Port.kMXP);

        // _pidController = new PIDController(kP, kI, kD, _ahrs, this);
        // _pidController.setInputRange(-180, 180);
        // _pidController.setOutputRange(0, 1);
        // _pidController.setAbsoluteTolerance(5);
        // _pidController.setContinuous(true);

        // LiveWindow.addActuator("DriveTrain", "PIDController", _pidController);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new DrivingGroup());
    }

    @Override
    public void pidWrite(double output) {
        _leftSpeedController.set(output);
        _rightSpeedController.set(-output);
    }

    public DifferentialDrive getDifferentialDrive() {
        return _differentialDrive;
    }
}
