
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class FlyWheel extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private WPI_TalonSRX _wheelTalon;

    public FlyWheel() {

        _wheelTalon = new WPI_TalonSRX(0);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    public WPI_TalonSRX getWheel() {
        return _wheelTalon;
    }
}
