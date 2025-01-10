// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.SubSystems.Drive;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveModule extends SubsystemBase {
  private SparkMax mDrive;
  private SparkMax mTurn;
  private AbsoluteEncoder mTurnEncoder;
  private SparkClosedLoopController mPID;
  

  /** Creates a new SwerveModule. */
  public SwerveModule(SparkMax drive, SparkMax turn, AbsoluteEncoder turnEncoder) {
    this.mDrive = drive;

    this.mTurn = turn;
    this.mTurnEncoder = turnEncoder;
    this.mPID = mTurn.getClosedLoopController();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
