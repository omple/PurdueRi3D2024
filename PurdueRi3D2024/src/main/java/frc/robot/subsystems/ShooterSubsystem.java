// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */
  VictorSP shooter, feeder;
  public ShooterSubsystem(int shooterMotorID, int feederID) {
    this.shooter = new VictorSP(shooterMotorID);
    this.feeder = new VictorSP(feederID);

  }

  public void setShooterSpeed(double speed){
    shooter.set(speed);
  }

  public void setFeederSpeed(double speed){
    feeder.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
