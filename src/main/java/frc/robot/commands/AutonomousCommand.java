// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class AutonomousCommand extends CommandBase {
  /** Creates a new AutonomousDrive. */
  public AutonomousCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.m_robotContainer.driveSubsystem.stop();
    Robot.m_robotContainer.intakeSubsystem.stop();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Gets the distance from object from a DIO ultrasonic sensor
    double ultrasonicRange = RobotMap.ultrasonic.getRangeInches();
    // Analog voltage to range in inches converter
    /*
     * Based on the type of ultrasonic sensor, use one of these two variables for
     * the range
     */
    double analogDistFromObj = RobotMap.getDistFromObj();
    double analogDistFromBall = RobotMap.getDistFromBall();
    moveRobot(analogDistFromObj);
    runIntake(analogDistFromBall);
  }

  private void runIntake(double analogDistFromBall) {
    if (analogDistFromBall <= 20)
      Robot.m_robotContainer.intakeSubsystem.intake();
    else 
      Robot.m_robotContainer.intakeSubsystem.stop();
  }

  private void moveRobot(double analogDistFromObj) {
    if (analogDistFromObj >= 20)
      Robot.m_robotContainer.driveSubsystem.drive(Constants.slowRobotSpeed, 0);
    else 
      Robot.m_robotContainer.driveSubsystem.stop();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.m_robotContainer.driveSubsystem.stop();
    Robot.m_robotContainer.intakeSubsystem.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
