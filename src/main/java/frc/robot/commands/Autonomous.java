// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Timer;

public class AutonomousCommand extends CommandBase {
  /** Creates a new AutonomousDrive. */
  static double initTime;
  Timer clock = new Timer();
  public AutonomousCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    initTime = clock.get();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.m_robotContainer.driveSubsystem.stop();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Gets the distance from object from a DIO ultrasonic sensor
    // double ultrasonicRange = RobotMap.ultrasonic.getRangeInches();
    // Analog voltage to range in inches converter
    /*
     * Based on the type of ultrasonic sensor, use one of these two variables for
     * the range
     */
    // double analogDistFromObj = RobotMap.getDistFromObj();
    // double analogDistFromBall = RobotMap.getDistFromBall();
    double timePassed = clock.get() - initTime;
    if (timePassed <= 5) {
        moveRobot();
    } else if ((timePassed > 5) && (timePassed < 7)) {
        turnRobot();
    }
   
  }

  private void turnRobot() {
    Robot.m_robotContainer.driveSubsystem.drive(Constants.slowRobotSpeed, 90);
  }


  private void moveRobot() {
    Robot.m_robotContainer.driveSubsystem.drive(Constants.slowRobotSpeed, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.m_robotContainer.driveSubsystem.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
