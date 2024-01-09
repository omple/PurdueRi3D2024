// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimbSubsystem extends SubsystemBase {
  /** Creates a new ClimbSubsystem. */
  VictorSPX right, left;

  public ClimbSubsystem(int leftID, int rightID) {
    left = new VictorSPX(leftID);
    right = new VictorSPX(rightID);
    left.setInverted(false);
    right.setInverted(true);
    
  }

  public void setClimb(double leftPow, double rightPow){
    left.set(ControlMode.PercentOutput, leftPow);
    right.set(ControlMode.PercentOutput, rightPow);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
