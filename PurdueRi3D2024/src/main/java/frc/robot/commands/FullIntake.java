// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class FullIntake extends Command {
  /** Creates a new FullIntake. */
  IntakeSubsystem intakeSubsystem;
  ShooterSubsystem shooterSubsystem;
  DoubleSupplier pow;
  public FullIntake(IntakeSubsystem intakeSubsystem, ShooterSubsystem shooterSubsystem, DoubleSupplier pow) {
    this.intakeSubsystem = intakeSubsystem;
    this.shooterSubsystem = shooterSubsystem;
    this.pow = pow;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intakeSubsystem,shooterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intakeSubsystem.setIntake(pow.getAsDouble());
    shooterSubsystem.setFeeder(pow.getAsDouble() * .5);
    shooterSubsystem.setShooter(pow.getAsDouble() * .5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.setIntake(0);
    shooterSubsystem.setFeeder(0);
    shooterSubsystem.setShooter(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
