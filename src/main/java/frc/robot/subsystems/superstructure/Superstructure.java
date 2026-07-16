package frc.robot.subsystems.superstructure;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.DriveSubsystem;

public class Superstructure extends SubsystemBase {

    public enum SystemState {
        IDLE,
        INTAKE,
        SCORE
    }

    SystemState targetState = SystemState.IDLE;
    SystemState currentState = SystemState.IDLE;

    DriveSubsystem drivetrain;
    
    public Superstructure(DriveSubsystem drivetrain) {
        this.drivetrain = drivetrain;
    }

    @Override
    public void periodic() {

    }

    public void setTargetState(SystemState target) {
        targetState = target;
    }
}
