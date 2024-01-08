// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */
  VictorSPX feeder;
  CANSparkMax shooter;
  public ShooterSubsystem(int shooterMotorID, int feederID) {
    this.shooter = new CANSparkMax(shooterMotorID, MotorType.kBrushless);
    this.feeder = new VictorSPX(feederID);
    this.shooter.setInverted(false);
    this.feeder.setInverted(false);
  }

  public void setShooter(double speed){
    shooter.set(speed);
  }

  public void setFeeder(double speed){
    feeder.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
