package frc.robot;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import frc.robot.subsystems.DriveSubsystem;

public class AutoHelper{
    
    DriveSubsystem drive;

    public AutoHelper(DriveSubsystem drive) {
        this.drive = drive;
    }

    int exitRightBumpStep = 0;
    public boolean leaveAllianceZoneRightBump() {
        if (exitRightBumpStep == 0) {
            drive.setTargetPose(new Pose2d(3, 2.5, Rotation2d.k180deg));
            if (drive.isDriveToPoseAtPosition(0.05)) exitRightBumpStep = 10;
        } else if (exitRightBumpStep == 10) {
            drive.setTargetPose(new Pose2d(6, 2.5, Rotation2d.k180deg));
            if (drive.isDriveToPoseAtPosition(0.5)) exitRightBumpStep = 20;
        } else {
            exitRightBumpStep = 0;
            return true;
        }
        return false;
    }

    int returnRightBumpStep = 0;
    public boolean returnAllianceZoneRightBump() {
        if (returnRightBumpStep == 0) {
            drive.setTargetPose(new Pose2d(6, 2.5, Rotation2d.k180deg));
            if (drive.isDriveToPoseAtPosition(0.05)) returnRightBumpStep = 10;
        } else if (returnRightBumpStep == 10) {
            drive.setTargetPose(new Pose2d(3, 2.5, Rotation2d.k180deg));
            if (drive.isDriveToPoseAtPosition(0.5)) returnRightBumpStep = 20;
        } else {
            returnRightBumpStep = 0;
            return true;
        }
        return false;
    }

}
