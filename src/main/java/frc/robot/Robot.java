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
    DriveSubsystem drivetrain = TunerConstants.createDrivetrain();
    Superstructure superstructure = new Superstructure(drivetrain);
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

    @Override
    public void autonomousPeriodic() {
        drivetrain.setDriveToPoseState();

        if (step == 0) {
            drivetrain.setTargetPose(new Pose2d(3, 0, Rotation2d.k180deg));
            if (drivetrain.isDriveToPoseAtPosition(0.75)) {
                step = 10;
            }
        } else if (step == 10) {
            drivetrain.setTargetPose(new Pose2d(8, 5, Rotation2d.k180deg));
            if (drivetrain.isDriveToPoseAtPosition(0.75)) {
                step = 20;
            }
        } else if (step == 20) {
            drivetrain.setTargetPose(new Pose2d(0, 2, Rotation2d.k180deg));
            if (drivetrain.isDriveToPoseAtPosition(0.75)) {
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
