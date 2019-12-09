/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    public static final int LEFT_X_JOYSTICK_AXIS = 0;
    public static final int LEFT_Y_JOYSTICK_AXIS = 1;
    public static final int RIGHT_X_JOYSTICK_AXIS = 4;
    public static final int RIGHT_Y_JOYSTICK_AXIS = 5;

    public static final int LEFT_TRIGGER_AXIS = 2;
    public static final int RIGHT_TRIGGER_AXIS = 3;

    public OI() {
        _driverController = new XboxController(0);
        _operatorController = new XboxController(1);
    }

    private XboxController _driverController;
    private XboxController _operatorController;

    public XboxController getDriverController() {
        return _driverController;
    }

    public XboxController getOpeartorController() {
        return _operatorController;
    }
}
