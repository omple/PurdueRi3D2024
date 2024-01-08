// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PivotSubsystem extends SubsystemBase {
  /** Creates a new PivotSubsystem. */
  VictorSP pivotLeft;
  VictorSP pivotRight;

  public PivotSubsystem(int pivotLeftID, int pivotRightID) {
    this.pivotLeft = new VictorSP(pivotLeftID);
    this.pivotRight = new VictorSP(pivotRightID);
    this.pivotLeft.setInverted(false);
    this.pivotRight.setInverted(false);
    
    this.pivotLeft.addFollower(this.pivotRight);
  }

  public void setPivot(double speed) {
    this.pivotLeft.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
