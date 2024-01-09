// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.FullIntake;
import frc.robot.commands.JoystickDrive;
import frc.robot.commands.MoveClimb;
import frc.robot.commands.MoveWrist;
import frc.robot.commands.PowerPivot;
import frc.robot.commands.ShootTorus;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.PivotSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  XboxController driver, operator;
  DriveTrain driveTrain;
  ShooterSubsystem shooter;
  IntakeSubsystem intake;
  PivotSubsystem pivot;
  ClimbSubsystem climb;
  public RobotContainer() {
    //not necessary at all but setting ports to constants makes it moderately easier? this is ro3d tho, might not be necessary -BJT
    this.driver = new XboxController(0);
    this.operator = new XboxController(1);
    this.driveTrain = new DriveTrain(2, 5, 9, 10);
    this.shooter = new ShooterSubsystem(4,8, 13);
    this.intake = new IntakeSubsystem(7, 3);
    this.pivot = new PivotSubsystem(1, 11);
    this.climb = new ClimbSubsystem(12, 6);
    
    // Configure the trigger bindings
    configureBindings();
  }

  private void configureBindings() {
    // driving command
    driveTrain.setDefaultCommand(new JoystickDrive(driveTrain, () -> -driver.getLeftY(), () -> driver.getRightX()));
    
    // change this number to change the shooting speed, press button to shoot
    new JoystickButton(this.operator, XboxController.Button.kA.value).whileTrue(new ShootTorus(shooter, () -> 1, () -> operator.getYButton()));

    // will power arm up and down with power
    new JoystickButton(this.operator, XboxController.Button.kB.value).whileTrue(new PowerPivot(pivot, () -> operator.getLeftX()));

    // pivot the wrist
    new JoystickButton(this.operator, XboxController.Button.kX.value).whileTrue(new MoveWrist(intake, () -> operator.getLeftX()));

    // climb robot
    new JoystickButton(this.operator, XboxController.Button.kRightBumper.value).whileTrue(new MoveClimb(climb, () -> -operator.getLeftY(), () -> -operator.getRightY()));

    // this is the operator triggers, runs all the intake motors
    new Trigger(() -> Math.abs(operator.getRightTriggerAxis() - operator.getLeftTriggerAxis()) > 0.1).whileTrue(new FullIntake(intake, shooter, () -> (operator.getRightTriggerAxis() - operator.getLeftTriggerAxis())));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // returning null, hopefull won't crash
    // it likely will, null references tend to piss off roborio. returning a blank one might be better -BJT
    return null;
  }
}
