// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
  VictorSPX intake;
  CANSparkMax wrist;

  public IntakeSubsystem(int intakeID, int wristID) {
    this.intake = new VictorSPX(intakeID);
    this.wrist = new CANSparkMax(wristID, MotorType.kBrushless);
    this.intake.setInverted(false);
    this.wrist.setInverted(true);
  }

  public void setIntake(double speed){
    intake.set(ControlMode.PercentOutput, speed);
  }

  public void setWrist(double speed){
    wrist.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
