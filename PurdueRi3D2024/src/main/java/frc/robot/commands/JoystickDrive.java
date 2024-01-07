// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrain;

public class JoystickDrive extends Command {
  /** Creates a new JoystickDrive. */
  DoubleSupplier forwardPow, turnPow;
  DriveTrain tank;
  public JoystickDrive(DriveTrain tank, DoubleSupplier forwardPow, DoubleSupplier turnPow) {
    this.tank = tank;
    this.forwardPow =  forwardPow;
    this.turnPow = turnPow;
    addRequirements(tank);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    tank.drive(forwardPow.getAsDouble(), turnPow.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    tank.drive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
