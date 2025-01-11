// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.jni.CANSparkJNI;
import com.revrobotics.spark.SparkAbsoluteEncoder;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.SubSystems.Drive.Drive;
import frc.robot.SubSystems.Drive.SwerveModule;
import frc.robot.SubSystems.SubSystemConfigs.DriveConfig.BackLeftDriveConfig;
import frc.robot.SubSystems.SubSystemConfigs.DriveConfig.BackRightDriveConfig;
import frc.robot.SubSystems.SubSystemConfigs.DriveConfig.DriveConfig;
import frc.robot.SubSystems.SubSystemConfigs.DriveConfig.FrontLeftDriveConfig;
import frc.robot.SubSystems.SubSystemConfigs.DriveConfig.FrontRightDriveConfig;

public class RobotContainer {
  private SwerveModule mBackLeftDrive;
  private BackLeftDriveConfig mBackLeftDriveConfig;

  private SwerveModule mBackRightDrive;
  private BackRightDriveConfig mBackRightDriveConfig;

  private SwerveModule mFrontLeftDrive;
  private FrontLeftDriveConfig mFrontLeftDriveConfig;

  private SwerveModule mFrontRightDrive;
  private FrontRightDriveConfig mFrontRightDriveConfig;

  private SwerveModule[] mSwerveModules;

  private Drive mDrive;
  private DriveConfig mDriveConfig;

  public RobotContainer() {
    // Configure Swerve Modules

    // Back Left
    SparkMax backLeftDriveMotor = new SparkMax(mBackLeftDriveConfig.getDriveId(), mBackLeftDriveConfig.getDriveMotorType());
    SparkMax backLeftTurnMotor = new SparkMax(mBackLeftDriveConfig.getTurnId(), mBackLeftDriveConfig.getTurnMotorType());
    SparkClosedLoopController backLeftTurnPID = backLeftTurnMotor.getClosedLoopController();
    
    AbsoluteEncoder backLeftTurnEncoder = backLeftTurnMotor.getAbsoluteEncoder();
    backLeftDriveMotor.configure(mBackLeftDriveConfig.getDriveCondfig(), ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    backLeftTurnMotor.configure(mBackLeftDriveConfig.getTurnConfig(), ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    mBackLeftDrive = new SwerveModule(backLeftDriveMotor, backLeftTurnMotor, backLeftTurnPID, backLeftTurnEncoder);

    // Back Right
    SparkMax backRightDriveMotor = new SparkMax(mBackRightDriveConfig.getDriveId(), mBackRightDriveConfig.getDriveMotorType());
    SparkMax backRightTurnMotor = new SparkMax(mBackRightDriveConfig.getTurnId(), mBackRightDriveConfig.getTurnMotorType());
    SparkClosedLoopController backRightTurnPID = backRightTurnMotor.getClosedLoopController();
    
    AbsoluteEncoder backRightTurnEncoder = backRightTurnMotor.getAbsoluteEncoder();
    backRightDriveMotor.configure(mBackRightDriveConfig.getDriveCondfig(), ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    backRightTurnMotor.configure(mBackRightDriveConfig.getTurnConfig(), ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    mBackRightDrive = new SwerveModule(backRightDriveMotor, backRightTurnMotor, backRightTurnPID, backRightTurnEncoder);

    // Front Left
    SparkMax frontLeftDriveMotor = new SparkMax(mFrontLeftDriveConfig.getDriveId(), mFrontLeftDriveConfig.getDriveMotorType());
    SparkMax frontLeftTurnMotor = new SparkMax(mFrontLeftDriveConfig.getTurnId(), mFrontLeftDriveConfig.getTurnMotorType());
    SparkClosedLoopController frontLeftTurnPID = frontLeftTurnMotor.getClosedLoopController();
    
    AbsoluteEncoder frontLeftTurnEncoder = frontLeftTurnMotor.getAbsoluteEncoder();
    frontLeftDriveMotor.configure(mFrontLeftDriveConfig.getDriveCondfig(), ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    frontLeftTurnMotor.configure(mFrontLeftDriveConfig.getTurnConfig(), ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    mFrontLeftDrive = new SwerveModule(frontLeftDriveMotor, frontLeftTurnMotor, frontLeftTurnPID, frontLeftTurnEncoder);

    // Front Right
    SparkMax frontRightDriveMotor = new SparkMax(mFrontRightDriveConfig.getDriveId(), mFrontRightDriveConfig.getDriveMotorType());
    SparkMax frontRightTurnMotor = new SparkMax(mFrontRightDriveConfig.getTurnId(), mFrontRightDriveConfig.getTurnMotorType());
    SparkClosedLoopController frontRightTurnPID = frontRightTurnMotor.getClosedLoopController();
    
    AbsoluteEncoder frontRightTurnEncoder = frontRightTurnMotor.getAbsoluteEncoder();
    frontRightDriveMotor.configure(mFrontRightDriveConfig.getDriveCondfig(), ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    frontRightTurnMotor.configure(mFrontRightDriveConfig.getTurnConfig(), ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    mFrontRightDrive = new SwerveModule(frontRightDriveMotor, frontRightTurnMotor, frontRightTurnPID, frontRightTurnEncoder);

    mSwerveModules = new SwerveModule[]{mBackRightDrive, mBackLeftDrive, mFrontRightDrive, mFrontLeftDrive};

    mDrive = new Drive(mDriveConfig, mSwerveModules);

    configureBindings();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
