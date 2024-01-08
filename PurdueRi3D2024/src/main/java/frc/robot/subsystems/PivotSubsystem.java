// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PivotSubsystem extends SubsystemBase {
  /** Creates a new PivotSubsystem. */
  VictorSPX pivot1, pivot2;
  
  public PivotSubsystem(int pivot1ID, int pivot2ID) {
    pivot1 = new VictorSPX(pivot1ID);
    pivot2 = new VictorSPX(pivot2ID);
    pivot1.setInverted(false);
    pivot2.setInverted(false);

    pivot2.follow(pivot1);
  }

  public void setPivot(double pow){
    pivot1.set(ControlMode.PercentOutput, pow);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
