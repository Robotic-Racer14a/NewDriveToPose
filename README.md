# FRC Base Code

This project is the starting point for Team 1322 coding projects

## To-Do List

* Generate TunerConstants.java through CTRE's TunerX

  * Here are the guides if you get stuck https://v6.docs.ctr-electronics.com/en/latest/docs/tuner/tuner-swerve/index.html
* Set Team Number in project

  * This is done by clicking the WPILib Icon in VSCode and typing in 'Set Team Number'
* Set Current Limits of swerve

  * Slip Current - 80A
  * Drive Supply Current - 50A
  * Steer Supply Current - 20A
* Tune Swerve

  * Increase kS Value to highest point before movement

    * Will need to increase it until movement is seen then decrease
  * Follow https://docs.wpilib.org/en/stable/docs/software/advanced-controls/introduction/tuning-turret.html for steer motor
  * Follow https://docs.wpilib.org/en/stable/docs/software/advanced-controls/introduction/tuning-flywheel.html for drive motor
* Change the limelight name in periodic
* Tune Drive To Pose

  * Max Velocity and Acceleration components need to be initialized to correct values before this step

