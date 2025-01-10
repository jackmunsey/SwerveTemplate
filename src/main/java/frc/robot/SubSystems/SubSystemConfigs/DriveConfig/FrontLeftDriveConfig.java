package frc.robot.SubSystems.SubSystemConfigs.DriveConfig;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

public class FrontLeftDriveConfig {
    private String name;

    private int turnId;
    private int turnCurrentLimit;
    private MotorType turnMotorType;
    private IdleMode turnIdle;
    private boolean turnInverted;
    private SparkMaxConfig turnConfig = new SparkMaxConfig();
    
    private int driveId;
    private int driveCurrentLimit;
    private MotorType driveMotorType;
    private IdleMode driveIdle;
    private boolean driveInverted;
    private SparkMaxConfig driveCondfig = new SparkMaxConfig();

    public int getTurnCurrentLimit() {
        return turnCurrentLimit;
    }

    public int getDriveCurrentLimit() {
        return driveCurrentLimit;
    }


    public MotorType getDriveMotorType() {
        return driveMotorType;
    }
    
    public SparkMaxConfig getDriveCondfig() {
        driveCondfig.inverted(driveInverted).idleMode(driveIdle);
        return driveCondfig;
    }

    public int getTurnId() {
        return turnId;
    }

    public int getDriveId() {
        return driveId;
    }

    public String getName() {
        return name;
    }

    public MotorType getTurnMotorType() {
        return turnMotorType;
    }

    public IdleMode getDriveIdle() {
        return driveIdle;
    }

    public IdleMode getTurnIdle() {
        return turnIdle;
    }

    public boolean isDriveInverted() {
        return driveInverted;
    }

    public boolean isTurnInverted() {
        return turnInverted;
    }

    public SparkMaxConfig getTurnConfig() {
        turnConfig.inverted(turnInverted).idleMode(turnIdle);
        return turnConfig;
    }

}
