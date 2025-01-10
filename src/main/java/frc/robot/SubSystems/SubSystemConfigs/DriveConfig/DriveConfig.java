package frc.robot.SubSystems.SubSystemConfigs.DriveConfig;

import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;

public class DriveConfig {
    private int gearRatio;
    private double[] backLeftPosition;
    private double[] backRightPosition;
    private double[] frontLeftPosition;
    private double[] frontRightPosition;
    private FeedbackSensor turnFeedBackSensor;

    public int getGearRatio() {
        return gearRatio;
    }

    public double getBackLeftPosition(int index){
        return backLeftPosition[index];
    }

    public double getBackRightPosition(int index){
        return backRightPosition[index];
    }

    public double getFrontLeftPosition(int index){
        return frontLeftPosition[index];
    }

    public double getFrontRightPosition(int index){
        return frontRightPosition[index];
    }

    //pid settings for each turn 
    //pid settings for each drive 

}
