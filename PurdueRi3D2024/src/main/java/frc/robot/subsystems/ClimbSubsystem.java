// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimbSubsystem extends SubsystemBase {
  /** Creates a new ClimbSubsystem. */
  VictorSP left, right;

  public ClimbSubsystem(int leftID, int rightID) {
    left = new VictorSP(leftID);
    right = new VictorSP(rightID);
    left.setInverted(false);
    right.setInverted(false);
  }

  public void setClimb(double leftPow, double rightPow){
    left.set(leftPow);
    right.set(rightPow);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
