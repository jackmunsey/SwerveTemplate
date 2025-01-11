package frc.robot.SubSystems.SubSystemConfigs.DriveConfig;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

public class BackLeftDriveConfig {
    private String name = "test";

    private int turnId = 1;
    private int turnCurrentLimit = 1;
    private MotorType turnMotorType = MotorType.kBrushless;
    private IdleMode turnIdle = IdleMode.kBrake;
    private boolean turnInverted = true;
    private SparkMaxConfig turnConfig = new SparkMaxConfig();

    private int P = 1;
    private int I = 1;
    private int D = 1;
    private FeedbackSensor turnFeedBackSensor = FeedbackSensor.kPrimaryEncoder;
    
    private int driveId = 1;
    private int driveCurrentLimit = 1;
    private MotorType driveMotorType = MotorType.kBrushless;
    private IdleMode driveIdle = IdleMode.kBrake;
    private boolean driveInverted = true;
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
        turnConfig.closedLoop.feedbackSensor(turnFeedBackSensor).pid(P, I, D);
        return turnConfig;
    }

}
