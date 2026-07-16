package frc.robot.subsystems.superstructure;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.DriveSubsystem;

public class Superstructure extends SubsystemBase {

    //All states of the robot
    public enum SystemState {
        IDLE,
        INTAKE,
        SCORE
    }

    SystemState targetState = SystemState.IDLE;
    SystemState currentState = SystemState.IDLE;

    //Current instance of drivetrain
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
