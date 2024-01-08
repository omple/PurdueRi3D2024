// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

public class ShootTorus extends Command {
  /** Creates a new ShootTorus. */
  ShooterSubsystem shooterSubsystem;
  DoubleSupplier pow;
  BooleanSupplier readyToShoot;
  public ShootTorus(ShooterSubsystem shooterSubsystem, DoubleSupplier pow, BooleanSupplier readyToShoot) {
    this.shooterSubsystem = shooterSubsystem;
    this.pow = pow;
    this.readyToShoot = readyToShoot;
    addRequirements(shooterSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooterSubsystem.setShooter(0);
    shooterSubsystem.setFeeder(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooterSubsystem.setShooter(pow.getAsDouble());

    if(readyToShoot.getAsBoolean()){
      System.out.print(readyToShoot.getAsBoolean());
      shooterSubsystem.setFeeder(1);
    }
      
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooterSubsystem.setShooter(0);
    shooterSubsystem.setFeeder(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
