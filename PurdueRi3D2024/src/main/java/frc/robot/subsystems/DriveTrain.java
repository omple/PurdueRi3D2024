// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  DifferentialDrive tank;
  VictorSPX frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor;
  public DriveTrain(int frontLeft, int backLeft, int frontRight, int backRight) {
    frontLeftMotor = new VictorSPX(frontLeft);
    backLeftMotor = new VictorSPX(backLeft);
    frontLeftMotor.setInverted(false);
    backLeftMotor.setInverted(false);
    backLeftMotor.follow(frontLeftMotor);

    frontRightMotor = new VictorSPX(frontRight);
    backRightMotor = new VictorSPX(backRight);
    frontRightMotor.setInverted(false);
    backRightMotor.setInverted(false);
    backRightMotor.follow(frontRightMotor);

  }

  public void drive(double forward, double turn){
    frontLeftMotor.set(ControlMode.PercentOutput, forward + turn);
    frontRightMotor.set(ControlMode.PercentOutput, forward - turn);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
