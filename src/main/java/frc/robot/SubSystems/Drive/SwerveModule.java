// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.SubSystems.Drive;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveModule extends SubsystemBase {
  private SwerveModuleState desiredState;
  private SparkMax mDriveMotor;
  private SparkMax mTurnMotor;
  private SparkClosedLoopController mTurnController;
  private AbsoluteEncoder mTurnEncoder;
  

  /** Creates a new SwerveModule. */
  public SwerveModule(SparkMax driveMotor, SparkMax turnMotor, SparkClosedLoopController turnController, AbsoluteEncoder turnEncoder) {
    this.mDriveMotor = driveMotor;
    this.mTurnMotor = turnMotor;
    this.mTurnEncoder = turnEncoder;
  }

  public void setSwerveModuleStates(SwerveModuleState desiredState) {
    this.desiredState = desiredState;
  }
  //use rev pids to set desired state to the actual state




  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
