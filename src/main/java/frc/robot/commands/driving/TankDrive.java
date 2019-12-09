/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.driving;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class TankDrive extends Command {
    public TankDrive() {
        requires(Robot._driveTrain);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {

        var drive = Robot._driveTrain.getDifferentialDrive();

        drive.tankDrive(scaleInput(Robot._oi.getDriverController().getRawAxis(OI.LEFT_Y_JOYSTICK_AXIS)),
                scaleInput(Robot._oi.getDriverController().getRawAxis(OI.RIGHT_Y_JOYSTICK_AXIS)));
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }

    private double scaleInput(double input) {
        return (input < 0.f ? -1.f : 1.f) * Math.pow(input, 2);
    }
}
