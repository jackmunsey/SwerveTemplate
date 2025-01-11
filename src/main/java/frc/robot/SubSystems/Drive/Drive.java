// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.SubSystems.Drive;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.Kinematics;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.SubSystems.SubSystemConfigs.DriveConfig.DriveConfig;

public class Drive extends SubsystemBase {
  private DriveConfig mConfig;
  private SwerveModule[] mSwerveModules;
  Translation2d m_backRightLocation;
  Translation2d m_backLeftLocation;
  Translation2d m_frontLeftLocation;
  Translation2d m_frontRightLocation;
  ChassisSpeeds speeds;
  SwerveDriveKinematics m_kinematics;
  SwerveModuleState[] moduleStates;

  /** Creates a new Drive. */
  public Drive(DriveConfig config, SwerveModule[] swerveModules) {
    this.mConfig = config;
    this.mSwerveModules = swerveModules;

    speeds = new ChassisSpeeds(0, 0, 0);

    m_backLeftLocation = new Translation2d(mConfig.getBackLeftPosition(0), mConfig.getBackLeftPosition(1));
    m_backRightLocation = new Translation2d(mConfig.getBackRightPosition(0), mConfig.getBackRightPosition(1));
    m_frontLeftLocation = new Translation2d(mConfig.getFrontLeftPosition(0), mConfig.getFrontLeftPosition(1));
    m_frontRightLocation = new Translation2d(mConfig.getFrontRightPosition(0), mConfig.getFrontRightPosition(1));

    m_kinematics = new SwerveDriveKinematics(
      m_backLeftLocation, m_backRightLocation, m_frontLeftLocation, m_frontRightLocation);

    speeds = new ChassisSpeeds(1.0, 3.0, 1.5);

    moduleStates = m_kinematics.toSwerveModuleStates(speeds);

  }

  public void setSpeeds(int fwd, int str, int rot) {
    speeds.omegaRadiansPerSecond = rot;
    speeds.vxMetersPerSecond = fwd;
    speeds.vyMetersPerSecond = str;
  }

  public

  public SwerveModuleState[] getSwerveModuleStates() {
    return moduleStates;
  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
