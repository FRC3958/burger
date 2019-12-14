/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Timer;

public class ShootBall extends Command {

    Timer _timer = new Timer();

    public ShootBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot._flyWheel);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {

        _timer.reset();
        _timer.start();

        Robot._flyWheel.getWheel().set(ControlMode.PercentOutput, .2f);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {

        if (_timer.get() >= .5f) {
            _timer.stop();
            _timer.reset();

            return true;
        }

        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {

        Robot._flyWheel.getWheel().stopMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
