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

public class Robot extends TimedRobot {
    DriveSubsystem drivetrain = TunerConstants.createDrivetrain();
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

    @Override
    public void autonomousInit() {}

    @Override
    public void autonomousPeriodic() {
        drivetrain.setTargetPose(new Pose2d(0, 0, Rotation2d.k180deg));
        drivetrain.setDriveToPoseState();
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
