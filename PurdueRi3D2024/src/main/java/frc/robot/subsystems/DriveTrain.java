// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  DifferentialDrive tank;

  public DriveTrain(int frontLeft, int backLeft, int frontRight, int backRight) {
    VictorSP frontLeftMotor = new VictorSP(frontLeft);
    VictorSP backLeftMotor = new VictorSP(backLeft);
    frontLeftMotor.setInverted(false);
    backLeftMotor.setInverted(false);
    frontLeftMotor.addFollower(backLeftMotor);

    VictorSP frontRightMotor = new VictorSP(frontRight);
    VictorSP backRightMotor = new VictorSP(backRight);
    frontRightMotor.setInverted(false);
    backRightMotor.setInverted(false);
    frontRightMotor.addFollower(backRightMotor);

    tank = new DifferentialDrive(frontLeftMotor, frontRightMotor);
  }

  public void drive(double forward, double turn){
    tank.arcadeDrive(forward, turn, true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
