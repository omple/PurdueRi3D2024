// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.JoystickDrive;
import frc.robot.commands.ShootTorus;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  DriveTrain driveTrain;
  XboxController driver, operator;
  ShooterSubsystem shooter;
  public RobotContainer() {
    this.driver = new XboxController(0);
    this.operator = new XboxController(1);
    this.driveTrain = new DriveTrain(1, 2, 3, 4);
    this.shooter = new ShooterSubsystem(5,6);
    
    // Configure the trigger bindings
    configureBindings();
  }

  private void configureBindings() {
    driveTrain.setDefaultCommand(new JoystickDrive(driveTrain, () -> driver.getLeftY(), () -> driver.getRightX()));
    new JoystickButton(this.operator, 5).whileTrue(new ShootTorus(shooter, () -> operator.getLeftX()));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // returning null, hopefull won't crash
    return null;
  }
}
