// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.generated.TunerConstants;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.superstructure.Superstructure;

public class Robot extends TimedRobot {
    public DriveSubsystem drivetrain = TunerConstants.createDrivetrain();
    public Superstructure superstructure = new Superstructure(drivetrain);
    CommandXboxController driveController = new CommandXboxController(0);
    CommandXboxController operatorController = new CommandXboxController(1);


    public Robot() {
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();

    }

    @Override
    public void disabledInit() {}

    @Override
    public void disabledPeriodic() {}

    @Override
    public void disabledExit() {}

    int step = 0;
    @Override
    public void autonomousInit() {
        step = 0;
    }

    AutoHelper autoHelper = new AutoHelper(this);
    @Override
    public void autonomousPeriodic() {
        drivetrain.setDriveToPoseState();

        if (step == 0) {
            if (autoHelper.leaveAllianceZoneRightBump()) {
                step = 10;
            }
        } else if (step == 10) {
            drivetrain.setTargetPose(new Pose2d(7, 0.75, Rotation2d.kCCW_90deg));
            if (drivetrain.isDriveToPoseAtPosition(0.75)) {
                step = 20;
            }
        } else if (step == 20) {
            drivetrain.setTargetPose(new Pose2d(8, 4, Rotation2d.kCCW_90deg));
            if (drivetrain.isDriveToPoseAtPosition(0.75)) {
                step = 30;
            }
        } else if (step == 30) {
            drivetrain.setTargetPose(new Pose2d(6, 3, Rotation2d.k180deg));
            if (drivetrain.isDriveToPoseAtPosition(0.75)) {
                step = 40;
            }
        } else if (step == 40) {
            if (autoHelper.returnAllianceZoneRightBump()) {
                step = 50;
            }
        } else if (step == 50) {
            drivetrain.setTargetPose(new Pose2d(1, 1, Rotation2d.k180deg));
            if (drivetrain.isDriveToPoseAtPosition(0.1)) {
                step = 0;
            }
        }
    }

    @Override
    public void autonomousExit() {}

    @Override
    public void teleopInit() {}

    @Override
    public void teleopPeriodic() {
        drivetrain.setFieldCentricState(driveController.getLeftX(), driveController.getLeftY(), driveController.getRightX());
    }

    @Override
    public void teleopExit() {}

    @Override
    public void testInit() {
        CommandScheduler.getInstance().cancelAll();
    }

    @Override
    public void testPeriodic() {}

    @Override
    public void testExit() {}

    @Override
    public void simulationPeriodic() {}
}
