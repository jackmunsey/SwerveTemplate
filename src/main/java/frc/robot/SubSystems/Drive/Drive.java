// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.SubSystems.Drive;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.SubSystems.SubSystemConfigs.DriveConfig.DriveConfig;

public class Drive extends SubsystemBase {
  private DriveConfig mConfig;
  Translation2d m_backRightLocation;
  Translation2d m_backLeftLocation;
  Translation2d m_frontLeftLocation;
  Translation2d m_frontRightLocation;

  /** Creates a new Drive. */
  public Drive(DriveConfig mConfig) {
    this.mConfig = mConfig;

    m_backLeftLocation = new Translation2d(mConfig.getBackLeftPosition(0), mConfig.getBackLeftPosition(1));
    m_backRightLocation = new Translation2d(mConfig.getBackRightPosition(0), mConfig.getBackRightPosition(1));
    m_frontLeftLocation = new Translation2d(mConfig.getFrontLeftPosition(0), mConfig.getFrontLeftPosition(1));
    m_frontRightLocation = new Translation2d(mConfig.getFrontRightPosition(0), mConfig.getFrontRightPosition(1));

    SwerveDriveKinematics m_kinematics = new SwerveDriveKinematics(
      m_backLeftLocation, m_backRightLocation, m_frontLeftLocation, m_frontRightLocation);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
