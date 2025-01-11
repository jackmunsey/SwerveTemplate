// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.jni.CANSparkJNI;
import com.revrobotics.spark.SparkAbsoluteEncoder;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
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

  private Drive mDrive;
  private DriveConfig mDriveConfig;

  public RobotContainer() {
    SparkMax backLeftDriveMotor = new SparkMax(mBackLeftDriveConfig.getDriveId(), mBackLeftDriveConfig.getDriveMotorType());
    SparkMax backLeftTurnMotor = new SparkMax(mBackLeftDriveConfig.getTurnId(), mBackLeftDriveConfig.getTurnMotorType());
    
    AbsoluteEncoder backLeftTurnEncoder = backLeftTurnMotor.getAbsoluteEncoder();
    backLeftDriveMotor.configure(mBackLeftDriveConfig.getDriveCondfig(), ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    backLeftTurnMotor.configure(mBackLeftDriveConfig.getTurnConfig(), ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    mBackLeftDrive = new SwerveModule(backLeftDriveMotor, backLeftTurnMotor, backLeftTurnEncoder);

    mDrive = new Drive(mDriveConfig);

    configureBindings();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
